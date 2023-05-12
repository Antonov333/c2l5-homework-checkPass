package pro.sky.course2lesson5.checkpassword;

public class WrongLoginException extends Exception {
    private static final String message = "WrongLoginException";

    public WrongLoginException() {
        super(message);
    }
}
