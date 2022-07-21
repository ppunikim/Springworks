# 성적처리 프로젝트
## DB 연동
* MySQL의 schoolDB

## table
* tbl_student, tbl_score, tbl_subject

## DB 연결을 위한 dependency 설정
* Spring-jdbc
* commons-dbcp2
* mybatis
* mybatis-spring
* mysql-connector/J
* spring framework : 5.2.22Release
* lombok
* logback-classic

## package 설정
* model
* persistance

## mapper folder 만들기
* mybatis-context

## VO 클래스
* tbl_student, tbl_score, tbl_subject를 참조해
각 StudentVO, ScoreVO, SubjectVO 만들기

## Dao 인터페이스
* persistance.GenericDao interface에
selectAll(), findById(), insert(), update(), delete() 선언하기

## Student 정보 요청
* http://localhost:8080/score/student 로 요청하면 학생 데이터 전체를 JSON 웹 화면에 보여주는 코드 작성
* StudentController 에 @ResponseBody가 부착된 home() method 선언
* StudentService.selectAll()
* StudentDao.selectAll()
* student-mapper.xml.selectAll


* 