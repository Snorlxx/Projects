package com.rockstar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockstar.dao.SubscriberDao;
import com.rockstar.model.SubscriberInfo;
@Service
public class SubscriberServiceImpl implements SubscriberService {

	
	@Autowired
	private SubscriberDao subscriberdao;
	
	@Override
	public SubscriberInfo addSubscriberInfo(SubscriberInfo info) {
		return subscriberdao.save(info);
	}

	@Override
	public SubscriberInfo updateSubscriberInfo(SubscriberInfo info) {
		return subscriberdao.save(info);
	}

	@Override
	public SubscriberInfo getSubscriberInfoByRmn(int rmn) {
		SubscriberInfo subscriber=null;
		
		int count=0;
		Optional<SubscriberInfo>optEmpl=subscriberdao.findById(rmn);
		if(optEmpl.isPresent()){
			subscriber=optEmpl.get();
		}
		
		return subscriber;
	}

	@Override
	public boolean deleteSubscriberInfoByRmn(int rmn) {
		boolean isDeleted=false;
		if(subscriberdao.existsById(rmn)){
			subscriberdao.deleteById(rmn);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public List<SubscriberInfo> getAllSubscriberInfos() {
		return subscriberdao.findAll();
	}

}
