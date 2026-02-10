import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHomeWorkWithComments1 {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Artyom");
        $("#lastName").setValue("Churkin");
        $("#currentAddress").setValue("Svobody 78");
        $("#userEmail").setValue("a.churkin@informer.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("89201171319");
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("December");//только если объект имеет тэг select и тэг option
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#dateOfBirthInput").shouldHave(value("03 Dec 1989"));
        $("#subjectsInput").setValue("Physics").pressEnter();
        //$("#subjectsInput").scrollTo().setValue("Physics").pressEnter();
        //$(".subjects-auto-complete__multi-value__label")
        //.shouldHave(text("Physics"));
        //$(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi").click();
        //$(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi").setValue("Ph").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        //$("#hobbiesWrapper").$(byText("Music)).click();
        //$("#uploadPicture").uploadFile(new File("Home_work_3.1/src/test/resources/img/123.png"));
        $("#uploadPicture").uploadFromClasspath("img/123.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // $(".table-responsive").shouldHave( text("Artyom"), text("a.churkin@informer.com"), text("89201171319"));


        sleep(5000L);



    }
}
