package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.WebPage;

public class WebPageTest {
    
    @Test
    public void shouldCorrectlyInitialiseNewObject() {
        WebPage webPage = new WebPage("Onet.pl");
        Assertions.assertThat(webPage.getTitle()).isEqualTo("Onet.pl");
    }


}
