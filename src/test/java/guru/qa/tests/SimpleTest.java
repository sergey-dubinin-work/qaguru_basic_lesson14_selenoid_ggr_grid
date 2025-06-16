package guru.qa.tests;

import guru.qa.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest extends TestBase {


    @Test
    void simpleTest() {

        open("https://github.com/");

        $(".search-input-container")
                .click();

        $("#query-builder-test")
                .setValue("selenide")
                .pressEnter();

        $("[data-testid=results-list]")
                .shouldHave(text("selenide"));

    }

}
