package pro.sky.course2lesson5.checkpassword;

public class CheckPasswordApplication {
    public static void main(String[] args) {
        System.out.println("\nCourse 2, Lesson 5 homework\n");
        String login = "John",
                password = "D_1hWiKjjP_9",
                confirmPassword = "D_1hWiKjjP_9";
        System.out.println("We are calling checkPassword method to check LOGIN: " + login + " PASSWORD: " + password +
                " and CONFIRM PASSWORD: " + confirmPassword);
        try {
            CheckPasswordService.checkPassword(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            System.out.println("... " + wrongLoginException);
        } catch (WrongPasswordException wrongPasswordException) {
            System.out.println("... " + wrongPasswordException);
        } finally {
            System.out.println("... checkPassword method completed");
        }
    }
}
