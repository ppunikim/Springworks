# Form 과 Button 관계

```
<form>
	<button type="submit">
</form>
```
* 위와 같은 form tag에 포함된 button은 기본적으로 type이 ```submit```이다.

* button type이 ```submit``` 인 경우 form tag에 포함된 input의 값을 무조건 서비스로 전송하는 event가 실행된다.

* 만약 버튼을 눌렀을 때 JS코드를 사용하여 상황을 제어하고 싶으면 버튼에 type을 ```button```으로 설정한다.

* button의 타입을 ```button```으로 설정하면 모양만 button이고 아무런 역할을 수행하지 못한다.

* button의 type에는 ```reset```도 있는데, 이 타입은 form tag에 포함된 input box데이터를 모두 제거한다.