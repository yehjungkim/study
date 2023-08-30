package Member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/member/join")
    public String signUpForm(Model model) {
        model.addAttribute("signUpRequestDto", new SignUpRequestDto());
        return "success";
    }

    @PostMapping("/member/join")
    public String signUp(@Valid SignUpRequestDto signUpDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "fail"; //회원가입 페이지로 재이동 해야함
        }
        Member member = new Member();
        member.createMember(signUpDto);
        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "fail";
        }
        return"success";
    }
    @GetMapping("/member/join/{memberId}")
    public String checkDuplicateId(@PathVariable String memberId) {
        Optional<Member> findMemberId = memberRepository.findByMemberId(memberId);
        if(findMemberId != null) {
            return "fail";
        }
        return "success";
    }

    @PostMapping("/member/login")
    public String login(@Valid LoginRequestDto loginRequestDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "fail";
        }
        Member loginMember = memberService.login(loginRequestDto.getLoginId(), loginRequestDto.getLoginPw());

        if(loginMember == null) {
            
        }
        return "success";
    }
}
