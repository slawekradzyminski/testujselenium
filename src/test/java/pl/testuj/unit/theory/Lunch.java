package pl.testuj.unit.theory;

import static pl.testuj.unit.config.Constants.MAX_WAITING_TIME;
import static pl.testuj.unit.config.Constants.MIN_WAITING_TIME;

public class Lunch {

    private final String name;
    private final int price;
    private final int waitingTime;

    public Lunch(String name, int price, int waitingTime) {
        this.name = name;
        this.price = price;
        this.waitingTime = waitingTime;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isOkForSeleniumTraining() {
        return waitingTime >= MIN_WAITING_TIME && waitingTime <= MAX_WAITING_TIME;
    }
}
