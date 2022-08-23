document.addEventListener("DOMContentLoaded", () => {
  const detail = document.querySelector("table.hs_detail");

  detail?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;

    if (seq) {
      document.location.href = `${rootPath}/api/${seq}/api-look`;
    }
  });

  const ranDetail = document.querySelector("img.this");

  // 랜덤 이미지 값 눌렀을 때 detail 보기 구현 안됨.
  ranDetail?.addEventListener("click", () => {
    document.location.href = `${rootPath}/api/${UC_SEQ}/api-look`;
  });
});
