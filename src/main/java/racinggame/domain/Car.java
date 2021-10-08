package racinggame.domain;

public class Car {
    private CarName name;
    private MoveDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new MoveDistance();
    }

    public CarName getName() {
        return name;
    }

    public MoveDistance getDistance() {
        return distance;
    }

    public void move() {
        this.distance.move();
    }
}
