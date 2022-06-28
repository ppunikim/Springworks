document.addEventListener("DOMContentLoaded", () => {
  const diary_table = document.querySelector("table.diarys");

  diary_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const seq = tr.dataset.seq;

      if (seq) {
        document.location.href = `${rootPath}/diary/${seq}/d-detail`;
      }
    }
  });
});
