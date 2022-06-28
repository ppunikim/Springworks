document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memos");

  memo_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const seq = tr.dataset.seq;
      document.location.href = `${rootPath}/write/${seq}/detail`;
    }
  });
});
