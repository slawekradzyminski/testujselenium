package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.Human;

public class HumanTest {

    @Test
    public void shouldCreateNewHuman() {
        String name = "Slawek";
        int age = 18;
        Human me = new Human(age, name);
        Assertions.assertThat(me.getAge()).isEqualTo(age);
        Assertions.assertThat(me.getName()).isEqualTo(name);
    }

    @Test
    public void shouldCorrectlyReturnEligibility() {
        Human me = new Human(17, "Slawek");
        Human me2 = new Human(18, "Slawek");
        Human me3 = new Human(64, "Slawek");
        Human me4 = new Human(65, "Slawek");
        Assertions.assertThat(me.isEligibleForWork()).isEqualTo(false);
        Assertions.assertThat(me2.isEligibleForWork()).isEqualTo(true);
        Assertions.assertThat(me3.isEligibleForWork()).isEqualTo(true);
        Assertions.assertThat(me4.isEligibleForWork()).isEqualTo(false);
    }

}
