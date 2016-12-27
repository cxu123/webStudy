package ssm.mapper;

import java.util.List;

import ssm.pojo.OwnedItems;

public interface OwnedItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OwnedItems record);

    int insertSelective(OwnedItems record);

    List<OwnedItems> selectByUsername(String username);

    int updateByPrimaryKeySelective(OwnedItems record);

    int updateByPrimaryKey(OwnedItems record);
}