import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @org.junit.Test
    public void test() {
        open("https://ru.selenide.org/index.html");
        $(".wrapper > header img").shouldBe(Condition.visible);
        $(Selectors.byXpath("/html/body/div[1]/div/header/a/img")).shouldBe(Condition.visible);
    }
}
