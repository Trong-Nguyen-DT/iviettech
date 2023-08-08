package dt.m07.repositoty;

import dt.m07.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long > {
    List<NewEntity> findByTitleContaining(String query);
}
