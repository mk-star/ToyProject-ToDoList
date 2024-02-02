package hello.hello.spring.controller;

import hello.hello.spring.domain.Member;
import hello.hello.spring.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //보통 조회
    @GetMapping("/member/register/form")
    public String registerForm() {
        return "member/registerForm";
    }

    //form에 data를 전달할 때 많이 쓰임
    @PostMapping("/member/register")
    public String create(RegisterForm form) {

        Member member = new Member();

        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setName(form.getName());
        member.setEmail(form.getEmail());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String List(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/member/login/form")
    public String loginForm()  {
        return "member/loginForm";
    }
    @PostMapping("/member/login")
    public String login(LoginForm form, HttpServletRequest request, Model model) {
       Member Member = memberService.login(form.getId(), form.getPassword());

       HttpSession session = request.getSession();
       session.setAttribute("id", Member.getId());


       return "redirect:/todo";

    }

    //https://devuna.tistory.com/53

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        session.invalidate();

        return "redirect:/member/login/form";
    }
    @GetMapping("/member/register/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestParam("id") String id) {
        Optional<Member> member = memberService.findMember(id);

        // Member가 존재하면 true, 존재하지 않으면 false 반환
        return member.isPresent();
    }

    @GetMapping("/member/register/emailCheck")
    @ResponseBody
    public boolean emailCheck(@RequestParam("email") String email) {
        Optional<Member> member = memberService.findByEmail(email);

        // Member가 존재하면 true, 존재하지 않으면 false 반환
        return member.isPresent();
    }
    @GetMapping("/member/login/memberCheck")
    @ResponseBody
    public boolean memberCheck(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        Optional<Member> optionalMember = memberService.findMember(id);

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();

            if(pw.equals(member.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
