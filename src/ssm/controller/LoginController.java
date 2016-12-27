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
import ssm.service.LogService;
import ssm.service.UserService;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
	
	@RequestMapping("/main.action")
	public String mainPage(){
		return "login";
	}
	int i=0;
	Login login;
	@RequestMapping(value="/login.action")
	public ModelAndView login(@RequestParam("username")String username,
			@RequestParam("password")String password) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		if (username.equals("")||username.contains(" ")) {
			mv.setViewName("login-f3");
		}else if (userService.checkExist(username)) {
			
			if (userService.checkPsw(username, password)) {
	
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
			}else {
				mv.setViewName("login-f1");
			}
		}else {
			mv.setViewName("login-f2");
		}
		return mv;
	}

	@RequestMapping("/register.action")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/changePsw.action")
	public String changePsw(){
		return "changePsw";
	}
}
