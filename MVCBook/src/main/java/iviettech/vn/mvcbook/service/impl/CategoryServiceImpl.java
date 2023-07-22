package iviettech.vn.mvcbook.service.impl;

import iviettech.vn.mvcbook.converter.CategoryConverter;
import iviettech.vn.mvcbook.domain.Category;
import iviettech.vn.mvcbook.entity.CategoryEntity;
import iviettech.vn.mvcbook.repository.CategoryRepository;
import iviettech.vn.mvcbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll().stream().map(CategoryConverter::toModel).collect(Collectors.toList());
    }

    @Override
    public void createCategory(Category category) {
        CategoryEntity entity = CategoryConverter.toEntity(category);
        categoryRepository.save(entity);
    }
}
