package pe.pecommunity.domain.member.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.pecommunity.domain.member.application.MemberService;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.domain.member.dto.LoginRequestDto;
import pe.pecommunity.domain.member.dto.SignInRequestDto;
import pe.pecommunity.global.common.response.ApiResponse;
import pe.pecommunity.global.common.response.ResponseUtils;
import pe.pecommunity.global.error.ErrorMessage;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    private ApiResponse<?> signIn(@RequestBody @Valid SignInRequestDto request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseUtils.error(null, getErrorMessage(bindingResult));
        }

        try {
            Member member = request.toEntity();
            memberService.join(member);
        } catch (IllegalStateException e) {
            return ResponseUtils.failure(null, e.getMessage());
        }

        return ResponseUtils.success(null, "회원가입 성공");
    }

    @GetMapping("/join/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    private ApiResponse<?> checkMemberId(@PathVariable String memberId) {
        if(memberService.checkMemberId(memberId)) {
            return ResponseUtils.failure(null, ErrorMessage.MEMBER_ID_ALREADY_EXIST);
        }
        return ResponseUtils.success(null, "사용가능한 아이디입니다.");
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    private ApiResponse<?> login(@RequestBody @Valid LoginRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseUtils.error(null, getErrorMessage(bindingResult));
        }

        try {
            memberService.login(request);
        } catch (IllegalStateException e) {
            return ResponseUtils.failure(null, e.getMessage());
        }

        return ResponseUtils.success(null, "로그인 성공");
    }

    private String getErrorMessage(BindingResult bindingResult) {
        String message = "";
        for(FieldError error : bindingResult.getFieldErrors()) {
            message += error.getDefaultMessage() + " ";
        }
        return message;
    }
}
