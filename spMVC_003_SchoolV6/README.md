# Spring CRUD 구현

## VO 클래스 디자인(추상화, 클래스 선언)

## 입력 Form 화면을 디자인
## Form에서 Data입력, 전송, 데이터 유효성 검사
* Form에서 입력한 데이터로 유효성 검사를 수행하는 것은
서버로 데이터를 보내기 전에 입력한 사용자에게 데이터가 잘 입력 됐나 확인하는 절차.
* Client Side Validation이라고 하는데, 보통 이때 JS코드로 수행한다.
* 데이터를 입력하고 저장(전송) button click하면 Form에 담긴 데이터는 무조건 서버로 전송이된다.
* 이러한 상황이 되면 JS코드를 사용핟여 Client Size Validation을 수행할 수 없다.
* Form에 포함된 모든 버튼의 기본 속성을 무력화 하여 무조건 데이터가 서버로 전송되는 것을 방지시켜야 한다.
* Form에 포함된 버튼의 기본속성이란 버튼을 클릭했을 때 submit event가 자동으로 수행되는 것을 말한다.
* 아래와 같이 form tag로 감싸진 버튼은 클릭을 했을때 무조건 form tag의 action 주소로 서버에 요청하도록 사전에 정의되어 있다.
* form tag내의 button에는 submit이라는 default event가 자동으로 설정된다.
* 이러한 상황에서는 js 코드를 사용하여 데이터 유효성 검사를 할 수 없다.
* 때문에 button에 submit event를 무력화 시켜야 한다.
```
<form action ="/school/score">
		<button class = "btn-yellow">서버로 보내기</button>
</form>
```
* form tag 내의 button 은 type이 ``` type ="submit"``` 이다.
* button을 클릭하면 서버가 무조건 달려가는 event가 실행된다.
* 이 button type을 ```type = "button"``` 으로 설정하면 submit event가 무력화 된다. 이 방법이 제일 쉬운 방법이다.
```
<form action ="/school/score">
		<button type = "button" class = "btn-yellow">서버로 보내기</button>
</form>
```
* 또 다른 방법으로는 form의 submit() event를 가로채는 방법도 있다.

## Controller에 데이터 수신할 method 처리
## Service로 데이터 전송
## Dao를 통해 DBMS insert 요청

## Dao를 통해 DBMS에게 Select 요청
## Service에서 받고
## Controller로 return
## JSP에 View Rendering 수행