package pe.pecommunity.domain.member.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        Long id = memberService.join(member);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}
