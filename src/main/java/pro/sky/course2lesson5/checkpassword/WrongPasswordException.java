package pro.sky.course2lesson5.checkpassword;

public class WrongPasswordException extends Exception {
    private static final String message = "WrongPasswordException";

    public WrongPasswordException() {
        super(message);
    }
}
