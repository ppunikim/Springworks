package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.MemberVO;
import com.callor.naver.persistance.MemberDao;
import com.callor.naver.service.MemberService;

@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService{

	@Override
	public List<MemberVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByEmailAndTel(String email, String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDao> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDao findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDao vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberDao vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
