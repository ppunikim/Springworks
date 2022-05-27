document.addEventListener("DOMContentLoaded", () => {
  const id_check = document.querySelector("button.id-check");
  const join_btn = document.querySelector("button.join");
  //두 개의 클래스 버튼을 java script로 등록하기.
  const join_form = document.querySelector("form.join");

  const index = {
    username: 0,
    password: 1,
    re_password: 2,
    name: 3,
    email: 4,
  };
  //form.join 내부에 있는 모든 input박스를 말한다.
  //SelectAll을 사용하면 tag요소들을 배열로 가져온다.
  const inputList = document.querySelectorAll("form.join input");

  //inputList 0번 요소부터 4번 요소까지 form에 작성된 순서대로 담겨있다.
  /*index 객체에서 각 요소의 첨자를 가져오고, 
    첨자를 사용하여 input tag를 각 순서대로 변수에 담겠다.
    index 배열을 만들어서 사용해도 되고, password에서 만든 것처럼 해도 된다.
    둘 중 고르는 것은 나의 자유.
  */
  const username = inputList[index.username];
  const password = document.querySelector("input[name='password']");
  const re_password = inputList[index.re_password];
  const name = inputList[index.name];
  const email = inputList[index.email];

  const username_msg = document.querySelector("div.username");

  const username_isBlank = () => {
    username_msg.innerText = " * USERNAME 을 입력해 주세요.";
    username_msg.classList.remove("ok");

    // div.username 항목에 warn이라는 class를 덧붙여라.
    username_msg.classList.add("warn");
    /* JS코드를 사용하여 여러가지 style을 변경하고자 할 때
           일일이 style항목을 변경하는 방법이 있지만
           미리 본문의 style항목에 사용하지 않는 class하나를 만들어 두고
           속성을 미리 작성해 놓는다.
           그리고 해당 항목에 classList.add("class명") 과 같이
           사용하면 여러가지 미리 설정한 속성이 적용된다.
        */
    username.focus();
    return false;
  };

  //join버튼 클릭하면
  if (join_btn) {
    join_btn.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      }
      if (password.value === "") {
        alert("비밀번호를 입력해주세요");
        password.focus();
        return false;
      }
      if (re_password.value === "") {
        alert("비밀번호 확인을 입력해 주세요");
        re_password.focus();
        return false;
      }
      if (password.value !== re_password.value) {
        alert("비밀번호를 똑같이 입력해주세요.");
        password.value = "";
        re_password.value = "";
        password.focus();
        return false;
      }

      join_form.submit();
    });
  }

  if (id_check) {
    id_check.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      } //end if

      /* 이전 방식은 queryString 방식으로 요청했다.
         그래서 변수이름(username) 노출 문제도 있고, 데이터 길이 제한 문제도 있었지만
         현재는 밑에와 같은 방식으로 데이터 전송을 한다.
      
        URL, PathVarriable방식으로 데이터(검사하고자 하는 username)를 전송하기
        REST ful 방식이라고 함.      
        localhost:8080/school/user/idcheck/ppuni 로 요청하기
      */
      fetch(`${rootPath}/user/idcheck/${username.value}`)
        .then((res) => {
          console.table(res);
          console.table(index);
          return res.text();
        })
        .then((result) => {
          if (result === "OK") {
            username_msg.classList.remove("warn");
            username_msg.classList.add("ok");
            username_msg.innerText = " * 사용할 수 있는 USER NAME 입니다.";
          } else {
            username_msg.classList.remove("ok");
            username_msg.classList.add("warn");
            username_msg.innerText = " * 이미 가입된 USER NAME 입니다.";
          }
        });
    });
  }
});
