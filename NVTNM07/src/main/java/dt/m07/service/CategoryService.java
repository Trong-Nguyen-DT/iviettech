package dt.m07.service;

import dt.m07.entity.CategoryEntity;
import dt.m07.repositoty.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {



    List<CategoryEntity> getAllCategory();
}
