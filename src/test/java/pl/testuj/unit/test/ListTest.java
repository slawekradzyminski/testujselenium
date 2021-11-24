package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.WebPage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListTest {

    @Test
    public void list() {
        List<WebPage> webPages = new ArrayList<>();
        WebPage onet = new WebPage("onet.pl");
        WebPage interia = new WebPage("interia.pl");
        WebPage wp = new WebPage("wp.pl");
        webPages.add(onet);
        webPages.add(interia);
        webPages.add(wp);

        Assertions.assertThat(webPages).hasSize(3);
        Assertions.assertThat(webPages.get(0).getTitle()).isEqualTo("onet.pl");
        Assertions.assertThat(webPages.contains(wp)).isTrue();

        List<String> titles = new ArrayList<>();
        for (WebPage localPage : webPages) {
            titles.add(localPage.getTitle());
        }
        Assertions.assertThat(titles).hasSize(3);
    }

    @Test
    public void set() {
        Set<WebPage> pages = new HashSet<>();
        WebPage onet1 = new WebPage("onet.pl");
        WebPage onet2 = new WebPage("onet.pl");
        pages.add(onet1);
        pages.add(onet2);
        Assertions.assertThat(pages).hasSize(1);
    }

}
