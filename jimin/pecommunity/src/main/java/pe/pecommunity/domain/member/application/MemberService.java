package pe.pecommunity.domain.member.application;

import static pe.pecommunity.global.error.ErrorCode.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pecommunity.domain.member.dao.MemberRepository;
import pe.pecommunity.domain.member.domain.Member;
import pe.pecommunity.domain.member.dto.LoginRequestDto;
import pe.pecommunity.global.error.exception.BaseException;


@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        checkMemberId(member.getMemberId());

        if(memberRepository.findByMemberId(member.getNickname()).isPresent()) {
            throw new BaseException(NICKNAME_ALREADY_EXIST);
        }

        if(memberRepository.findByMemberId(member.getEmail()).isPresent()) {
            throw new BaseException(EMAIL_ALREADY_EXIST);
        }

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 로그인
     */
    public Long login(LoginRequestDto member) {
        Member loginMember = memberRepository.findByMemberId(member.getMemberId())
                .orElseThrow(() -> new BaseException(MEMBER_ID_NOT_EXIST));

        if(!loginMember.getPassword().equals(member.getPassword())) {
            throw new BaseException(WRONG_PASSWORD);
        }

        return loginMember.getId();
    }

    /**
     * 아이디 중복 확인
     */
    public void checkMemberId(String memberId) {
        if(memberRepository.findByMemberId(memberId).isPresent()) {
            throw new BaseException(MEMBER_ID_ALREADY_EXIST);
        }
    }
}
