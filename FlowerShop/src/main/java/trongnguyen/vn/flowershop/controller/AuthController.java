package trongnguyen.vn.flowershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import trongnguyen.vn.flowershop.domain.UserModel;
import trongnguyen.vn.flowershop.exception.FieldMissMatchException;
import trongnguyen.vn.flowershop.service.UserService;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String index(){
        return "login";
    }

    @GetMapping("signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute("user") UserModel userModel)
            throws FieldMissMatchException {

        userService.register(userModel);
        return "redirect:/login";
    }
}
