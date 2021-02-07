package org.selenide.examples;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Search {
    @Test
    public void userCanSearch() throws InterruptedException {
        open ("https://www.championstore.com/en_gb/");

        SelenideElement searchElement = $("#search");
        searchElement.setValue("dress").pressEnter();
        ElementsCollection productList = $$(".product-item");
        productList.shouldBe(CollectionCondition.sizeGreaterThan(0));
//        Selenide.sleep(100000);
    }

    @Test
    public void userCanSearch2() throws InterruptedException {
        open ("https://www.championstore.com/en_gb/");

        SelenideElement searchElement = $("#search");
        searchElement.setValue("dress").pressEnter();
        ElementsCollection productList = $$(".product-item");
        productList.shouldBe(CollectionCondition.allMatch("match dress",
                element -> element.getText().toUpperCase().contains("DRESS"))
        );
//        Selenide.sleep(100000);
    }
    @Test
    public void userSeeNoResultForZZZ() throws InterruptedException {
        open ("https://www.championstore.com/en_gb/");

        SelenideElement searchElement = $("#search");
        searchElement.setValue("ZZZ").pressEnter();
        SelenideElement productList = $(".products.list");
        productList.shouldNotBe(visible);
        SelenideElement noResultsMessage = $(".message.notice");
        noResultsMessage.shouldBe(visible);
        noResultsMessage.shouldHave(text("Your search returned no results."));
//        Selenide.sleep(100000);
    }
}
