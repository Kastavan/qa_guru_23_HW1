import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstJunitTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void positiveTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Last Name");
        $("#userEmail").setValue("pochta@mail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9991234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("2003");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("image/1.png");
        $("#currentAddress").setValue("Some place");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Name"),text("pochta@mail.com"),text("9991234567"));


    }


}
