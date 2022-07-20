document.addEventListener("DOMContentLoaded", () => {
  const address_list = document.querySelector("table.table_addr");
  address_list?.addEventListener("click", (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const a_seq = tr.dataset.hsk;
      // console.log("여기" + a_seq);
      document.location.href = `${rootPath}/detail?seq=${a_seq}`;
    }
  });
});
