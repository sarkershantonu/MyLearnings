package org.tutoring.api.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SSarker on 10/27/2018.
 */
@Controller
public class HomeController extends BaseController{
    @GetMapping("/home")
    public String home(Model model) {
        return "forward:/index.html";
    }
}
