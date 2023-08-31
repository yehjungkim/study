package pe.pecommunity.global.common.response;

public class ResponseUtils {

    public static <T>ApiResponse<T> success (T data, String message) {
        return new ApiResponse(ResponseStatus.SUCCESS, data, message);
    }

    public static <T>ApiResponse<T> failure (T data, String message) {
        return new ApiResponse(ResponseStatus.FAILURE, data, message);
    }

    public static <T>ApiResponse<T> error (T data, String message) {
        return new ApiResponse(ResponseStatus.ERROR, data, message);
    }
}
