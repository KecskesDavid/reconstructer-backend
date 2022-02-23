package davidkecskes.stateproject.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends RuntimeException {

    public final static HttpStatus errorStatus = HttpStatus.NOT_FOUND;
    public final static String errorName = "Data Not Found Exception";

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
