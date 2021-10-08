package racinggame.domain;

public class Car {
    private CarName name;
    private MoveDistance distance;
    private MoveBoolean isMove;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new MoveDistance();
        this.isMove = new MoveBoolean();
    }

    public CarName getName() {
        return name;
    }

    public MoveDistance getDistance() {
        return distance;
    }

    public MoveBoolean isMove() {
        return isMove;
    }

    public void move() {
        this.distance.move();
        this.isMove.move();
    }

    public void stop() {
        this.isMove.stop();
    }
}
