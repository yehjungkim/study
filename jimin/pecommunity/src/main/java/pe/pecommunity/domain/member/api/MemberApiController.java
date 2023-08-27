package pe.pecommunity.domain.member.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.pecommunity.domain.member.application.MemberService;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.domain.member.dto.SignInRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    private ResponseEntity<String> signIn(@RequestBody @Valid SignInRequestDto request) {
        Member member = new Member();
        member.setMemberId(request.getMemberId());
        member.setNickname(request.getNickname());
        member.setPassword(request.getPassword());
        member.setEmail(request.getEmail());

        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/join/{memberId}")
    private ResponseEntity<String> checkMemberId(@PathVariable String memberId) {
        String result = memberService.checkMemberId(memberId) ? "fail" : "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
