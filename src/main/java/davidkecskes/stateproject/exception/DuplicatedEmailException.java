package davidkecskes.stateproject.exception;

// TODO : delete class
public class DuplicatedEmailException extends RuntimeException {

    public DuplicatedEmailException() {
        super();
    }

    public DuplicatedEmailException(String message) {
        super(message);
    }
}
