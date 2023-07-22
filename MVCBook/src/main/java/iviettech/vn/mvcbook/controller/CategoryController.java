package iviettech.vn.mvcbook.controller;

import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.domain.Category;
import iviettech.vn.mvcbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String listCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "category/category";
    }
    @GetMapping("create")
    public String showCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/ceateCategory";
    }

    @PostMapping("create")
    public String ceateCategory(@ModelAttribute Category category){
        categoryService.createCategory(category);
        return "redirect:/categories";
    }
}
