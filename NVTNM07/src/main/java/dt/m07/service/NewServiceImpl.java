package dt.m07.service;

import dt.m07.entity.NewEntity;
import dt.m07.repositoty.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class NewServiceImpl implements NewService{

    @Autowired
    private NewRepository newRepository;

    @Override
    public List<NewEntity> listNewEntities() {
        return newRepository.findAll();
    }

    @Override
    public void addNew(NewEntity newEntity) {
        NewEntity entity = new NewEntity();
        entity.setTitle(newEntity.getTitle());
        entity.setSummary(newEntity.getSummary());
        entity.setCreatedDate(LocalDate.now());
        entity.setStaffEntity(newEntity.getStaffEntity());
        entity.setCategoryEntity(entity.getCategoryEntity());

        newRepository.save(entity);
    }

    @Override
    public List<NewEntity> findByTitleContaining(String query) {
        return newRepository.findByTitleContaining(query);
    }
}
