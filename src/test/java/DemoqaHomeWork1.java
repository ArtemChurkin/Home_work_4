
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaHomeWork1 {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/"); // Используем базовый URL из настроек

        // Удаление баннера по ID
        executeJavaScript("document.getElementById('fixedban')?.remove();");

// Удаление футера по тегу
        executeJavaScript("document.querySelector('footer')?.remove();");

        // Кликаем по карточке "Forms"
        // Используем более точный селектор для карточки на главной
        $(byText("Forms")).scrollTo().click();
        //$(".category-cards .card:nth-child(2)").scrollTo().click();


        // Переходим непосредственно в Practice Form
        $(byText("Practice Form")).click();

        // Проверка заголовка формы
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        $("#firstName").setValue("Artyom");
        $("#lastName").setValue("Churkin");
        $("#currentAddress").setValue("Svobody 78");
        $("#userEmail").setValue("a.churkin@informer.com");
        $("label[for='gender-radio-1']").click();
        //$("#genderWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89201171319");
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("December");//только если объект имеет тэг select и тэг option
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#dateOfBirthInput").shouldHave(value("03 Dec 1989"));
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("img/123.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave( text("Artyom"), text("a.churkin@informer.com"),
                text("Male"), text("8920117131"),text("03 December,1989"),text("Physics")
                ,text("Music"),text("123.png"),text("Svobody 78"),text("Rajasthan Jaipur"));


        sleep(5000L);



    }
}
