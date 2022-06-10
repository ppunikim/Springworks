document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re_password");
  const email = document.querySelector("#email");
  const btn_join = document.querySelector("#btn_join");

  const div_index = {
    username: 0,
    password: 1,
    re_password: 2,
    email: 3,
    name: 4,
    nickname: 5,
  };

  const error_divs = document.querySelectorAll("div.error");
  const passRule = /^[A-Za-z0-9]{6,12}$/;
  // A~Z, a~z, 0~9 를 모두 포함하면서 6~12자리의 문자열의 범위 내($)에서 입력해라.
  const passRule2 =
    /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
  // 위의 것에서 특수문자를 포함하는 것이다.

  //이메일 형식 검사
  const emailRule =
    /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

  username?.focus();

  const error_msg = (div, message) => {
    div.classList.remove("w3-text-blue");
    div.classList.add("w3-text-red");
    div.innerText = message;
  };

  const ok_msg = (div, message) => {
    div.classList.remove("w3-text-red");
    div.classList.add("w3-text-blue");
    div.innerText = message;
  };

  const username_div = error_divs[div_index.username];
  username?.addEventListener("blur", (e) => {
    const current = e.currentTarget;
    if (current.value === "") {
      const msg = "* USER NAME 은 반드시 입력하세요.";
      error_msg(username_div, msg);

      current.focus();
      return false;
    }
    fetch(`${rootPath}/user/idcheck/${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        if (result === "OK") {
          const msg = " * 사용가능한 USER NAME 입니다.";
          ok_msg(username_div, msg);
        } else {
          error_msg(username_div, " * 이미 가입된 USER NAME 입니다.");
          username.focus();
        }
      });
  }); //end username event

  password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.password];
    if (passRule2.test(current.value)) {
      ok_msg(error, "* 통과~");
    } else {
      error_msg(
        error,
        "* 비밀번호가 규격에 맞지 않습니다.(특수, 영문, 숫자 포함 8 ~ 15)"
      );
    }
  });

  re_password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.re_password];

    if (current.value === password?.value) {
      ok_msg(error, "* 비밀번호 확인값이 일치합니다.");
    } else {
      error_msg(error, "* 비밀번호 확인값이 일치하지 않습니다.");
    }
  }); //end re_password

  email?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.email];
    if (emailRule.test(current.value)) {
      ok_msg(error, "* Email 양식 검사 완료");
    } else {
      error_msg(error, "* Email 양식 확인해주세요.");
      return false;
    }
    fetch(`${rootPath}/user/emailcheck?email=${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        if (result === "OK") {
          ok_msg(error, " * 사용가능한 email 입니다.");
        } else {
          error_msg(error, " * 이미 등록된 email 입니다. 다시 입력해주세요.");
          curent.focus();
        }
      });
  });

  btn_join?.addEventListener("click", () => {
    if (username.value === "") {
      alert("USER NAME 은 반드시 입력하세요.");
      username.focus();
      return false;
    }
    if (username.value.length > 20) {
      alert("USER NAME은 20자 이내로 입력하세요.");
      username.focus();
      return false;
    }

    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("USERNAME과 비밀번호는 같을 수 없으니 다시 입력하세요.");
      password.focus();
      return false;
    }

    //925771

    if (passRule2.test(password.value) === false) {
      alert("비밀번호는 문자, 숫자 포함 8자리~ 15자리까지 입력하세요.");
      password.focus();
      return false;
    }

    if (password.value === "") {
      alert("비밀번호는 반드시 입력하세요.");
      password.focus();
      return false;
    }
    if (re_password.value === "") {
      alert("비밀번호를 다시 입력하세요.");
      re_password.focus();
      return false;
    }

    if (password.value !== re_password.value) {
      alert("비밀번호 확인 값이 일치하지 않습니다.");
      password.value = "";
      re_password.value = "";
      password.focus();
      return false;
    }

    if (!emailRule.test(email.value)) {
      alert("이메일 형식이 잘못됐습니다. 다시 입력해주세요.");
      email.focus();
      return false;
    }

    document.querySelector("form.join")?.submit(); //유효성 검사 끝에 꼭 작성해야 서버에 전송된다.
  });
});
