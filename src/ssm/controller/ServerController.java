package ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.pojo.Login;
import ssm.pojo.User;
import ssm.service.LogService;
import ssm.service.UserService;

@Controller
public class ServerController {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
	
	@RequestMapping("/registerServer.action")
	public ModelAndView registerServer(User user,
			@RequestParam("register-password")String r_password) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		if (user.getUsername().equals("")||user.getUsername().contains(" ")||
				user.getPassword().equals("")||user.getPassword().contains(" ")||
				user.getPhonenum().equals("")||user.getPhonenum().contains(" ")){
			mv.setViewName("register-f3");
			
		}else if (userService.checkExist(user.getUsername())) {
			mv.setViewName("register-f1");
		}else {
			if(user.getPassword().equals(r_password)){
				user.setBalance(0.0);
				userService.addUser(user);
				mv.addObject("register_username", user.getUsername());
				mv.setViewName("register-s");			
			}else {
				mv.setViewName("register-f2");
			}	
		}
		return mv;
	}
	
	@RequestMapping("/changePswServer.action")
	public ModelAndView changePswServer(@RequestParam("chanPsw-username")String username,
			@RequestParam("chanPsw-name")String name,
			@RequestParam("chanPsw-phonenum")String phonenum) throws Exception{
		ModelAndView mv = new ModelAndView();
		User user = userService.findUser(username);
		
		if (username.equals("")||username.contains(" ")) {
			mv.setViewName("changePsw-f3");
		}else if(userService.checkExist(username)){
			if (user.getName().equals(name)&&user.getPhonenum().equals(phonenum)) {
				mv.addObject("cpsUsername", username);
				mv.setViewName("changePsw-c");
			}else {
				mv.setViewName("changePsw-f2");
			}
		}else {
			mv.setViewName("changePsw-f1");	
		}
		
		return mv;
	}
	
	@RequestMapping("/changePswCServer.action")
	public ModelAndView changePswCServer(@RequestParam("username")String username,
			@RequestParam("chanPsw-password")String password,
			@RequestParam("chanPsw-password1")String password1) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if (password.equals("")||password.contains(" ")) {
			mv.setViewName("changePsw-c-f2");
		}else if(password.equals(password1)){
			User user = userService.findUser(username);
			user.setPassword(password);
			userService.updateUser(user);
			mv.addObject("cpsUsername", username);
			mv.setViewName("changePsw-c-s");			
		}else {
			mv.setViewName("changePsw-c-f");
		}
		return mv;
	}
	int i=0;
	Login login;
	@RequestMapping(value="/loginServer.action")
	public ModelAndView loginServer(@RequestParam("username")String username) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		Date date;
		if (i==0) {
			login = new Login();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = format.parse(format.format(new Date()));
			login.setUsername(username);
			login.setLogintime(date);
			logService.addLog(login);
		}
		i=i+1;
		
		mv.addObject("loginLog", login.getLogintime());
		mv.addObject("loginUser", userService.findUser(username));
	    mv.setViewName("userInfo");			
		return mv;
	}
}
