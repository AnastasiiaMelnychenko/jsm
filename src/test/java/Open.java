import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Open {

    @org.junit.Test
    public void test() {
        open("https://www.championstore.com/en_gb/");

    }
}