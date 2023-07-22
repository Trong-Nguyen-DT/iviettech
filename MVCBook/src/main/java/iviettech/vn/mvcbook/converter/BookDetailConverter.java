package iviettech.vn.mvcbook.converter;

import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.domain.BookDetail;
import iviettech.vn.mvcbook.entity.BookDetailEntity;
import iviettech.vn.mvcbook.entity.BookEntity;

public class BookDetailConverter {
    public static BookDetail toModel(BookDetailEntity bookDetailEntity) {
        BookDetail bookDetail = new BookDetail();
        bookDetail.setId(bookDetailEntity.getId());
        bookDetail.setBookId(bookDetailEntity.getBookEntity().getId());
        bookDetail.setContent(bookDetailEntity.getContent());
        bookDetail.setNumberOfPage(bookDetailEntity.getNumberOfPage());
        bookDetail.setPrice(bookDetailEntity.getPrice());
        bookDetail.setPublishDate(bookDetailEntity.getPublishDate());
        return bookDetail;
    }
}
