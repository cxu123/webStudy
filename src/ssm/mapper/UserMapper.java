package ssm.mapper;

import ssm.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByUsername(String username);

    int updateByUsernameSelective(User user);

    int updateByUsername(User user);
}