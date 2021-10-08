package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
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
        int randomNo = Randoms.pickNumberInRange(MIN_NO, MAX_NO);
        if (isMove(randomNo)) {
            car.move();
            return;
        }
        car.stop();
    }

    private boolean isMove(int randomNo) {
        return randomNo >= MIN_MOVE_NO;
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinners(maxDistance, winners, car);
        }
        return winners;
    }

    private void addWinners(int maxDistance, List<String> winners, Car car) {
        if (isEqualToMaxDistance(maxDistance, car)) {
            winners.add(car.getName().getValue());
        }
    }

    private boolean isEqualToMaxDistance(int maxDistance, Car car) {
        return car.getDistance().getValue() == maxDistance;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance().getValue());
        }
        return maxDistance;
    }
}
