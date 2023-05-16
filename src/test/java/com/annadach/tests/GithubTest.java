package com.annadach.tests;

import static com.codeborne.selenide.Condition.*;

import com.annadach.allure.Layer;
import com.annadach.allure.Microservice;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("allure8")
@Layer("web")
public class GithubTest extends TestBase {

    @Test
    @AllureId("18956")
    @DisplayName("Поиск задачи в репозитории неавторизованным пользователем")
    @Tags({@Tag("critical"), @Tag("UI-tests")})
    @Microservice("Issue")
    @Feature("Поиск")
    void findExampleForJUnit5OnPageSelenideWiki() {
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

    @Test
    @AllureId("18951")
    @DisplayName("Неавторизованный пользователь может найти задачу в репозитории")
    @Owner("allure8")
    @Tags({@Tag("critical"), @Tag("UI-tests")})
    @Microservice("Issue")
    @Feature("Поиск")
    void SearchIssue() {
        step("Открыть главную страницу", () -> {
            open("/");
        });

        step("Найти репозиторий  allure-examples в форме поиска в шапке", () -> {

            step("Кликнуть на поисковую строку", () -> {
                $(By.name("q")).click();
            });

            step("Ввести текст  allure-examples", () -> {
                $(By.name("q")).setValue("allure-examples");
            });

            step("Нажать кнопку Enter", () -> {
                $(By.name("q")).pressEnter();
            });
        });

        step("Перейти по первой ссылке с списке allure-examples/allure-examples", () -> {
            $$(".repo-list li").first().$("a").click();
        });

        step("Перейти во вкладку Задачи (Issues)", () -> {
            $("#issues-tab").click();
        });

        step("Проверить наличие задачи #38 на странице", () -> {
            $(".js-navigation-container.js-active-navigation-container").shouldHave(text("#38"));
        });
    }
}
