# tiles를 사용한 JSP Layout 만들기
* JSP의 header, nav, side, footer등을 include처리해 LAYOUT구성하는 도구
* JSP page `<%@ include file="..." %>` 형식으로 JSP파일을 구성하는데, 성능상 이슈와 JSP 관리가 어려워질 수 있기 때문에 그것을 보완하고자 하는 LAYOUT 도구이다.
* 필요한 Dependency 설정
```
<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-core</artifactId>
    <version>${org.tiles-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-extras</artifactId>
    <version>${org.tiles-version}</version>
</dependency>
```
* 
* 