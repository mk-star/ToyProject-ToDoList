package hello.hello.spring.exception;

public class PasswordMismatchException extends Exception{
    private static final long serialVersionUID = 1L;

    public PasswordMismatchException() {

    }

    public PasswordMismatchException(String message) {
        super(message);
    }

}