package com.callor.address.persistence;

import java.util.List;

import com.callor.address.model.AddressVO;

public interface AddressDao {
	
	public List<AddressVO> selectAll();
	public AddressVO findById(long a_seq);
	public AddressVO findByName(String a_name);
	public AddressVO findByTel(String a_tel);
	public AddressVO findByAddr(String a_address);
	public int insert(AddressVO VO);
	public int update(AddressVO vo);
	public int delete(long a_seq);
	
	
	public void create_addr_table();

}
