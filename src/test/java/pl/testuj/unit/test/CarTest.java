package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.Car;

public class CarTest {
    
    @Test
    public void shouldReturnFiveDoors() {
        Car audi = new Car();
        Assertions.assertThat(audi.getNumberOfDoors()).isEqualTo(5);
    }

}
