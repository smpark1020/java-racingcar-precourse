package racinggame.domain;

public class MoveBoolean {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void move() {
        this.value = true;
    }

    public void stop() {
        this.value = false;
    }
}
