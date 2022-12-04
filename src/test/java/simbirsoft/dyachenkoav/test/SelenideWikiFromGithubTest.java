package simbirsoft.dyachenkoav.test;

import static com.codeborne.selenide.Condition.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiFromGithubTest {
    @Test
    void findExampleForJUnit5OnPageSelenideWiki(){
        //Поиск и переход на страницу Selenide в Github
        open("https://github.com");
        //Ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на первую ссылку в выдаче поиска
        $$(".repo-list li").first().$("a").click();
        //Проверить, что в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide/selenide"));
        //Переход в раздел Wiki
        $("#wiki-tab").click();
        //Ракрыть полный список страниц Pages
        $$(".js-wiki-sidebar-toggle-display li").last().$("button").click();
        //Проверить, что в списке есть ссылка на страницу SoftAssertions
        $$(".js-wiki-sidebar-toggle-display li summary").last().$("a").shouldHave(text("SoftAssertions"));
        //Перейти на страницу SoftAssertions
        $$(".js-wiki-sidebar-toggle-display li summary").last().$("a").click();
        //Проверить, что на странице есть пример кода для JUnit5 - "Using JUnit5 extend test class"
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("JUnit5"));
    }
}
