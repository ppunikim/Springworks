# URL(Uniform Resource Location: 규격 자원 위치)
* 내가 찾고있는 서비스 제공하는 곳(Locator)이 어디냐?
* 예로는 
```
http://callor.com.8080/app/student/list
------ =============== ----------------
프로토콜   서버주소(port)     path(경로)
======================================== => url 
```
# URI(Uniform Resource Identifire)
* 내가 찾고있는 서비스를 제공하는 ID를 찾아라, 변수추가
* 예로는 http://callor.com.8080/app/student/list
*              -----------=> unique값
```
http://callor.com.8080/app/student/detail?num=0001  => 변수이름 노출
                                          -------- -> uri
http://callor.com.8080/app/student/detail/0001 => path variable, 값만노출
```
* URL과 URI는 거의 같은 의미이므로, 그냥 URL이라고 하면 된다.