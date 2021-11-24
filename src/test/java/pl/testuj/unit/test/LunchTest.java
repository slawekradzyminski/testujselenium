package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.Lunch;

public class LunchTest {

    @Test
    public void shouldCorrectlyGenerateLunchObject() {
        String dishName = "Chicken";
        Lunch hindus = new Lunch(dishName, 10, 50);
        Assertions.assertThat(hindus.getName()).isEqualTo(dishName);
        Assertions.assertThat(hindus.getWaitingTime()).isEqualTo(50);
        Assertions.assertThat(hindus.getPrice()).isEqualTo(10);
    }

    @Test
    public void shouldCorrectlyReturnTrainingEligibility() {
        String dishName = "Chicken";
        Lunch hindus1 = new Lunch(dishName, 10, 9);
        Lunch hindus2 = new Lunch(dishName, 10, 10);
        Lunch hindus3 = new Lunch(dishName, 10, 40);
        Lunch hindus4 = new Lunch(dishName, 10, 41);

        Assertions.assertThat(hindus1.isOkForSeleniumTraining()).isEqualTo(false);
        Assertions.assertThat(hindus2.isOkForSeleniumTraining()).isEqualTo(true);
        Assertions.assertThat(hindus3.isOkForSeleniumTraining()).isEqualTo(true);
        Assertions.assertThat(hindus4.isOkForSeleniumTraining()).isEqualTo(false);
    }

}
