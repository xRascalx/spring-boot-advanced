package com.lrm.web;

import com.lrm.domain.User;
import com.lrm.domain.UserRepository;
import com.lrm.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by limi on 2017/8/22.
 */
@Controller
public class LoginController {

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {
        if(!userForm.confirmPassword()){
            result.rejectValue("confirmPassword","confirmError","密碼不一致");
        }
        if(result.hasErrors()){
            return "register";
        }

        User user = userForm.convertToUser();
        userRepository.save(user);
        return "login";
    }


}
