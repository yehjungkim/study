package pe.pecommunity.domain.member.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.pecommunity.domain.member.application.MemberService;
import pe.pecommunity.domain.member.dto.LoginRequestDto;
import pe.pecommunity.domain.member.dto.SignInRequestDto;
import pe.pecommunity.global.common.response.ApiResponse;
import pe.pecommunity.global.common.response.ResponseUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    private ApiResponse<?> signIn(@RequestBody @Valid SignInRequestDto request) {
        memberService.join(request.toEntity());
        return ResponseUtils.success("회원가입 성공");
    }

    @GetMapping("/join/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    private ApiResponse<?> checkMemberId(@PathVariable String memberId) {
        memberService.checkMemberId(memberId);
        return ResponseUtils.success("사용가능한 아이디입니다.");
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    private ApiResponse<?> login(@RequestBody @Valid LoginRequestDto request) {
        memberService.login(request);
        return ResponseUtils.success("로그인 성공");
    }
}
