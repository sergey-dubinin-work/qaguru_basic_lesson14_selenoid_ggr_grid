package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:selenoid.properties"
})
public interface Configuration extends Config {

    @Key("selenoid.url")
    String selenoidUrl();

    @Key("selenoid.port")
    String selenoidPort();

    @Key("selenoid.ui.port")
    String selenoidUIPort();

    @Key("ggr.url")
    String ggrUrl();

    @Key("ggr.port")
    String ggrPort();

    @Key("ggr.web.username")
    String ggrWebUsername();

    @Key("ggr.web.userpassword")
    String ggrWebUserPassword();

}
