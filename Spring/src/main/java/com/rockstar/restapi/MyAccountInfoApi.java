package com.rockstar.restapi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockstar.model.SubscriberInfo;
import com.rockstar.service.SubscriberService;

@RestController
@CrossOrigin
@RequestMapping("/myInfo")

public class MyAccountInfoApi {

	
	@Autowired
	private SubscriberService subscriberserv;
	
	@GetMapping
	public ResponseEntity<List<SubscriberInfo>> defaultAction() {
		return new ResponseEntity<>(subscriberserv.getAllSubscriberInfos(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{rmn}")
	public ResponseEntity<SubscriberInfo> getSubscriberAction(@PathVariable("rmn") int rmn) {
		ResponseEntity<SubscriberInfo> resp = null;
		SubscriberInfo newsubscriber = subscriberserv.getSubscriberInfoByRmn(rmn);
		if (newsubscriber == null)
			resp = new ResponseEntity<SubscriberInfo>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<SubscriberInfo>(newsubscriber, HttpStatus.OK);

		return (resp);
	}
	
	/*@PostMapping
	public ResponseEntity<SubscriberInfo> addSubscriberInfo(@RequestBody SubscriberInfo subscriber) {
		ResponseEntity<SubscriberInfo> resp = null;

		//if (employeeserv.existsByBasic(Employee.getBasic()))
			//resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		
		if (resp == null) {
			System.out.println(subscriber);
			SubscriberInfo c = subscriberserv.addSubscriberInfo(subscriber);
			System.out.println(c);
			if (c == null)
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(c, HttpStatus.OK);
		}
		return resp;
	}*/

	@PutMapping
	public ResponseEntity<SubscriberInfo> updateSubscriberInfo(@RequestBody SubscriberInfo subscriber) {
		ResponseEntity<SubscriberInfo> resp = null;

		SubscriberInfo c = subscriberserv.getSubscriberInfoByRmn(subscriber.getRmn());

		//if (!((employee.getBasic())==c.getBasic()))
		//	if (employeeserv.existsByBasic(employee.getBasic())) {
		//		resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		//	}

		if (resp == null) {
			c = subscriberserv.updateSubscriberInfo(subscriber);
			if (c == null)
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(c, HttpStatus.OK);
		}
		return resp;
	}

	/*@DeleteMapping("/{rmn}")
	public ResponseEntity<Void> deleteSubscriberInfo(@PathVariable("rmn") int rmn) {
		ResponseEntity<Void> resp = null;
		if (subscriberserv.deleteSubscriberInfoByRmn(rmn))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}*/
}
