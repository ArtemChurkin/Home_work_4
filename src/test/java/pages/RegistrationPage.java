package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            currentAddress = $("#currentAddress"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput =  $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            subjectOption = $("#react-select-2-option-0"),
            stateInput = $("#state"),
            cityInput  = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calenderComponent = new CalendarComponent();

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
    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
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
    public  RegistrationPage setState( String value) {
        stateInput.click();
        $(byText(value)).click();
        return this;
    }
    public  RegistrationPage setCity( String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkValidation() {
        $(".was-validated").shouldBe(visible);
        return this;
    }




    public void checkResult(String fullName, String artyomChurkin) {
    }


}
