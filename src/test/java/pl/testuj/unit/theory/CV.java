package pl.testuj.unit.theory;

import java.util.List;

public class CV {

    private final String name;
    private final int age;
    private final List<String> skills;

    public CV(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }
}
