package vn.iviettech.springbookmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.iviettech.springbookmvc.domain.User;

@RequestMapping("users")
@Controller
public class UserController {
    @GetMapping("{userId}")
    public String getUserDetail(@PathVariable(name = "userId") Long userId, Model model) {

        User user = getUser(userId);

        model.addAttribute("user", user);

        return "user/detail";
    }

    private static User getUser(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setName("Name" + userId);
        user.setAge(21);
        return user;
    }
}
