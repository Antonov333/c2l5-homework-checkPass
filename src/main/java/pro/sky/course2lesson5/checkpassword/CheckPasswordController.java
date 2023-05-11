package pro.sky.course2lesson5.checkpassword;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckPasswordController {

    private CheckPasswordService checkPasswordService = new CheckPasswordService();

    @GetMapping
    public String firstMessage() {
        return "<h1><b>Welcome to Exceptions homework (Course2, Lesson 5)</b></h1><br><br>" +
                "checkPassword method is under construction";
    }

    @GetMapping("/cpm")
    public String callCheckPassword() {
        checkPasswordService.checkPassword("John", "ABCD", "ABCD");
        return "checkPassword method just completed";

    }


}
