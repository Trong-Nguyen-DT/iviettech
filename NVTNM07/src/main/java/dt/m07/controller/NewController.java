package dt.m07.controller;

import dt.m07.entity.NewEntity;
import dt.m07.service.CategoryService;
import dt.m07.service.NewService;
import dt.m07.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewController {

    @Autowired
    private NewService newService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showListNews(Model model) {
        model.addAttribute("newEntity", new NewEntity());
        model.addAttribute("listNews", newService.listNewEntities());
        model.addAttribute("staffs", staffService.getAllStaff());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "news";
    }

    @PostMapping
    public String addNew(@ModelAttribute NewEntity newEntity){
        newService.addNew(newEntity);

        return "redirect:/news";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<NewEntity> newsList = newService.findByTitleContaining(query);
        model.addAttribute("listNews", newsList);
        return "news";
    }
}
