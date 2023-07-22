package iviettech.vn.mvcbook.controller;

import iviettech.vn.mvcbook.domain.Book;
import iviettech.vn.mvcbook.domain.Category;
import iviettech.vn.mvcbook.service.BookService;
import iviettech.vn.mvcbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String listBook(Model model) {
        model.addAttribute("books", bookService.getAllBook());
        return "book/book";
    }

    @GetMapping("create")
    public String showCategory(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "book/createBook";
    }

    @PostMapping("create")
    public String createBook(@ModelAttribute Book book){
        bookService.createBook(book);
        return "redirect:/books";

    }

    @GetMapping("detail/{id}")
    public String showBookDetail(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookDetailById(id));
        return "book/bookDetail";
    }
}
