package pe.pecommunity.domain.member.dto;

import lombok.Data;

@Data
public class SignInRequestDTO {
    private String memberId;
    private String nickname;
    private String password;
    private String email;
}
