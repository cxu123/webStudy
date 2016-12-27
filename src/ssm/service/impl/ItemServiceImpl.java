package ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.ItemMapper;
import ssm.pojo.Item;
import ssm.service.ItemService;

public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemMapper itemMapper;
	
	public List<Item> findAllItems() throws Exception {
		return itemMapper.selectAll();
	}

	public void updateItem(Item item) throws Exception {
		itemMapper.updateByPrimaryKey(item);
	}

	public void addItem(Item item) throws Exception {
		itemMapper.insertSelective(item);
	}

}
