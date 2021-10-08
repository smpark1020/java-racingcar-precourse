package racinggame.domain;

public class MoveDistance {
    private int value;

    public int getValue() {
        return value;
    }

    /**
     * 이동 거리 1 증가
     */
    public void move() {
        this.value++;
    }
}
