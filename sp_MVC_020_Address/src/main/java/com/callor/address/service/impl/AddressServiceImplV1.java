package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.persistence.AddressDao;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddressServiceImplV1 implements AddressService{

//	private final AddressDao addrDao;
//	public AddressServiceImplV1(AddressDao addrDao) {
//		this.addrDao = addrDao;
//	}

	/* Service interface에서 Dao를 상속받고 있는 상태에서
	 * ServiceImpl 클래스에서 Dao를 생성자로 주입받는 경우 
	 *  : 생성자에서 오류생기는 경우 있다.  
	 *    (...circular reference: 무한 반복 주입 오류)
	 *    이것은 생성자 주입 대신 setter 주입으로 변경하면 오류가 없어진다.
	 *    setter주입하는 방법으로는, 밑에와 같이 만들어진다. 
	*/
	@Autowired
	private AddressDao addrDao;
	public AddressServiceImplV1() {
	}
	
	//프로젝트가 시작될 때 자동으로 table을 생성하기 위한 자동 실행 메서드이다.
	@Autowired
	public void create_table() {
		addrDao.create_addr_table();
	}

	/*원래는 이 메서드에서 Dao에 create_address_table메서드를 호출해 table 생성가능.
	  하지만 이 method에서  dao와 같은 이름의 method를 호출하면 
	  무한반복주입오류 발생 가능하므로, 위와 같이 다른 이름으로 만들어준다. 
	*/
	@Override
	public void create_addr_table() {
	}
	
	
	@Override
	public List<AddressVO> selectAll() {
		return addrDao.selectAll();
	}


	@Override
	public List<AddressVO> searchAndPage(SearchPage searchPage) {
		return addrDao.searchAndPage(searchPage);
	}

	
	
	@Override
	public AddressVO findById(long a_seq) {
		return addrDao.findById(a_seq);
	}

	@Override
	public AddressVO findByName(String a_name) {
		return addrDao.findByName(a_name);
	}

	@Override
	public AddressVO findByTel(String a_tel) {
		return addrDao.findByTel(a_tel);
	}

	@Override
	public AddressVO findByAddr(String a_address) {
		return addrDao.findByAddr(a_address);
	}

	@Override
	public int insert(AddressVO VO) {
		log.debug(VO.toString());
		int ins = addrDao.insert(VO);
		return ins;
	}

	@Override
	public int update(AddressVO vo) {
		return addrDao.update(vo);
	}

	@Override
	public int delete(long a_seq) {
		return addrDao.delete(a_seq);
	}
	
	@Override  //조건에 맞는 데이터를 가져와 pagenation을 그리기 위한 것
	public void searchAndPage(Model model, SearchPage searchPage) {
		searchPage.setLimit(addrDao.selectAll().size());
		searchPage.setOffset(0);
		
		//검색 조건에 맞는 모든 데이터를가져오기 위한 코드
		List<AddressVO> adList = addrDao.searchAndPage(searchPage);
		
		long totalCount = adList.size();
		if(totalCount < 1) return;
		
		searchPage.setListPerPage(10);			 //보여질 데이터 갯수
		searchPage.setPageNoCount(10); 			 //하단의 페이지 번호 갯수
		searchPage.setTotalCount(totalCount);    //조건에 맞는 전체 데이터 갯수
		
		long finalPageNo = (totalCount + (searchPage.getListPerPage() -1)) 
				/ searchPage.getListPerPage();	 
		//페이지 넘버 수 = 전체 데이터 갯수 + (보여지는 데이터 갯수 - 1) / 보여지는 갯수
		searchPage.setFinalPageNo(finalPageNo);
		
		if(searchPage.getCurrentPageNo() > finalPageNo) {
			searchPage.setCurrentPageNo(finalPageNo);
		}
		
		if(searchPage.getCurrentPageNo() < 1) {
			searchPage.setCurrentPageNo(1);
		}
		long startPageNo = ( (searchPage.getCurrentPageNo() - 1)
				/ searchPage.getPageNoCount() ) * searchPage.getPageNoCount() + 1 ;
		long endPageNo = startPageNo + searchPage.getPageNoCount() - 1;
		
		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		searchPage.setLimit(searchPage.getPageNoCount());
		searchPage.setOffset(searchPage.getCurrentPageNo() * searchPage.getPageNoCount());
		
		
		model.addAttribute("PAGE",searchPage);
	}










}//end class
