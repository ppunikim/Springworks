document.addEventListener("DOMContentLoaded", () => {
  const add_btn = document.querySelector("div.add_btn");

  const hs_last = document.querySelector("div.hs_last");
  add_btn.addEventListener("click", (e) => {
    fetch(`${rootPath}/memo/m-add`)
      .then((res) => res.text())
      .then((result) => {
        hs_last.style.display = "block";
        hs_last.innerHTML = result;
      });
  });
});
