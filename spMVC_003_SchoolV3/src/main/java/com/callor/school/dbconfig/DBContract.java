package com.callor.school.dbconfig;

public class DBContract {
	
	public static class ST { // 내부클래스이다.
		public static final String SELECT 
				= " SELECT st_num, "
				+ " st_name, st_dept, st_addr, st_tel, st_grade "
				+ " FROM tbl_student "; //여러줄 문자 나눠만들 때, 꼭 앞뒤에 빈칸 넣자.(오류방지)
		
		public static final String INSERT = "";
	}//end 내부클래스 ST
	
	public static class ST_COL {
		public static final String ST_NUM = "st_num";
		public static final String ST_NAME = "st_name";
		public static final String ST_DEPT = "st_dept";
		public static final String ST_ADDR = "st_addr";
		public static final String ST_TEL = "st_tel";
		public static final String ST_GRADE = "st_grade";
	}

}//end class
