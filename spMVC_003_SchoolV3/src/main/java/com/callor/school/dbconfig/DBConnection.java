package com.callor.school.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DB 와 연결하는 Connection객체 생성
 * DB 와 연결할 때는 내부에서 통신 통로가 생성된다.
 * 만약 통신 통로가 여러개 만들어진다면 관리하기도 어렵고 
 * 		컴퓨터나 운영체제에 많은 부담이 될 것이다.
 * 
 * 한 개의 통로만 만들고 필요할 때 그 통로를 통해서 통신하도록
 * 		한다면 컴퓨터나 운영체제에 부담이 덜 것이다.
 * 
 * Connection 객체를 한 개만 생성하고
 * 필요할 때 가져다 쓸 수 있도록 만드는 기법을 "싱글톤" 기법이라고 한다.
 */
public class DBConnection {

	private static Connection conn = null;

	/*
	 * 즉, 스태틱 초기화 블럭이다. static 으로 선언된 변수를 초기화하는 코드를 작성하는 영역
	 */
	static { // 이름은 같지만 명령문이다. 성질이 다름
		// oracle DBMS와 통신할 때 도와줄 클래스, 어플리케이션
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "user2";
		String password = "12341234";

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("DB 연결 OK");
		} catch (ClassNotFoundException e) {
			System.out.println(jdbcDriver + " 가 없습니다.");
		} catch (SQLException e) {
			System.out.println("DBMS연결문제 발생");
		} // end try
	}// database에 접속하는데 꼭 필요한 정보 4가지이다.
	
	//필요할 때 conn 객체를 가져가서 사용할 수 있도록 하는 메서드이다.
	public static Connection getDBConnection() {
		return conn;
	}//return 으로 위의 conn이 가져와 진다.
	
}// end class
