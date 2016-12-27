package ssm.mapper;

import java.util.List;

import ssm.pojo.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByUsername(String username);
    
    Login selectTop1();

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}