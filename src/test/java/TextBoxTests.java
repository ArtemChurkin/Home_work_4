import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Artyom")
                .setUserEmail("a.churkin@informer.com")
                .setUserCurrentAddress("Svobody 78")
                .setUserPermanentAddress("Yaroslavl")
                .submitForm()
                .checkResult("name", "Artyom")
                .checkResult("email", "a.churkin@informer.com")
                .checkResult("currentAddress", "Svobody 78")
                .checkResult("permanentAddress", "Yaroslavl");
    }
}
