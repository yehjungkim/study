package pe.pecommunity.global.common.response;

import java.util.HashMap;
import java.util.Map;
import pe.pecommunity.global.error.ErrorCode;

public class ResponseUtils {

    /**
     * 성공
     */
    public static <T>ApiResponse<T> success (String message) {
        return success(null, message);
    }

    public static <T>ApiResponse<T> success (T data) {
        return success(data, null);
    }

    public static <T>ApiResponse<T> success (T data, String message) {
        return new ApiResponse(ResponseStatus.SUCCESS, data, message);
    }

    public static <T>ApiResponse<T> successAsJson (String key, T object, String message) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, object);
        return new ApiResponse(ResponseStatus.SUCCESS, data, message);
    }

    /**
     * 실패 - 회원가입, 로그인
     */
    public static <T>ApiResponse<T> failure (T data, String message) {
        return new ApiResponse(ResponseStatus.FAILURE, data, message);
    }

    /**
     * 에러
     */
    public static <T>ApiResponse<T> error (T data, ErrorCode message) {
        return error(data, message.getMessage());
    }

    public static <T>ApiResponse<T> error (T data, String message) {
        return new ApiResponse(ResponseStatus.ERROR, data, message);
    }
}
