package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/convert")
    public String greeting(@RequestParam(value = "ENG") String ENG, Model model){
        model.addAttribute("ENG", ENG);
        return "index";
    }
}
