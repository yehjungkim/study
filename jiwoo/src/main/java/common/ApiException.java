package common;

public class ApiException extends RuntimeException {
    private ApiErrorEnum error;

    public ApiException(ApiErrorEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
