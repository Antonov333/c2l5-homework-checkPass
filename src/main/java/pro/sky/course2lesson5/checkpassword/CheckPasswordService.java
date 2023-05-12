package pro.sky.course2lesson5.checkpassword;

/**
 * 1) Совсем не обязательно было делать контроллер и вывод в браузер. На данном этапе это не требовалось.
 * <p>
 * 2) Можно обойтись только двумя видами исключений WrongLoginException и WrongPasswordException и при выбрасывании
 * подкладывать в параметры конструктора нужное сообщение.
 */


public class CheckPasswordService {

    public static void checkPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        boolean b = allCharsValid(login);
        if (!allCharsValid(login) || login.length() > 20) {
            throw new WrongLoginException("wrong Login format");
        }
        if (!allCharsValid(password) || password.length() > 19) {
            throw new WrongPasswordException("wrong Password format");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password confirmation failed");
        }
    }

    private static boolean allCharsValid(String string) {
        boolean b = true;
        for (char c : string.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                b = false;
                return b;
            }
        }
        return b;
    }
}

