document.addEventListener("DOMContentLoaded", () => {
  const book_table = document.querySelector("table.books");

  book_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const isbn = tr.dataset.isbn;
      //alert(isbn);
      document.location.href = `${rootPath}/books/${isbn}/detail`;
    }
  });
});
