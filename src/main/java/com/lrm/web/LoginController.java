package com.lrm.web;

import com.lrm.domain.User;
import com.lrm.domain.UserRepository;
import com.lrm.form.UserForm;
import org.springframework.stereotype.Controller;
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
    public String registerPage() {
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {
        boolean boo = true;
        if(userForm.confirmPassword()){
            result.rejectValue("confirmPassword","confirmError","密碼不一致");
            boo = false;
        }
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage() + ":" + error.getCode());
            }
            boo = false;
            return "register";
        }
        if(!boo){
            return "register";
        }
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "login";
    }


}
