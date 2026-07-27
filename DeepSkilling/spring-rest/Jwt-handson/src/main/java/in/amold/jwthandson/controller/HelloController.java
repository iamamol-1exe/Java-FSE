package in.amold.jwthandson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String Health (){
        return "Hello World";
    }

    @GetMapping("/hello")
    public String Hello (){
        return "Hello World";
    }
}
