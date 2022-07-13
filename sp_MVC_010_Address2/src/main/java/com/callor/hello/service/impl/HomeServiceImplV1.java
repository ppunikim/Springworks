package com.callor.hello.service.impl;

import org.springframework.stereotype.Service;

import com.callor.hello.controller.QualifyConfig;
import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;

@Service(QualifyConfig.Home_Service_V1)
public class HomeServiceImplV1 implements HomeService{

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String goodBye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String goodBye(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String ad_name, String ad_tel, String ad_addr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(AddressVO address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddressVO findByName(String ad_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
