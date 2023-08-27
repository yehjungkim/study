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
import org.springframework.web.bind.annotation.RestController;
import pe.pecommunity.domain.member.application.MemberService;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.domain.member.dto.LoginRequestDto;
import pe.pecommunity.domain.member.dto.SignInRequestDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    private ResponseEntity<String> signIn(@RequestBody @Valid SignInRequestDto request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors={}", bindingResult);
            String errorMessage = getErrorMessage(bindingResult);
            return new ResponseEntity<>("fail: " + errorMessage, HttpStatus.BAD_REQUEST);
        }

        Member member = new Member();
        member.setMemberId(request.getMemberId());
        member.setNickname(request.getNickname());
        member.setPassword(request.getPassword());
        member.setEmail(request.getEmail());

        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("fail: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/join/{memberId}")
    private ResponseEntity<String> checkMemberId(@PathVariable String memberId) {
        String result = memberService.checkMemberId(memberId) ? "fail: 이미 존재하는 아이디입니다." : "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors={}", bindingResult);
            String errorMessage = getErrorMessage(bindingResult);
            return new ResponseEntity<>("fail: " + errorMessage, HttpStatus.BAD_REQUEST);
        }

        try {
            memberService.login(request);
        } catch (IllegalStateException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("fail: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private String getErrorMessage(BindingResult bindingResult) {
        String message = "";
        for(FieldError error : bindingResult.getFieldErrors()) {
            message += error.getDefaultMessage() + " ";
        }
        return message;
    }
}
