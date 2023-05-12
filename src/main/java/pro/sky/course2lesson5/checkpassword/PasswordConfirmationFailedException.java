package pro.sky.course2lesson5.checkpassword;

public class PasswordConfirmationFailedException extends Exception {
    private static final String message = "PasswordConfirmationFailedException";

    public PasswordConfirmationFailedException() {
        super(message);
    }
}
