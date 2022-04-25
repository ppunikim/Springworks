document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("TABLE");

  //현재 DOM화면에 있는 모든 td들을 가져 와서
  //모든 td들에게 click event를 부착하기.
  //   const tds = document.querySelectorAll("TD");
  //   for (let i = 0; i < tds.length; i++) {
  //     tds[i].addEventListener("click", () => {
  //       alert(tds[i].innerText);
  //     });
  //   }

  /*
    이 스크립트가 실행되는 DOM화면에 table tag 가 
    있으면 if() {} 코드를 실행하고, 
    없으면 건너뛰어라.

    만약 이 스크립트가 실행회는 DOM화면에 table tag가 없으면
    변수 table에는 undefined가 담기게 된다.
    그러면 if 조건문에서 false가 발생한다. 
    그래서 if문을 건너뛴다.
    */
  if (table) {
    table.addEventListener("click", (e) => {
      const target = e.target;
      const text = target.innerText;
      const className = target.className;
      const stNum = target.dataset.num;
      if (className === "name") {
        document.location.href = "/app/student/detail?stNum=" + stNum;
      }
    });
  } //end if
  // 이 코드는 table이 눌리면 td의 값이 target에 저장되어 그것을 불러온다.
  // 비법소스코드이다.
});
