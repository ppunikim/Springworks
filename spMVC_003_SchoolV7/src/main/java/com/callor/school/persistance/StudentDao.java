package com.callor.school.persistance;

import com.callor.school.model.StudentVO;
/*
 * GenericDao를 상속받으면서 
 * StudentVO와 String type을 Generic으로 사용하였다.
 * 결국 GenericDao에 선언된 method들은
 * 여기에서 Generic type으로 선언한 StudentVO와 String 타입을 갖는
 * method를 자동으로 구현하게 된다. 
 */
// 같은 메서드 내용이므로, 똑같은 것을 계속 쓰지 않고 상속받는 방법으로 쓴 것이 GenericDao이다.
public interface StudentDao extends GenericDao<StudentVO, String>{
	
	
	
	
}
