package ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.LoginMapper;
import ssm.pojo.Login;
import ssm.service.LogService;

public class LogServiceImpl implements LogService{
	@Autowired
	private LoginMapper loginMapper;
	
	public List<Login> findLog(String username) throws Exception {
		return loginMapper.selectByUsername(username);
	}

	public void addLog(Login login) throws Exception {
		loginMapper.insert(login);
	}

	public Login findLast() throws Exception {
		return loginMapper.selectTop1();
	}

}
