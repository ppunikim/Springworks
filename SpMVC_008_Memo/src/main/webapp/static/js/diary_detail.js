document.addEventListener("DOMContentLoaded", () => {
  const diary_table = document.querySelector("table.diarys");
  const weather = document.querySelector("input#d_weather");
  const w_alert = document.querySelector("div.d_inner");

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

  weather?.addEventListener("input", (e) => {
    const value = e.target.value;
    if (value.length > 8) {
      w_alert.style.display = "block";
    } else {
      w_alert.style.display = "none";
    }
    return false;
  });
});
