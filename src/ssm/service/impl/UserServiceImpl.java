package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.UserMapper;
import ssm.pojo.User;
import ssm.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public User findUser(String username) throws Exception {		
		return userMapper.selectByUsername(username);
	}

	public boolean checkPsw(String username, String password) throws Exception {
			User user = findUser(username);	
			return user.getPassword().equals(password);	
	}

	public boolean checkExist(String username) throws Exception {
		User user = findUser(username);
		if(user!=null){
			return true;
		}
		return false;
	}

	public void addUser(User user) throws Exception {
		userMapper.insert(user);		
	}

	public void updateUser(User user) throws Exception {
		userMapper.updateByUsername(user);
	}

}
