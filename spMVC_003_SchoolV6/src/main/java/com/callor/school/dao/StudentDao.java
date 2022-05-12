package com.callor.school.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.school.model.StudentVO;

public interface StudentDao {
	
	//밑에 코드를 통해 모든 데이터를 select해서 List로 들어간다는 의미이다.
	@Select(" SELECT * FROM tbl_student ")
	public List<StudentVO> selectAll();
	
	@Select(" SELECT * FROM tbl_student "
			+" WHERE st_num = #{st_num} ")
	public StudentVO findByNum(String st_num);
	
	@Insert(SQL.STUDENT.INSERT)
	public int insert(StudentVO stVO);
	
	@Update(SQL.STUDENT.UPDATE)
	public int update(StudentVO stVO);
	
	@Delete("DELECT FROM tbl_student WHERE st_num = #{st_num}")
	public int delate(String st_num);

}
