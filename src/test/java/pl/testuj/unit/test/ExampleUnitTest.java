package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleUnitTest {

    @Test
    public void exampleUnitTest() {
        int a = 2;
        int b = 2;
        Assertions.assertThat(a+b != 5).isEqualTo(true);
    }

}
