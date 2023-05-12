package pro.sky.course2lesson5.checkpassword;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckPasswordController {

    private final CheckPasswordService checkPasswordService = new CheckPasswordService();

    @GetMapping
    public String firstMessage() {
        return checkPasswordService.welcome();
    }

    @GetMapping("/checkpassword")
    public String callCheckPassword() {
        return checkPasswordService.wrapCheckPassword("John", "D_1hWiKjjP_901234567890123456789", " D_1hWiKjjP_9");
    }
}
