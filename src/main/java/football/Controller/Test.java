package football.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping
public class Test {

    @GetMapping("/test")
    public String test(){
        String a = "Success";
        return a;
    }

}
