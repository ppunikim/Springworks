const save_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  const st_name = document.querySelector("input[name='st_name']");
  const st_grade = document.querySelector("input[name='st_grade']");
  const st_dept = document.querySelector("input[name='st_dept']");
  const st_addr = document.querySelector("input[name='st_addr']");
  const st_tel = document.querySelector("input[name='st_tel']");
  // cb 는 call back 을 말하는 것이다.

  //JS 코드를 사용하여 Client Size Validation 수행
  //유효성 검사, 값이 입력되지 않았을 때 입력되지 않음을 보여주는 것.
  if (st_num.value === "") {
    alert("학번은 반드시 입력해라.");
    st_num.focus();
    return false;
  }
  if (st_name.value === "") {
    alert("이름 반드시 입력해라.");
    st_name.focus();
    return false;
  }
  if (st_dept.value === "") {
    alert("학과 반드시 입력해라.");
    st_dept.focus();
    return false;
  }

  const num_grade = Number(st_grade.value);
  if (!num_grade) {
    alert("학년은 반드시 숫자로만 입력해라.");
    st_grade.value = "";
    st_grade.focus();
    return false;
  }
  if (num_grade < 1 || num_grade > 4) {
    alert("학년은 1 ~ 4 범위에서 입력하시오");
    st_grade.value = ""; // 기존 입력 내용 clear 시켜주기
    st_grade.focus();
    return false;
  }

  if (st_tel.value === "") {
    alert("전화번호를 반드시 입력하라.");
    st_tel.focus();
    return false;
  }
  if (st_addr.value === "") {
    alert("주소 반드시 입력해야 한다.");
    st_addr.focus();
    return false;
  }
  // 모든 유효성 검사 통과됨.
  // 이제는 서버로 데이터를 전송해야 한다.
  const form = document.querySelector("form");
  form.submit();
  // 데이터가 모두 전송된다. 지금 java html에서는 type이 button 이므로 바꾼 것이다.
};
