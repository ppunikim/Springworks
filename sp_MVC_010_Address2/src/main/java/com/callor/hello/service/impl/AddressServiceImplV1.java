package com.callor.hello.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.model.AddressVO;
import com.callor.hello.service.AddressService;

@Service
public class AddressServiceImplV1 implements AddressService{

	@Override
	public List<AddressVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressVO findById(long ad_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AddressVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AddressVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AddressVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AddressVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressVO> findByAddr(String addr) {
		// TODO Auto-generated method stub
		return null;
	}

}
