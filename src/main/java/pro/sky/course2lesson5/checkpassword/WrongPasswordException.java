package pro.sky.course2lesson5.checkpassword;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String note) {
        super(note);
    }
}
