package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#LastName"),
            addressInput = $("#currentAddress"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genderWrapper"),
            userNumberInput = $("#userNumber")
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
    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setAddressInput(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmailInput (String value) {
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
    public RegistrationPage setBirstDay(String day, String month, String year) {
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
