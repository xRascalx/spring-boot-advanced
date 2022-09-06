package com.lrm.web;

import com.lrm.domain.User;
import com.lrm.domain.UserRepository;
import com.lrm.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
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

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session){
       User user = userRepository.findByUsernameAndPassword(username,password);
       if(user != null){
           session.setAttribute("user", user);
           return "index";
       }
       return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
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


    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException("測試異常");
    }
}
