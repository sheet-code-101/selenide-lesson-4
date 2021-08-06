package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideJUnit5ExampleAvailability {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://github.com";
        Configuration.startMaximized = true;
    }

    @Test
    void checkthatjunit5exampleispresent(){

        open("/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-box").$(".wiki-more-pages-link").$("button").click();
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
