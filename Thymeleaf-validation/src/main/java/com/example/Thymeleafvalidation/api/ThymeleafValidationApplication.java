package com.example.Thymeleafvalidation.api;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class ThymeleafValidationApplication {

    @GetMapping("/")
    public String showForm(Person person) {

        return "register";
    }

    @PostMapping("/")
    public String register(@Validated Person pserson, Errors errors, Model model) {
        if (errors.hasErrors()){
            return "register";
        }else {
            model.addAttribute("message","Registration succesfully.....");
            return "register";
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(ThymeleafValidationApplication.class, args);
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {

    @NotNull
    @Size(min = 2, max = 10, message = "length Should be in between 2 to 10")
    private String name;

    @NotEmpty(message = "Email field Should not me Empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email Pattern ")
    private String email;

    @Pattern(regexp = "[7-9][0-9]{9}", message = "Invalid mobile number")
    @Size(max = 10, message = " digit should be 10")
    private String mobile;

}
