package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {
    
    //세션에서 값을 가져옴
    //@GetMapping("/")
    @GetMapping("/")
    public String home(@SessionAttribute(name = "id", required = false) String id) {
        if(id == null) {
            System.out.println("로그인 하지 않음");
        }
        else {
            System.out.println("로그인 유저의 Id : " + id);
        }
        //return "to-doList";
        return "redirect:/member/login/form";
    }
}
