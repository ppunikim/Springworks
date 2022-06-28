document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memos");

  memo_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const seq = tr.dataset.seq;
      if (seq) {
        document.location.href = `${rootPath}/memo/${seq}/m-detail`;
      }
    }
  });
});
