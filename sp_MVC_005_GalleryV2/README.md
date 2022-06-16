# 이미지 파일 갖는 게시판

* 파일 업로드를 구현하기 위한 별도의 Dependency
* Apache 재단에서 제작한 파일 업로드 도구
```
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
```

## 파일 업로드를 위한 bean설정
* 파일 업로드를 위한 bean은 root-context.xml에 작성한다.
* 여기는 프로젝트 전반에서 component(Controller, Service, Dao)와 함께 다양한 패키지에 클래스들이 공통으로 사용하는 Bean을 설정하는 부분.
* 파일 업로드와 관련된 bean 이다.






