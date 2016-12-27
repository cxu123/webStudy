package ssm.service;

import java.util.List;

import ssm.pojo.Login;

public interface LogService {

	public List<Login> findLog(String username)throws Exception;
	
	public void addLog(Login login)throws Exception;
	
	public Login findLast()throws Exception;
}
