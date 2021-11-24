package pl.testuj.unit.test;

import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import pl.testuj.unit.theory.CredentialsValidator;

public class CredentialsValidatorTest {

    @Test
    public void shouldCorrectlyValidateCredentials() {
        CredentialsValidator credentialsValidator = new CredentialsValidator();
        String login = "Slawek";
        String password = "password";

        Assertions.assertThat(credentialsValidator.validate(login, password)).isFalse();
        credentialsValidator.addValidCredentials(login, password);
        Assertions.assertThat(credentialsValidator.validate(login, "invalidpassword")).isFalse();
        Assertions.assertThat(credentialsValidator.validate(login, password)).isTrue();
    }

}
