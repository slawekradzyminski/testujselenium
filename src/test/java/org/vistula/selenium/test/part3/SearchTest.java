package org.vistula.selenium.test.part3;

import org.junit.Test;
import org.vistula.selenium.pages.part3.MainPage;
import org.vistula.selenium.pages.part3.PostPage;
import org.vistula.selenium.pages.part3.SearchResultsPage;

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