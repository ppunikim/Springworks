const save_cb = async () => {
  const a_name = document.querySelector("input[name='a_name']");
  const a_tel = document.querySelector("input[name='a_tel']");
  const a_address = document.querySelector("input[name='a_address']");

  if (a_name.value === "") {
    alert("이름 입력하세요.");
    a_name.value = "";
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
  const form = document.querySelector("form");
  form.submit();
};
