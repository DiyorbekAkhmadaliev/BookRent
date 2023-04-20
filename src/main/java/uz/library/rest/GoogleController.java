package uz.library.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoogleController {

    @GetMapping("/login/google")
    public String login() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/callback/google")
    public String callback() {
        return "redirect:/profile";
    }
}
