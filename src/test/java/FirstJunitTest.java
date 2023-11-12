import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstJunitTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";


    }
    @Test
    void positiveTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        $(".table-responsive").shouldHave(text("Name"),text("pochta@mail.com"),text("9991234567"),
                text("Last Name"), text("01 April,2003"), text("Male"), text("English"), text("Reading"), text("1.png"),
                text("Some place"), text("Haryana Karnal"));


    }


}
