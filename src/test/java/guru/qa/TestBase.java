package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.helpers.AllureAttachments;
import guru.qa.helpers.DriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static guru.qa.config.ConfigurationManager.getConfig;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = String.format(
                "http://%s:%s@%s:%s/wd/hub",
                getConfig().ggrWebUsername(),
                getConfig().ggrWebUserPassword(),
                getConfig().ggrUrl(),
                getConfig().ggrPort()
                );

        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", new HashMap<String, Object>() {
                    {
                        put("enableVNC", true);
                        put("enableVideo", true);
                    }
                }
        );

        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);


    }

    @AfterEach
    void tearDown() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        closeWebDriver();

        AllureAttachments.addVideo(sessionId);
    }

}
