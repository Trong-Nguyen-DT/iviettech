package iviettech.vn.mvcbook.service.impl;


import iviettech.vn.mvcbook.converter.BookConverter;
import iviettech.vn.mvcbook.converter.BookDetailConverter;
import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.domain.BookDetail;
import iviettech.vn.mvcbook.entity.BookDetailEntity;
import iviettech.vn.mvcbook.entity.BookEntity;
import iviettech.vn.mvcbook.entity.CategoryEntity;
import iviettech.vn.mvcbook.repository.BookDetailRepository;
import iviettech.vn.mvcbook.repository.BookRepository;
import iviettech.vn.mvcbook.repository.CategoryRepository;
import iviettech.vn.mvcbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookDetailRepository bookDetailRepository;
    public List<Book> getAllBook() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(BookConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public void createBook(Book book) {
        BookEntity entity = BookConverter.toEntity(book);
        CategoryEntity categoryEntity = categoryRepository.findById(book.getCategoryId()).orElseThrow(() -> new RuntimeException("Khong tim thay category"));
        entity.setCategoryEntity(categoryEntity);

        entity = bookRepository.save(entity);

        BookDetailEntity bookDetailEntity = new BookDetailEntity();
        bookDetailEntity.setContent(book.getBookDetail().getContent());
        bookDetailEntity.setNumberOfPage(book.getBookDetail().getNumberOfPage());
        bookDetailEntity.setPrice(book.getBookDetail().getPrice());
        bookDetailEntity.setPublishDate(book.getBookDetail().getPublishDate());

        bookDetailEntity.setBookEntity(entity);

        bookDetailRepository.save(bookDetailEntity);


    }

    @Override
    public BookDetail getBookDetailById(Long id) {
        return getBookDetailModel(id);
    }

    private BookDetail getBookDetailModel(Long id){
        return BookDetailConverter.toModel(bookDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy book detail")));
    }
}
