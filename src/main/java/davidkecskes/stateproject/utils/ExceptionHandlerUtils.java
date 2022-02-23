package davidkecskes.stateproject.utils;

import davidkecskes.stateproject.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionHandlerUtils {

    public static ResponseEntity<?> handler(Exception exception) {
        Map<String, String> error = new HashMap<>();
        HttpStatus errorStatus = getErrorStatus(exception);
        String errorName = getErrorName(exception);

        error.put("error", errorName);
        error.put("timestamp", LocalDate.now().toString());
        error.put("message", exception.getMessage());
        error.put("status", errorStatus.toString());
        return ResponseEntity.status(errorStatus).body(error);
    }

    private static HttpStatus getErrorStatus(Exception exception) {

        if (exception instanceof DataNotFoundException) {
            return DataNotFoundException.errorStatus;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private static String getErrorName(Exception exception) {

        if (exception instanceof DataNotFoundException) {
            return DataNotFoundException.errorName;
        }

        return "Internal Server Error";
    }
//
//    private static ResponseEntity<?> unexpectedException() {
//        Map<String, String> error = new HashMap<>();
//
//        error.put("error", "An unexpected error occurred on server side.");
//        error.put("timestamp", LocalDate.now().toString());
//        error.put("message", "An unexpected error occurred on server side.");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
//    }
//
//    private static ResponseEntity<?> dataNotFoundException(String message) {
//        Map<String, String> error = new HashMap<>();
//        error.put("errorMessage", message);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//    }
//
//    private static ResponseEntity<?> duplicatedEmailException(String message) {
//        Map<String, String> error = new HashMap<>();
//        error.put("errorMessage", message);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//    }
}
