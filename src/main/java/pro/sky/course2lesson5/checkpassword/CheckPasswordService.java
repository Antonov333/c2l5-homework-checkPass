package pro.sky.course2lesson5.checkpassword;

import org.springframework.stereotype.Service;

@Service
public class CheckPasswordService {

    public static void checkPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException, PasswordConfirmationFailedException {
        boolean b = allCharsValid(login);
        if (!allCharsValid(login) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!allCharsValid(password) || login.length() > 19) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new PasswordConfirmationFailedException();
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

    public String wrapCheckPassword(String login, String password, String confirmPassword) {

        String message = "We are calling checkPassword method to check LOGIN: " + login + " PASSWORD: " + password +
                " and CONFIRM PASSWORD: " + confirmPassword;
        message = concatAndPrint("", message);

        try {
            CheckPasswordService.checkPassword(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            message = concatAndPrint(message, "... " + wrongLoginException + ": wrong Login format");
        } catch (WrongPasswordException w) {
            message = concatAndPrint(message, "... " + w + ": wrong Password format");
        } catch (PasswordConfirmationFailedException p) {
            message = concatAndPrint(message, "... " + p + ": password confirmation failed");
        } finally {
            message = concatAndPrint(message, "... checkPassword method completed");
        }

        return "<h1><b>checkPassword method wrapping page</b></h1><br>" + message;
    }


    public String welcome() {
        return "<h1><b>Welcome to Exceptions homework (Course2, Lesson 5)</b></h1><br>" +
                "<a href=\"http://localhost:8080/checkpassword\"><b>Please click here to run checkPassword method</b></a>";
    }

    private static String concatAndPrint(String head, String tail) {
        System.out.println(tail);
        return head + tail + "<br>";
    }
}

