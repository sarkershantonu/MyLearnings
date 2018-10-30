package org.tutoring.api.web.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SSarker on 10/27/2018.
 */
@Controller
public class ContentController extends BaseController{
    @GetMapping("/home")
    public String home() {
        return "forward:/index.html";
    }
}
