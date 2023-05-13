package com.annadach.tests;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("allure8")
public class GithubTest extends TestBase{

    @Test
    @AllureId("18956")
    @DisplayName("Поиск задачи в репозитории неавторизованным пользователем")
    @Tags({@Tag("critical")})
    void findExampleForJUnit5OnPageSelenideWiki(){
        step("Открыть главную страницу", () -> {
                open("/");
        });

        step("Найти репозиторий \"selenide\"", () -> {

            step("В поле поиска в шапке ввести текст \"selenide\"", () -> {
                $("[data-scoped-placeholder=Search]").setValue("selenide");
            });

            step("Кликнуть Enter", () -> {
                $("[data-scoped-placeholder=Search]").pressEnter();
            });

            step("Перейти по первой ссылке selenide/selenide", () -> {
                $$(".repo-list li").first().$("a").click();
                $("h1").shouldHave(text("selenide/selenide"));
            });
        });

        step("Открыть таб \"Wiki\"", () -> {
            $("#wiki-tab").click();
        });

        step("Перейти на страницу SoftAssertions", () -> {

            step("Открыть полный список страниц (Pages) кликом по тексту \"Show 2 more pages...\"", () -> {
                $$(".js-wiki-sidebar-toggle-display li").last().$("button").click();
                $$(".js-wiki-sidebar-toggle-display li summary").last().$("a").shouldHave(text("SoftAssertions"));
            });

            step("Кликнуть по ссылке SoftAssertions", () -> {
                $$(".js-wiki-sidebar-toggle-display li summary").last().$("a").click();
            });
        });

        step("Убедиться, что на странице присутствует текст \"Using JUnit5 extend test class\"", () -> {
            $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("JUnit5"));
        });
    }
}
