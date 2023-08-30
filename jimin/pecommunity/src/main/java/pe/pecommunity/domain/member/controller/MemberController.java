package pe.pecommunity.domain.member.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.pecommunity.domain.member.application.MemberService;
import pe.pecommunity.domain.member.domain.Member;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if(result.hasErrors()) {
            log.info("errors={}", result);
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setMemberId(form.getMemberId());
        member.setNickname(form.getNickname());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());

        memberService.join(member);

        return "redirect:/";
    }

}
