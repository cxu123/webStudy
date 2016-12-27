package ssm.controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.pojo.Item;
import ssm.pojo.OwnedItems;
import ssm.pojo.User;
import ssm.service.ItemService;
import ssm.service.LogService;
import ssm.service.OwnedItemsService;
import ssm.service.UserService;

@Controller
public class ItemController {
	@Autowired
	UserService userService;
	@Autowired
	LogService logService;
	@Autowired
	ItemService itemService;
	@Autowired
	OwnedItemsService ownService;


	@RequestMapping("/itemSubmit.action")
	public ModelAndView itemSubmit(HttpServletRequest request,String itemuser) throws Exception{
		ModelAndView mv = new ModelAndView();
		User user = userService.findUser(itemuser);

		List<Item> itemList = itemService.findAllItems();
		Iterator<Item> iterator=itemList.iterator();

		int i =1;
		double sumP=0.0;
		while (iterator.hasNext()) {
			Integer num;
			if (request.getParameter("item"+i).equals("")||request.getParameter("item"+i)==null) {
				num=0;
			}else {
				num=Integer.parseInt(request.getParameter("item"+i));
			}
			i=i+1;
			Item item = (Item) iterator.next();

			if (item.getNum()>=num) {
				sumP=sumP+num*item.getPrice();
			}else{
				mv.addObject("WrongInfo", "商品库存不足");
				mv.setViewName("usered/store-f");
				return mv;
			}
			if (sumP>user.getBalance()) {
				mv.addObject("WrongInfo", "余额不足");
				mv.setViewName("usered/store-f");
				return mv;
			}

		}

		Iterator<Item> iterator2=itemList.iterator();
		int o =1;
		while (iterator2.hasNext()) {
			Integer num;
			if (request.getParameter("item"+o).equals("")) {
				num=0;
			}else {
				num=Integer.parseInt(request.getParameter("item"+o));
			}
			Item item = (Item) iterator2.next();

			if (num!=0) {
				List<OwnedItems> oitemList = ownService.findOwnedItemsList(user.getUsername());
				
				if (oitemList.isEmpty()) {
					OwnedItems oitem = new OwnedItems();
					oitem.setUsername(user.getUsername());
					oitem.setItem(item.getItemname());
					oitem.setItemnum(num);
					ownService.addOwnedItems(oitem);
				}else {

					Iterator<OwnedItems> iterator3 = oitemList.iterator();
					
					int j=oitemList.size();
					while (iterator3.hasNext()) {
						OwnedItems ownedItems = (OwnedItems) iterator3.next();

						if (ownedItems.getItem().equals(item.getItemname())) {
							ownedItems.setItemnum(ownedItems.getItemnum()+num);
							ownService.updateOwnedItems(ownedItems);
						}else{
							j=j-1;
						}

						if (j==0) {
							ownedItems.setId(null);
							ownedItems.setItem(item.getItemname());
							ownedItems.setItemnum(num);
							ownService.addOwnedItems(ownedItems);
						}

					}
				}
			}

			item.setNum(item.getNum()-num);
			itemService.updateItem(item);
			o=o+1;
		}
		if (sumP==0) {
			mv.addObject("WrongInfo", "什么都没买Σ( ° △ °|||)︴。。。。");
			mv.setViewName("usered/store-s");
			return mv;
		}else {
			user.setBalance(user.getBalance()-sumP);
			userService.updateUser(user);			
		}
		

		mv.addObject("loginLog", logService.findLast().getLogintime());
		mv.addObject("loginUser",user);
		mv.setViewName("userInfo");

		return mv;
	}
	
	@RequestMapping("/toManageItem.action")
	public ModelAndView toManageItem(String name)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("itemToStore", itemService.findAllItems());
		mv.addObject("name", name);
		mv.setViewName("usered/store-manage");
		return mv;
	}
	
	@RequestMapping("/managerSubmit.action")
	public ModelAndView managerSubmit(HttpServletRequest request,String name,Item item2)throws Exception{
		ModelAndView mv = new ModelAndView();
		request.setCharacterEncoding("UTF-8");	
		Item item1 = item2;
		
		List<Item> itemList = itemService.findAllItems();
		Iterator<Item> iterator=itemList.iterator();
		
		int i =1;
		
		while (iterator.hasNext()) {
			Item item = (Item) iterator.next();
			item.setNum(Integer.parseInt(request.getParameter("itemnum"+i)));
			item.setPrice(Double.parseDouble(request.getParameter("itemprice"+i)));
			item.setInfo(request.getParameter("iteminfo"+i));
			
			itemService.updateItem(item);
			i=i+1;
			if (i==itemList.size()) {
				item1.setId(i+1);
			}
		}
		
		if (!item1.getItemname().equals("")&&item1.getNum()!=null&&item1.getPrice()!=null) {
			
			itemService.addItem(item1);
		}
		
		mv.addObject("back", "doAction2()");
		mv.addObject("itemToStore", itemService.findAllItems());
		mv.addObject("userToStore", userService.findUser(name));
		mv.setViewName("usered/store");
		return mv;
	}

}
