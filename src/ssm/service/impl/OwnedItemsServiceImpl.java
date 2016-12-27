package ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.mapper.OwnedItemsMapper;
import ssm.pojo.OwnedItems;
import ssm.service.OwnedItemsService;

public class OwnedItemsServiceImpl implements OwnedItemsService {
	@Autowired
	private OwnedItemsMapper mapper;
	
	public List<OwnedItems> findOwnedItemsList(String username) throws Exception {
		
		return mapper.selectByUsername(username);
	}

	public void addOwnedItems(OwnedItems own) throws Exception {
		mapper.insertSelective(own);
	}

	public void updateOwnedItems(OwnedItems own) throws Exception {
		mapper.updateByPrimaryKey(own);
	}

}
