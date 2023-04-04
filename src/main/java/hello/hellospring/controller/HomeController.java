package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// 먼저 요청이 오면 스프링 컨테이너안의 관련 컨트롤러를 찾고 없으면 정적 컨텐츠를 찾음
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
