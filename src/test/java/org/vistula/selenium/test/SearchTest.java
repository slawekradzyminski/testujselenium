package org.vistula.selenium.test;

import org.junit.Test;
import org.vistula.selenium.pages.MainPage;
import org.vistula.selenium.pages.PostPage;
import org.vistula.selenium.pages.SearchResultsPage;

public class SearchTest extends SeleniumTest {

    private static final String BLOG = "https://www.awesome-testing.com";

    @Test
    public void shouldSuccessfullyFindPostAndDisplayCommentsSection() {
        driver.get(BLOG);
        MainPage mainPage = new MainPage(driver);
        mainPage.isInitialized();

        SearchResultsPage searchResultsPage =  mainPage.searchFor("public speaking");
        searchResultsPage.isInitialized();
        searchResultsPage.assertThatPostsAreDisplayed();

        PostPage postPage = searchResultsPage.clickOnFirstPost();
        postPage.isInitialized();
        postPage.assertThatCommentSectionIsDisplayed();
    }
}