document.addEventListener("DOMContentLoaded", () => {
  const navs = document.querySelectorAll("nav li");

  const nav_click = (e) => {
    const nav = e.target;
    let url = `${rootPath}/`;
    if (nav.innerText === "학생정보") {
      url += "student";
    } else if (nav.innerText === "성적정보") {
      url += "score";
    }
    document.location.href = url;
  }; //end nav_click

  for (const nav of navs) {
    nav.addEventListener("click", nav_click);
  }
});
