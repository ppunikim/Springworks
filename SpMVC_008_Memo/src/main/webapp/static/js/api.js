document.addEventListener("DOMContentLoaded", () => {
  const detail = document.querySelector("table.hs_detail");
  detail?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;

    if (seq) {
      alert("seq");
      //document.location.href = `${rootPath}/api/${seq}/api`;
    }
  });
});
