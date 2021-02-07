import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Language {
    private String locale;
    @org.junit.Test
    public void test() {
        open("https://www.championstore.com/en_gb/");
        SelenideElement acceptCookies = $("#onetrust-accept-btn-handler");
        acceptCookies.click();
        SelenideElement langButton = $("div.store-switcher__container > button");
        langButton.click();
        SelenideElement frenchLang = $(".store-switcher__item-fr");
        frenchLang.click();
        SelenideElement htmlPage = $("html");

        htmlPage.shouldHave(Condition.attribute("lang", "fr"));


    }
}
