package bean;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResult<T> {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    private String status;
    private String message;
    private T data;

    public static <T> RestResult<T> success(final T data) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(SUCCESS);
        restResult.setMessage(SUCCESS);
        return restResult;
    }

    public static <T> RestResult<T> success(final T data, final String msg) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(SUCCESS);
        restResult.setMessage(msg);
        return restResult;
    }

    public static <T> RestResult<T> fail(final T data, final String msg) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(ERROR);
        restResult.setMessage(msg);
        return restResult;
    }
}
