package iviettech.vn.mvcbook.converter;


import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.entity.BookEntity;

public class BookConverter {
    public static Book toModel(BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        book.setCategoryId(bookEntity.getCategoryEntity().getId());
        return book;
    }

    public static BookEntity toEntity(Book book) {
        BookEntity entity =  new BookEntity();
        entity.setName(book.getName());
        entity.setAuthor(book.getAuthor());
        return entity;
    }
}
