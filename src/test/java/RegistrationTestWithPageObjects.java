
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

//import java.util.concurrent.StructuredTaskScope;

//import java.util.concurrent.StructuredTaskScope;

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
    ModalComponent modalComponent= new ModalComponent();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Artyom")
                .setLastName("Churkin")
                .setEmailInput("a.churkin@informer.com")
                .setGender("Male")
                .setUserNumber("8920117131")
                .setBirthDay("03", "Dec", "1989")
                .setSubject("Physics")
                .setHobby("Music")
                .setPicture("img/123.PNG")
                .setAddress("Svobody 78")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm();

        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Artyom Churkin")
                .checkResult("Student Email", "a.churkin@informer.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8920117131")
                .checkResult("Date of Birth", "03 December,1989")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "123.png")
                .checkResult("Address", "Svobody 78")
                .checkResult("State and City", "Rajasthan Jaipur")
                .closeModal();

    }
    @Test
    void  minimalFormTest(){
        registrationPage.openPage()
                .setFirstName("Artyom")
                .setLastName("Churkin")
                .setGender("Male")
                .setUserNumber("8920117131")
                .submitForm();
        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Artyom Churkin")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8920117131")
                .closeModal();
    }

    @Test
    void fillNegativeFormTest() {
        registrationPage.openPage()
                .submitForm()
                .checkValidation();
        modalComponent.checkModalIsNotOpen();
    }
    }








