package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.NewsVO;

public interface NewsDao extends GenericDao<NewsVO, String>{
	//원래 GenericDao의 내용을 직접 적어줘야 하지만, 상속받아와 간단하게 작성하면 된다.
	
	public List<NewsVO> findByTitle(String title);	//필요한 부분만 추가하면 된다.
	//주의할 점은 GenericDao의 클래스 이름과 동일하게 지으면, 제네릭에서는 필요없는 코드가 된다.
	
}//end interface
