package iviettech.vn.mvcbook.repository;


import iviettech.vn.mvcbook.entity.BookDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetailEntity, Long> {
}
