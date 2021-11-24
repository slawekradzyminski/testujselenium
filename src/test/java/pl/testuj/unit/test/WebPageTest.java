package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.WebPage;

public class WebPageTest {

    @Test
    public void shouldCorrectlyInitialiseNewObject() {
        String onet = "Onet.pl";
        WebPage webPage = new WebPage(onet);
        Assertions.assertThat(webPage.getTitle()).isEqualTo(onet);
    }

    @Test
    public void shouldTwoWebpagesBeEqual() {
        String onet = "Onet.pl";
        WebPage firstWebPage = new WebPage(onet);
        WebPage secondWebPage = new WebPage(onet);
        Assertions.assertThat(firstWebPage.equals(secondWebPage)).isEqualTo(true);
    }

}
