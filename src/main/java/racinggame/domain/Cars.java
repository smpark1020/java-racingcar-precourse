package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.List;

public class Cars {
    private static int MIN_NO = 0;
    private static int MAX_NO = 9;
    private static int MIN_MOVE_NO = 4;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            moveByRandomNo(car);
        }
    }

    private void moveByRandomNo(Car car) {
        if (Randoms.pickNumberInRange(MIN_NO, MAX_NO) >= MIN_MOVE_NO) {
            car.move();
        }
    }
}
