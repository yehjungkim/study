package pe.pecommunity.global.error;

public enum ErrorCode {

    /**
     * custom
     */
    // member
    MEMBER_ID_ALREADY_EXIST("이미 존재하는 아이디입니다."),
    NICKNAME_ALREADY_EXIST("이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXIST("이미 존재하는 이메일입니다."),

    MEMBER_ID_NOT_EXIST("존재하지 않는 아이디입니다."),
    NICKNAME_NOT_EXIST("존재하지 않는 닉네임입니다."),
    WRONG_PASSWORD("틀린 비밀번호입니다."),


    INVALID_TYPE_VALUE("유효하지 않은 데이터 값입니다."),
    NOT_FOUND_ERROR("잘못된 주소 요청입니다."),
    INTERNAL_SERVER_ERROR("서버 에러입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
