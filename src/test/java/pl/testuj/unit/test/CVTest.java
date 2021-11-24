package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.CV;

import java.util.ArrayList;
import java.util.List;

public class CVTest {

    @Test
    public void shouldCreateObject() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Selenium");
        CV myCv = new CV("Slawek", 19, skills);

        Assertions.assertThat(myCv.getSkills()).hasSize(2);
        Assertions.assertThat(myCv.getSkills().get(0)).isEqualTo("Java");
        Assertions.assertThat(myCv.getSkills().get(1)).isEqualTo("Selenium");
    }

}
