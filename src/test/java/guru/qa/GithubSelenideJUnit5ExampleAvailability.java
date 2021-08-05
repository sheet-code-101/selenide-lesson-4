package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
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
        $$("li").findBy(text("SoftAssertions")).shouldBe(visible).click();
        $$("ol").findBy(attribute("start", "3"))
                .$("li").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
