package com.example.WorkShop.web;

import com.example.WorkShop.model.dto.UserRegistrationDto;
import com.example.WorkShop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute
    public UserRegistrationDto initFrom(){
        return new UserRegistrationDto();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        System.out.println(userRegistrationDto.toString());

        if (bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto"
                    ,bindingResult);

            redirectAttributes.addFlashAttribute("userRegistrationDto",userRegistrationDto);
            return "redirect:/register";
        }


        this.authService.register(userRegistrationDto);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
