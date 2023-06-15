package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ElementsPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainTests extends TestBase {
    ElementsPage elementsPage = new ElementsPage();

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка на поиск фильма, который есть на платформе")
    void specificMovieSearchTest() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Поиск фильма через кнопку 'Поиск'", () -> {
            elementsPage.searchBtn.click();
            elementsPage.searchModal.should(appear);
            elementsPage.searchInput.setValue(elementsPage.existingMovie).pressEnter();
            elementsPage.existingMovieElement.shouldHave(text(elementsPage.existingMovie));
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка появления сообщения 'Ничего не нашлось', при поиске отсутствующего на платформе фильма")
    void absentMovieSearchTest() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Поиск фильма отсутствующего фильма, через кнопку 'Поиск'", () -> {
            elementsPage.searchBtn.click();
            elementsPage.searchModal.should(appear);
            elementsPage.searchInput.setValue(elementsPage.absentMovie).pressEnter();
            elementsPage.emptyResultModal.shouldHave(text(elementsPage.notFoundResponse));
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка наличия на платформе страницы с зарубежными фильмами")
    void foreignMoviesSectionShouldExist() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Проверка наличия искомой страницы", () -> {
            elementsPage.headerMenu.hover();
            elementsPage.productModal.should(appear);
            elementsPage.foreignMoviesElement.click();
            elementsPage.foreignMoviesBar.shouldHave(text(elementsPage.productSectionTitle));
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка наличия фильмов жанра 'Биография'")
    void biopicMovieGenreShouldExist() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Проверка наличия искомого жанра фильмов в модальном окне", () -> {
            elementsPage.headerMenu.hover();
            elementsPage.biopicsElement.should(exist);
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка наличия сериалов жанра 'Биография'")
    void biopicSerialGenreShouldExist() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Проверка наличия искомого жанра сериалов в модальном окне", () -> {
            elementsPage.seriesElement.hover();
            elementsPage.biopicsElement.should(appear);
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка на исчезновение модального окна, после клика на один из предложенных элементов в нём")
    void modalWithCountriesShouldDisappearAfterSelectingCountry() {
        step("Запуск страницы зарубежных фильмов", () -> {
            open(elementsPage.foreignMoviesUrl);
        });
        step("Проверка появления при клике модального окна со странами пр-ва, на выбор", () -> {
            elementsPage.countriesBtn.click();
            elementsPage.countriesBar.should(appear);
        });
        step("Проверка исчезновения модального окна, после клика на элемент", () -> {
            elementsPage.specificCountryElement.click();
            elementsPage.countriesBar.should(disappear);
        });
    }

    @Test
    @Tag("remote_test")
    @DisplayName("Проверка присутствия на платформе страницы 'Политика конфиденциальности'")
    void shouldContainPrivacyPolicyPage() {
        step("Запуск главной страницы", () -> {
            open(elementsPage.pageUrl);
            sleep(3000);
            elementsPage.subscriptionModal.should(appear);
            elementsPage.subsModalCloseBtn.click();
        });
        step("Проверка наличия ссылки на страницу 'Политика конфиденциальности'", () -> {
            elementsPage.footer.scrollTo();
            elementsPage.privacyPolicyElement.click();
            elementsPage.pageElement.shouldHave(text(elementsPage.searchingPageName));
        });
    }
}
