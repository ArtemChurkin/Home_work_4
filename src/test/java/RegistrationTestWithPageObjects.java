
//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import pages.RegistrationPage;
//
//import java.util.concurrent.StructuredTaskScope;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;

import java.util.concurrent.StructuredTaskScope;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class RegistrationTestWithPageObjects {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Artyom")
                .setLastName("Churkin")
                .setEmailInput("a.churkin@informer.com")
                .setGender("Male")
                .setUserNumber("89201171319")
                .setBirthDay("03", "Dec", "1989")
                .setSubject("Physics")
                .setHobby("Music")
                .setPicture("123.png")
                .setAddress("Svobody 78")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm()

                .checkFormAppears();

//        $(".table-responsive").shouldHave( text("Artyom"), text("a.churkin@informer.com"),
//                text("Male"), text("8920117131"),text("03 December,1989"),text("Physics")
//                ,text("Music"),text("123.png"),text("Svobody 78"),text("Rajasthan Jaipur"));
        registrationPage.checkResult("Full Name", "Artyom Churkin");


        sleep(5000L);



    }

    private void checkFormAppears() {
    }

    private StructuredTaskScope<Object, Object> registrationPage() {
    }
}

