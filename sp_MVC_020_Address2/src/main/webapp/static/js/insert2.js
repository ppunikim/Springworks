document.addEventListener("DOMContentLoaded", () => {
  const join = document.querySelector("form.join");
  const a_name = document.querySelector("#a_name");
  const a_tel = document.querySelector("#a_tel");
  const a_address = document.querySelector("#a_address");
  const btn_join = document.querySelector("#btn_join");

  btn_join?.addEventListener("click", () => {
    if (a_name.value === "") {
      alert("이름을 입력하세요.");
      a_name.focus();
      return false;
    }
    if (a_tel.value === "") {
      alert("전화번호를 입력하세요.");
      a_tel.focus();
      return false;
    }
    if (a_address.value === "") {
      alert("주소를 입력하세요.");
      a_address.focus();
      return false;
    }

    join.submit();
  });
});
