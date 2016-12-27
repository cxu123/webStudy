package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.pojo.Login;
import ssm.pojo.User;
import ssm.service.ItemService;
import ssm.service.LogService;
import ssm.service.OwnedItemsService;
import ssm.service.UserService;

@Controller
public class UserInfoController {
	@Autowired
	UserService userService;
	@Autowired
	LogService logService;
	@Autowired
	ItemService itemService;
	@Autowired
	OwnedItemsService ownService;
	
	@RequestMapping("/toStore.action")
	public ModelAndView toStore(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("back", "doAction()");
		mv.addObject("itemToStore", itemService.findAllItems());
		mv.addObject("userToStore", userService.findUser(username));
		mv.setViewName("usered/store");
		return mv;
	}
	
	@RequestMapping("/toShowLog.action")
	public ModelAndView toShowLog(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<Login> logList = logService.findLog(username);
		
		mv.addObject("userToShowLog", logList);
		mv.setViewName("usered/logs");
		return mv;
	}
	
	@RequestMapping("/toShowInfo.action")
	public ModelAndView backToUserInfo(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userToShowInfo", userService.findUser(username));
		mv.setViewName("usered/Info");
		return mv;
	}
	
	@RequestMapping("/toShowOwned.action")
	public ModelAndView toShowOwned(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userToShowOwned", ownService.findOwnedItemsList(username));
		mv.addObject("userToShowname", username);
		mv.setViewName("usered/owned");
		return mv;
	}
	
	@RequestMapping("/toRecharge.action")
	public ModelAndView toRecharge(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userToRecharge",username);
		mv.setViewName("usered/recharge");
		return mv;
	}
	
	@RequestMapping("/RechargeDone.action")
	public ModelAndView RechargeDone(@RequestParam("username")String username,
			Integer recharge) throws Exception{
		if (recharge==null) {
			recharge=0;
		}
		ModelAndView mv = new ModelAndView();
		User user = userService.findUser(username);
		user.setBalance(user.getBalance()+recharge);
		userService.updateUser(user);
		
		mv.addObject("loginLog", logService.findLast().getLogintime());
		mv.addObject("loginUser",user);
		mv.setViewName("userInfo");
		return mv;
	}
}
