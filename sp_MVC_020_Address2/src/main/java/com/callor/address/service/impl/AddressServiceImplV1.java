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


	//Controller에서 할 일을 Service가 대신 하게 만들어준 코드이다.
	@Override
	public List<AddressVO> searchAndPage(SearchPage searchPage) {
		return addrDao.searchAndPage(searchPage);
	}

	private static final long LIST_PER_PAGE = 10;						//한 페이지에 보여질 리스트 갯수
	private static final long PAGE_NO_COUNT = 10;						//화면 하단 페이지 번호 출력
	
	@Override  															//조건에 맞는 데이터를 가져와 pagenation을 그리기 위한 것
	public void searchAndPage(Model model, SearchPage searchPage) {
		 searchPage.setOffset(0);
		 searchPage.setLimit(addrDao.selectAll().size());
		 
		String search = searchPage.getSearch(); 						//빈 변수를 입력했을 때, 
		search = search == null ? "" : search;							//전체 데이터를 보여줄 수 있도록 하는 코드이다.
		searchPage.setSearch(search);
		 
		 List<AddressVO> adList = addrDao.searchAndPage(searchPage);	//검색 조건에 맞는 데이터 일단 select(전체 갯수 알기)
		 long totalCount = adList.size();								//밑에서 페이지 번호를 자동으로 계산하기 위해 사용.
		 if(totalCount < 1 ) return;
		 
		 long finalPageNo = totalCount / LIST_PER_PAGE; 			/*전체 데이터의 총 페이지 수 = 
		 																	전체데이터갯수 / 한 페이지 보여질 데이터 갯수. */
		 long currentPageNo = searchPage.getCurrentPageNo();		//화면 하단 페이지 번호 클릭했을 때 전달되는 값
		 currentPageNo = currentPageNo > 1 ? currentPageNo > finalPageNo ? finalPageNo : currentPageNo : 1;
		 /*									 (--------------------------------------------------------)
		    			 (--------------------------------------------------------------------------------) */

		 //선택된 페이지를 유동적으로 보여주기 위한 연산
		 long startPageNo = (currentPageNo / PAGE_NO_COUNT) * PAGE_NO_COUNT;
		 startPageNo = startPageNo < 1 ? 1 : startPageNo;
		 long endPageNo = startPageNo + PAGE_NO_COUNT;
		 endPageNo = endPageNo > finalPageNo ? finalPageNo : endPageNo;

		 
		 searchPage.setStartPageNo(startPageNo);
		 searchPage.setEndPageNo(endPageNo);
		 searchPage.setLimit(LIST_PER_PAGE);
		 searchPage.setOffset( (currentPageNo - 1) * PAGE_NO_COUNT);
		 searchPage.setFinalPageNo(finalPageNo);
		 
		 model.addAttribute("PAGE",searchPage);							//JSP로 보내기 위해 Model에 담는 코드.
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
	

}//end class
