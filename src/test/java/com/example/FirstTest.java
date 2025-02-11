package com.example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    @Test
    void shouldFindSelenideRepositoryInGithub(){
        // Открывается страница Selenide и нажимается Enter
        open("https://github.com/");
        // Нажимаем на поле поиск
        $("[data-target=\"qbsearch-input.inputButton\"]").click();
        // Вводим в поле поиска selenide и нажимаем Enter
        $("#query-builder-test").setValue("Selenide").pressEnter();
        // Нажимаем на линк от первого результата поиска
        $$("[data-testid=\"results-list\"]").first().$("a").click();
        // Проверяем что в заголовке встречается selenide/selenide
        $("[data-turbo-frame=\"repo-content-turbo-frame\"]").shouldHave(text("selenide"));
        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();
        //Проверяем что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body .markdown-body").shouldHave(text("Soft Assertions"));
        // Открываем страницу SoftAssertions,
        $x("(//a[@href='/selenide/selenide/wiki/SoftAssertions'])").click();
        // Проверяем, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
