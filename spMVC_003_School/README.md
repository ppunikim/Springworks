# JSP coading(코딩)

## Spring Project에서 JSP코딩
### EL(Expresstion Language) tag
* Controller에 받은 데이터를 표현하는 tag
* Controller에서 model.addAttribute("변수",값) 형식으로 데이터를 보내면 ```${변수}``` 와 같이 표현한다.
* ${변수} 위치에 값을 rendering하여 html코드로 변환한다.

### JSTL(Java Serverpage standard Tag Library)
* 줄여서 taglibrary 라고 표현한다.
* 기존에 java명령을 사용하여 JSP파일에 코드를 부착하여 사용했는데, 그러한 방법은 디자이너와의 협업을 어렵게 만드는 요인이었다.
* Spring, Tomcat 연동되는 프로젝트에서는 JSPL이라는 ```확장된 개념의 tag```를 사용한다.
* JSP 파일의 상단에 tablib 를 import 하고나면 JSP파일의 html 코드에 불편함이 없는 다양한 연산코드를 추가할 수 있다.
* 가장 많이 사용하는 tag lib는 ```core``` library이다.
```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
```
* 이 코드는 현재 페이지에 import 하겠다. 라는 것이다.
* 아래에 적어야 하는 for문 역할 하는 것은 
* ```<c:forEach items="${STUDENTS}" var="stVO">```
* 로 작성을 해야한다.
