document.addEventListener("DOMContentLoaded", () => {
  const add_btn = document.querySelector("div.add_btn");

  const hs_last1 = document.querySelector("div.hs_last1");
  add_btn.addEventListener("click", (e) => {
    fetch(`${rootPath}/memo/m-add`)
      .then((res) => res.text())
      .then((result) => {
        hs_last1.style.display = "block";
        hs_last1.innerHTML = result;
      });
  });
});
