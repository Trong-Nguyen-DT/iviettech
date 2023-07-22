package iviettech.vn.mvcbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String author;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_entity_id")
    private CategoryEntity categoryEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_detail_entity_id")
    private BookDetailEntity bookDetailEntity;

    public BookEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public BookDetailEntity getBookDetailEntity() {
        return bookDetailEntity;
    }

    public void setBookDetailEntity(BookDetailEntity bookDetailEntity) {
        this.bookDetailEntity = bookDetailEntity;
    }
}
