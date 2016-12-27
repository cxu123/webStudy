package ssm.service;

import java.util.List;

import ssm.pojo.Item;

public interface ItemService {
	public List<Item> findAllItems()throws Exception;
	public void updateItem(Item item)throws Exception;
	public void addItem(Item item)throws Exception;
}
