package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


    @Controller
    public class ConvertController {
        @GetMapping("/convert")
        public String greeting(@RequestParam(value = "usd") int usd, Model model){
            model.addAttribute("usd", usd);
            return "convert";
        }
    }

