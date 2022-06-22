package com.callor.ems.exec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeNaverUser {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//jasypt에 암호화 하는 코드(도구)
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		//환경변수
		Map<String, String> envList = System.getenv();
		
		String saltPass = envList.get("NAVER");
		System.out.println("salt Password : " + saltPass);
		if(saltPass == null) {
			System.out.println("NAVER 환경변수를 설정해주세요.");
			return;
		}
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String propsDir  = "./src/main/webapp/WEB-INF/spring/props";
		// map은 숫자로 그 값을 불러오는 것(배열)이 아닌, 문자(key)로 값을 불러오는 것이다.
		// 데이터의 위치를 몰라도 문자열로 불러올 수 있으므로 편리하다.
		// 대신 for 반복문 사용 불가.
		Map<String, String[]> secFiles = new TreeMap<String, String[]>();
		secFiles.put("naver.email.properties",
				new String[] {"naver.username","naver.password"}
		);
		
		/*
		System.out.println(secFiles.get("db.connection.properties")[0]);
		 mysql.username 출력된다.
		System.out.println(secFiles.get("db.connection.properties")[1]);
		 mysql.password 출력된다. */
		
		System.out.println("----------------------------");
		
		// for 반복문을 사용하기 위해 key 값만 가져오는 작업을 할 것이다.
		Set<String> files = secFiles.keySet();
		
		for(String file : files) {
			
			File prosFile = new File(propsDir, file);
			try {
				PrintWriter out = new PrintWriter(prosFile);
				System.out.println();
				System.out.println("키 이름: " + file);
				String[] datas = secFiles.get(file);
				System.out.println("=".repeat(50));
				for(String data : datas) {
					System.out.printf("%s >> " , data);
					String value = scan.nextLine();
					out.printf("%s = ENC(%s)\n",data, pbEnc.encrypt(value));
				}
				out.flush();
				out.close();
				System.out.println("File Write OK!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}// File을 try/catch한 이유는 props 폴더에 파일 생성하기 위해서 쓰는 것이다.
		
	}//end main
}//end class