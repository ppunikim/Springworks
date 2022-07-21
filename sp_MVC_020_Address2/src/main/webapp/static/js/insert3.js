document.addEventListener("DOMContentLoaded", () => {
  const join = document.querySelector("form.join");
  const a_name = document.querySelector("#a_name");
  const a_tel = document.querySelector("#a_tel");
  const a_address = document.querySelector("#a_address");
  const btn_join = document.querySelector("#btn_join");
  const block = document.querySelector(".block");
  const block2 = document.querySelector(".block2");
  const block3 = document.querySelector(".block3");

  btn_join?.addEventListener("click", () => {
    if (a_name.value === "") {
      block.style.display = "block";
      a_name.focus();
      return false;
    } else {
      block.style.display = "none";
    }
    if (a_tel.value === "") {
      block2.style.display = "block";
      a_tel.focus();
      return false;
    } else {
      block2.style.display = "none";
    }
    if (a_address.value === "") {
      block3.style.display = "block";
      a_address.focus();
      return false;
    } else {
      block3.style.display = "none";
    }

    join.submit();
  });
});
