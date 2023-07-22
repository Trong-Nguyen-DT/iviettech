package iviettech.vn.mvcbook.converter;

import iviettech.vn.mvcbook.domain.Category;
import iviettech.vn.mvcbook.entity.BookEntity;
import iviettech.vn.mvcbook.entity.CategoryEntity;

public class CategoryConverter {
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }
}
