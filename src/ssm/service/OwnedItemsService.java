package ssm.service;

import java.util.List;

import ssm.pojo.OwnedItems;

public interface OwnedItemsService {
	public List<OwnedItems> findOwnedItemsList(String username)throws Exception;
	 
	public void addOwnedItems(OwnedItems own)throws Exception;
	
	public void updateOwnedItems(OwnedItems own)throws Exception;
}
