package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.Car;

public class CarTest {

    @Test
    public void shouldReturnCorrectNumberOfDoors() {
        Car audi = new Car(5);
        Car volvo = new Car(3);
        Assertions.assertThat(audi.getNumberOfDoors()).isEqualTo(5);
        Assertions.assertThat(volvo.getNumberOfDoors()).isEqualTo(3);
    }

    @Test
    public void shouldCorrectlySetGear() {
        Car bmw = new Car(5);
        Assertions.assertThat(bmw.getGear()).isEqualTo(0);
        bmw.setGear(2);
        Assertions.assertThat(bmw.getGear()).isEqualTo(2);
        bmw.setGear(3);
        Assertions.assertThat(bmw.getGear()).isEqualTo(3);
    }

    @Test
    public void shouldCorrectlyIncreaseGear() {
        Car suzuki = new Car(3);
        suzuki.increaseGear();
        Assertions.assertThat(suzuki.getGear()).isEqualTo(1);
        suzuki.setGear(3);
        suzuki.increaseGear();
        Assertions.assertThat(suzuki.getGear()).isEqualTo(4);
    }

    @Test
    public void shouldCorrectlyDecreaseGear() {
        Car suzuki = new Car(3);
        suzuki.setGear(3);
        suzuki.decreaseGear();
        Assertions.assertThat(suzuki.getGear()).isEqualTo(2);
    }

}
