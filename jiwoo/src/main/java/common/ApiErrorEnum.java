package common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ApiErrorEnum {
    // 클라이언트 에러
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "CE400"),
    Forbidden(HttpStatus.FORBIDDEN, "CE403"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "CE404"),
    // 커스텀 에러
    SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "로그인이 필요합니다");

    private final HttpStatus status;
    private String message;
    private final String code;

    ApiErrorEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ApiErrorEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
