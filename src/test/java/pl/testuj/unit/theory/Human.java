package pl.testuj.unit.theory;

import static pl.testuj.unit.config.Constants.MAX_WORKING_AGE;
import static pl.testuj.unit.config.Constants.MIN_WORKING_AGE;

public class Human {

    private final int age;
    private final String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isEligibleForWork() {
        return age >= MIN_WORKING_AGE && age < MAX_WORKING_AGE;
    }
}
