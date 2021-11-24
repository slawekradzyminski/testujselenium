package pl.testuj.unit.theory;

public class Car {

    private final int numberOfDoors;
    private int gear = 0;

    public Car(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void increaseGear() {
//        this.gear = this.gear + 1;
        this.gear++;
    }

    public void decreaseGear() {
//        this.gear = this.gear - 1;
        this.gear--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return numberOfDoors == car.numberOfDoors;
    }

    @Override
    public int hashCode() {
        return numberOfDoors;
    }
}
