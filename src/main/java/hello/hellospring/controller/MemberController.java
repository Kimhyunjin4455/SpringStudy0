package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 이 어노테이션을 보고 스프링이 멤버 컨트롤러 객체를 생성해 가지고 있음, 스프링 빈
public class MemberController {
    private final MemberService memberService;

    @Autowired
    // 컨트롤러랑 서비스 연결할 때 사용하는 어노테이션,
    // 디펜던시 인젝션
    // 처음에는 멤버서비스는 스프링 빈에 등록되있지 않음(순수 자바 클래스) > 서비스 어노테이션 추가해서 스프링이 인식하도록 함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createFrom(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member(); //
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";

    }
}
