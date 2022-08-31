package com.lrm.web;

import com.lrm.domain.User;
import com.lrm.domain.UserRepository;
import com.lrm.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by limi on 2017/8/22.
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(UserForm userForm) {
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "login";
    }


}
