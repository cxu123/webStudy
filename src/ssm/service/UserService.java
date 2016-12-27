package ssm.service;

import java.util.List;

import ssm.pojo.User;

public interface UserService {
	
	public User findUser(String username)throws Exception;
	
	public boolean checkPsw(String username,String password)throws Exception;
	
	public boolean checkExist(String username)throws Exception;
	
	public void addUser(User user)throws Exception;
	
	public void updateUser(User user)throws Exception;
	
}
