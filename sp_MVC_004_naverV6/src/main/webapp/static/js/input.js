document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-result");
  const modal_content = modal_box.querySelector(".search-content");

  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");

  const input_index = {
    title: 0,
    isbn: 1,
    author: 2,
    link: 3,
    publisher: 4,
    pubdate: 5,
    price: 6,
    discount: 7,
    image: 8,
  };
  /*                         /*정규식 문법: 
                               문자열에서 태그 모두삭제하는 패턴 */
  const extractTextPattern = /(<([^>]+)>)/gi;

  const book_isbn = document.querySelector("input#isbn");
  const book_title = document.querySelector("input#title");

  const btn_save = document.querySelector("button.book-save");
  /* input event
       input tag에 키보드로 문자열을 입력할때마다 발생하는 event
    */

  /* if(book_isbn) 을 실행하여 book_isbn 있으면 addEventListener를 부착하고
      만약 book_isbn 객체가 없으면 오류를 발생시키지 말고 중단하라는 말이다.
   */
  book_isbn?.addEventListener("input", (e) => {
    const isbn = e.target.value;
    if (isbn.length >= 13) {
      alert(isbn);
    }
  });

  book_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      //alert(e.target.value);
      fetch(`${rootPath}/naver/books?title=${e.target.value}`).then((res) =>
        res.text().then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        })
      );
    }
  }); //end bookTitle

  modal_box.addEventListener("click", (tb) => {
    const td = tb.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const codes = tr.dataset.isbn?.split(" ");
      if (codes.length > 1) {
        fetch(`${rootPath}/naver/${codes[1]}/book`)
          .then((res) => res.json())
          .then((result) => {
            inputs[input_index.title].value = result.title;
            inputs[input_index.isbn].value = result.isbn
              .replace(extractTextPattern, "")
              .split(" ")[1];
            console.table(result);
            inputs[input_index.author].value = result.author;
            inputs[input_index.link].value = result.link;
            inputs[input_index.publisher].value = result.publisher;
            inputs[input_index.pubdate].value = result.pubdate;
            inputs[input_index.price].value = result.price;
            inputs[input_index.discount].value = result.discount;
            inputs[input_index.image].value = result.image;
            desc.value = result.description.replace(extractTextPattern, "");
            modal_box.style.display = "none";
          });
      } else {
        alert("ISBN코드 찾을 수 없음.");
      }
    }
  });
  btn_save?.addEventListener("click", (btn) => {
    const isbn = inputs[input_index.isbn];
    const title = inputs[input_index.title];
    const author = inputs[input_index.author];
    const publisher = inputs[input_index.publisher];

    if (isbn?.value === "") {
      alert("ISBN은 반드시 입력하세요.");
      isbn.focus();
      return false;
    }
    if (title?.value === "") {
      alert("도서명은 반드시 입력하세요.");
      title.focus();
      return false;
    }
    if (author?.value === "") {
      alert("저자는 반드시 입력하세요.");
      author.focus();
      return false;
    }
    if (publisher?.value === "") {
      alert("출판사는 반드시 입력하세요.");
      publisher.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); //ContentLoaded End
