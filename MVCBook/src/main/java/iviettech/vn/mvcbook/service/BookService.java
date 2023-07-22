package iviettech.vn.mvcbook.service;


import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.domain.BookDetail;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    void createBook(Book book);
    BookDetail getBookDetailById(Long id);
}
