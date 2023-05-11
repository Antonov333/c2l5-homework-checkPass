package pro.sky.course2lesson5.checkpassword;

import org.springframework.stereotype.Service;

@Service
public class CheckPasswordService {
    /**
     * # 2.4. Работа с исключениями
     * <p>
     * > Привет!
     * На связи домашнее задание урока 2.4 Работа с исключениями.
     * Домашнее задание пришлите в формате ссылки на pull-request на платформу.
     * >
     * <p>
     * 1. Напишите статический метод, который принимает на вход три параметра: login, password и confirmPassword.
     * 2. Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
     * *Например, java_skypro_go*
     * 1. У параметра login есть ограничение по длине – он должен быть равен или меньше 20 символов. Если login длиннее 20 символов, то  необходимо выбросить исключение – `WrongLoginException`.
     * 3. Параметр Password содержит в себе только латинские буквы, цифры и знак подчеркивания.
     * *Например, D_1hWiKjjP_9*
     * 4. У параметра password тоже есть ограничение по длине – он должен быть строго меньше 20 символов.
     * 5. Параметры password и confirmPassword должны быть равны. Если это требование не соблюдается, то нужно выбросить `WrongPasswordException`.
     * 6. Для обработки исключений используйте multi-catch block.
     * 7. Метод ничего не должен возвращать , если значения параметров подходят под ограничения,  или бросать исключение, если условия не выполняются.
     * 8. При вызове метода необходимо обработать потенциальные исключения
     * - *Подсказка*
     * <p>
     * ```java
     * *try {// Блок кода, в котором должны отслеживаться ошибки
     * }catch (тип_исключения_1 объект_исключения) {
     * // Обработка исключения тип_исключения_1// }
     * <p>
     * catch (тип_исключения_2 объект_исключения) {
     * // Обработка исключения тип_исключения_2
     * }
     * // ...
     * finally
     * // блок кода, который должен быть непременно выполнен по завершении блока try
     * }*
     * ```
     * <p>
     * <p>
     * - Критерии оценки:
     * - Статический метод принимает на вход три параметра
     * - Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания
     * - Параметр Password содержит в себе только латинские буквы, цифры и знак подчеркивания
     * - Параметры Password и confirmPassword должны быть равны
     * - Если параметр Login длиннее 20 символов, то выбрасывается ошибка `WrongLoginException`
     * - Если параметры password и confirmPassword  не равны, выбрасывается ошибка `WrongPasswordException`.
     * - Исключения обработаны в multi-catch block.
     */

    public static void checkPassword(String login, String password, String confirmPassword) {
        System.out.println("checkPassword is checking LOGIN: " + login + " PASSWORD: " + password +
                " and CONFIRM PASSWORD: " + confirmPassword);
        boolean b = allCharsValid(login);
        if (!allCharsValid(login) || login.length() > 20) {
            throw new RuntimeException("Wrong login format");
        }
        if (!allCharsValid(password) || login.length() > 19) {
            throw new RuntimeException("Wrong password format");
        }
        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Password confirmation failed");
        }
    }


    public static boolean allCharsValid(String string) {
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

