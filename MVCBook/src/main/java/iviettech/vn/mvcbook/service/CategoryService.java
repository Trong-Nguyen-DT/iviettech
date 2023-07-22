package iviettech.vn.mvcbook.service;

import iviettech.vn.mvcbook.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    void createCategory(Category category);
}
