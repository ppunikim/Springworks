package com.callor.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.callor.school.dbconfig.DBConnection;
import com.callor.school.dbconfig.DBContract;
import com.callor.school.domain.StudentVO;

/* Dao 클래스
 * Data Access Object 
 * DB와 연동하여 SQL을 보내고, 데이터를 수신하는 기능을 수행한다.
 */

@Component // bean으로 만들어라.
public class StudentDao {
	private final Connection dbConn;

	public StudentDao() {
		dbConn = DBConnection.getDBConnection();
	}// end 기본생성자

	public List<StudentVO> selectAll() {

		/*
		 * PreparedStatement 는? JDBC 통해 DBMS에 Query를 보내고 데이터를 수신하는 객체
		 */
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;

		// SQL 문을 통해 전달할 준비
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();

			List<StudentVO> stList = new ArrayList<>();

			// 가져 올 데이터가 있냐?
			// 있으면 읽어올 수 있도록 준비해달라.
			while (rSet.next()) {

				StudentVO stVO = new StudentVO();
				stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));
				stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
				stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
				stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
				stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
				stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
				stList.add(stVO);

			} // end while
			rSet.close();
			pStr.close();

			return stList;
			// 여기까지 select 명령문을 실행하는 절차이다.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try-catch

		return null;
	} // end selectAll
	
	public StudentVO findByNum(String stNum) {
		
		PreparedStatement pStr = null;
		String sql = DBContract.ST.SELECT;
		sql += " WHERE st_num = ? ";
		
		try {
			
		pStr = dbConn.prepareStatement(sql);
		pStr.setString(1, stNum);
		
		ResultSet rSet = pStr.executeQuery();
		rSet.next();
		StudentVO stVO = new StudentVO();
		stVO.setStNum(rSet.getString(DBContract.ST_COL.ST_NUM));// rSet으로부터 () 내용 가져와 setStNum에 담아라
		stVO.setStName(rSet.getString(DBContract.ST_COL.ST_NAME));
		stVO.setStDept(rSet.getString(DBContract.ST_COL.ST_DEPT));
		stVO.setStAddr(rSet.getString(DBContract.ST_COL.ST_ADDR));
		stVO.setStTel(rSet.getString(DBContract.ST_COL.ST_TEL));
		stVO.setIntGrade(rSet.getInt(DBContract.ST_COL.ST_GRADE));
		
		rSet.close();
		pStr.close();
		return stVO;
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}






























