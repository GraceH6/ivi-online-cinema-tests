package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ElementsPage {
    TestData testData = new TestData();

    public String pageUrl = testData.getUrl(),
            foreignMoviesUrl = testData.getForeignMoviesPageUrl(),
            existingMovie = testData.getMovieNameForPos(),
            absentMovie = testData.getMovieNameForNeg(),
            notFoundResponse = testData.getNotFound(),
            moviesButton = testData.getMovies(),
            productVariety = testData.getVariety(),
            productGenre = testData.getGenre(),
            productSectionTitle = testData.getSectionTitle(),
            seriesButton = testData.getSeries(),
            menuSectionType = testData.getMenuSection(),
            countryName = testData.getCountry(),
            searchingPageName = testData.getSearchingPage();

    public SelenideElement subscriptionModal = $("div.fullscreen-popup"),
            subsModalCloseBtn = $("div.nbl-controlButton__caption"),
            searchBtn = $("button[data-test='header_search']"),
            searchModal = $("div.search"),
            searchInput = $("input[data-test='search_input']"),
            existingMovieElement = $(".searchBlock__searchResultItem").$(".nbl-slimPosterBlock__title"),
            emptyResultModal = $(".emptyResult__title"),
            headerMenu = $$(".headerMenu__listItem").filterBy(text(moviesButton)).first(),
            productModal = $("#headerDropdownBody"),
            foreignMoviesElement = $$(".dropdownLinksList__item").filterBy(text(productVariety)).first(),
            foreignMoviesBar = $(".headerBar__titleSection"),
            biopicsElement = $$(".dropdownLinksList__item").filterBy(text(productGenre)).first(),
            seriesElement = $$(".headerMenu__listItem").filterBy(text(seriesButton)).first(),
            countriesBtn = $$(".filtersDesktop__plank-item").filterBy(text(menuSectionType)).first(),
            countriesBar = $(".filterDropdown__content"),
            specificCountryElement = $$(".filterDropdown__item").filterBy(text(countryName)).first(),
            privacyPolicyElement = $("a[href='/info/confidential']"),
            pageElement = $(".textual__content"),
            footer = $(".iviFooter__container");
}
