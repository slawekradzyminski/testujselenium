package pl.testuj.unit.theory;

import java.util.HashMap;
import java.util.Map;

public class CredentialsValidator {

    private Map<String, String> credentials = new HashMap<>();

    public void addValidCredentials(String login, String password) {
        credentials.put(login, password);
    }

    public boolean validate(String login, String password) {
        if (credentials.get(login) == null) {
            return false;
        }

        return credentials.get(login).equals(password);
    }
}
