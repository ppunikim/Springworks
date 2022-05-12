const std_num_check_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  if (st_num.value === "") {
    alert("중복 검사를 하려면 먼저 학번부터 입력해라");
    st_num.focus();
    return false;
  }
  //alert("입력한 학번: " + st_num.value);
  fetch(`${rootPath}/student/st_num_check?st_num=${st_num.value}`)
    .then((res) => res.text())
    .then((result) => {
      if (result === "USE") {
        alert("이미 사용중인 아이디이니,\n다시 입력하세요");
      } else {
        alert("사용 가능한 아이디입니다.");
      }
    });
};

document.addEventListener("DOMContentLoaded", () => {
  const std_num_check = document.querySelector("button.std-num-check");

  /*
  std_num_check click event handler 를
  std_num_check_cb 이라는 함수로 별도 선언하고
  handler에는 함수 이름을 매개변수로 전달했다.
  이 때, 함수 이름에는 절대 () 를 붙이지 않는다.
  */
  if (std_num_check) {
    std_num_check.addEventListener("click", std_num_check_cb); //end callback
    //함수를 별도로 분리해서 사용한것이다.
  }
  //현재 html에 있는 버튼 클래스가 std-save인 버튼을 챙겨서
  //사용할(handling) 준비를 하겠다.
  const std_save = document.querySelector("button.std-save");

  //std_save가 정상적으로 준비됐는가?, 버튼(std_save)가 있냐?
  if (std_save) {
    std_save.addEventListener("click", save_cb);
  }
  //함수를 별도로 분리해서 사용한 것이다.
});
