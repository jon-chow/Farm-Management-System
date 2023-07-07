package bean;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResult<T> {
    public enum Code {
        SUCCESS(SUCCESS_CODE),
        ERROR(ERROR_CODE)
        ;

        private final int value;

        private Code (int s) {
            this.value = s;
        }

        public int getValue() {
            return value;
        }
    }
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 404;


    private String status;
    private String message;
    private T data;
    private Code resultCode;

    public static <T> RestResult<T> success(final T data) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(SUCCESS);
        restResult.setMessage(SUCCESS);
        restResult.setResultCode(Code.SUCCESS);
        return restResult;
    }

    public static <T> RestResult<T> success(final T data, final String msg) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(SUCCESS);
        restResult.setMessage(msg);
        restResult.setResultCode(Code.SUCCESS);
        return restResult;
    }

    public static <T> RestResult<T> fail(final T data, final String msg) {
        final RestResult restResult = new <T>RestResult();
        restResult.setData(data);
        restResult.setStatus(ERROR);
        restResult.setMessage(msg);
        restResult.setResultCode(Code.ERROR);
        return restResult;
    }
}
