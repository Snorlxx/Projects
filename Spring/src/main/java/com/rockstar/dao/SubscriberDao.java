package com.rockstar.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockstar.model.SubscriberInfo;

@Repository
public interface SubscriberDao extends JpaRepository<SubscriberInfo, Integer> {
	
}
