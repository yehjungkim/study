package member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9가-힣]{1,10}$" , message = "닉네임은 최소 1자 최대 10자로 된 한글, 영어, 숫자로 만들어주세요")
    private String nickname;

    @NotBlank(message = "아이디를 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "아이디는 최소 1자 최대 10자로 된 영어, 숫자로 만들어주세요")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,15}$", message = "비밀번호는 최소 8자 최대" +
            "15자로 영어, 숫자, 특수문자를 필수로 다 넣어서 만들어주세요 ")
    private String pw;

    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "올바른 이메일 형식을 입력해주세요")
    private String email;

}
