package member.login;

import lombok.RequiredArgsConstructor;
import member.LoginRequestDto;
import member.Member;
import member.MemberRepository;
import member.MemberService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class LoginController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/login")
    public String login(@Valid LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "fail"; //로그인 페이지로 이동
        }
        Member loginMember = memberService.login(loginRequestDto.getLoginId(), loginRequestDto.getLoginPw());

        if(loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 잘못 입력하였습니다.");
            return "fail"; //로그인 페이지로 이동
        }
        return "success";
    }
}
