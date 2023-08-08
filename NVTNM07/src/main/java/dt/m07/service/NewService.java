package dt.m07.service;

import dt.m07.entity.NewEntity;

import java.util.List;

public interface NewService {
    List<NewEntity> listNewEntities();

    void addNew(NewEntity newEntity);

    List<NewEntity> findByTitleContaining(String query);
}
