document.addEventListener("DOMContentLoaded", () => {
  const memo_div = document.querySelector("div.hs_memo");

  memo_div?.addEventListener("click", (e) => {
    const clk = e.target;
    if (clk.tagName === "DIV") {
      const div = clk.closest("DIV");
      const seq = div.dataset.seq;
      if (seq) {
        document.location.href = `${rootPath}/memo/${seq}/m-detail`;
      }
    }
  }); //end memo_div
});
