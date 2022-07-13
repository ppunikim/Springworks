# QualifyConfig
``` 정적 패턴 ```
*  이렇게 해주는 이유는, Service와 Controller에 각각 같은 내용을 매치하기 위해서이다.
* 이것은 클래스 명과 관련이 없다. 그와 관련된 것으로는 문자열 안의 내용이다.
* 또한 대소문자, 오타 구분을 잘 해주기 위해서이다.

# VO
```
Data를 담아서 Method 사이에 전달하기 위한 중간 역할을 하는 것이다.
```
* 즉, 물건 사기 직전의 장바구니 역할을 한다.
* 만약 method에 전달해야 할 parameter, argument가 한개일 경우에는 변수에 담으면 되는데, 그것이 두 개 초과할 경우, 
개별 변수로 선언하지 않고 VO, DTO 클래스를 선언해 그곳에 저장해 사용한다.
 
* 이것은 실질적인 데이터 객체를 상징하는 중요한 개념이다.
* 이곳에서는 private으로 선언해 밖에서 변경 불가능하게 만들고, 그 안에 내용을 채워넣을 getter, 내용을 가져올 setter를 통해 다른 클래스에서 접근한다.
* 이것은 객체지향에서 정보 은닉, 캡슐화라고 한다.
 
* 변수 명은 가급적 snake_case로 선언하는 것이 좋다. 이유는, 중요 변수와 이름 겹치지 않게 하기 위해	

# Controller
## 맨 위쪽 생성자 만들기
* 밑 코드는 String 인터페이스 주입 패턴이라고 한다.
* 이것은 응집도를 높이고 결합도는 낮추는 것이다.
* 그 이유는 interface로 만들고, 그것을 상속받은 여러 impl들을 불러올 수 있기 때문이다.
```
private final HomeService homeService;
```
## 밑에 GET, POST 에서 사용하는 코드
* form 에서 보내온 데이터를 각각의 문자열형 변수에 받기
```
public String home(String ad_name, String ad_tel, String ad_addr) {
	return "home";
}
```

* 위에서 미리 써주면, AddressVO 클래스 타입의 객체에 한꺼번에 받는 방법. 
* 위의 코드와 다르게 클래스 타입의 객체로 사용하면 가독성이 높아지고 좋다.
```
@RequestMapping(value="/",method = RequestMethod.POST)
	public String home(AddressVO address) {
	return "home";
}
```

* model 사용 -> jsp에 값을 담을 때 사용하는 것.
* jsp에서는 ADDR 로 쓰면 된다.
```
@RequestMapping(value="/findName" , method = RequestMethod.GET)
	public String findByName(String ad_name, Model model) {
	AddressVO address = homeService.findByName(ad_name);
	model.addAttribute("ADDR", address);
	return "home";
}
```

# Service(Service.Impl)
* Service를 만들고, Impl들을 implements 하면 응집도는 높아지고, 결합도는 낮아서 좋다.



# 내일 할 일은 데이터베이스 연동하는 일이다.