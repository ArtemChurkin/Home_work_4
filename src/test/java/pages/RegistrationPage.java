package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            currentAddress = $("#currentAddress"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genderWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput =  $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            subjectOption = $("#react-select-2-option-0")
                    ;

    public RegistrationPage openPage() {
        open("/");
        executeJavaScript("document.getElementById('fixedban')?.remove();");
        executeJavaScript("document.querySelector('footer')?.remove();");
        $(byText("Forms")).scrollTo().click();
        $(byText("Practice Form")).click();
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }
    public RegistrationPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectOption.click();
        return this;
    }
    public RegistrationPage setHobby(String value) {
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("December");//только если объект имеет тэг select и тэг option
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click(); ;

        return this;
    }


    public void checkResult(String fullName, String artyomChurkin) {
    }


}
