package pro.sky.course2lesson5.checkpassword;

import org.springframework.stereotype.Service;

/**
 * 1) Совсем не обязательно было делать контроллер и вывод в браузер. На данном этапе это не требовалось.
 * <p>
 * 2) Можно обойтись только двумя видами исключений WrongLoginException и WrongPasswordException и при выбрасывании
 * подкладывать в параметры конструктора нужное сообщение.
 */

@Service
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

    private static String concatAndPrint(String head, String tail) {
        System.out.println(tail);
        return head + tail + "<br>";
    }

    public String wrapCheckPassword(String login, String password, String confirmPassword) {

        String message = "We are calling checkPassword method to check LOGIN: " + login + " PASSWORD: " + password +
                " and CONFIRM PASSWORD: " + confirmPassword;
        message = concatAndPrint("", message);

        try {
            CheckPasswordService.checkPassword(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            message = concatAndPrint(message, "... " + wrongLoginException);
        } catch (WrongPasswordException w) {
            message = concatAndPrint(message, "... " + w);
        } finally {
            message = concatAndPrint(message, "... checkPassword method completed");
        }

        return "<h1><b>checkPassword method wrapping page</b></h1><br>" + message;
    }

    public String welcome() {
        return "<h1><b>Welcome to Exceptions homework (Course2, Lesson 5)</b></h1><br>" +
                "<a href=\"http://localhost:8080/checkpassword\"><b>Please click here to run checkPassword method</b></a>";
    }
}

