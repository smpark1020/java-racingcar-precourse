package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_NO = 0;
    private static final int MAX_NO = 9;
    private static final int MIN_MOVE_NO = 4;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    /**
     * 자동차 경주 시작
     */
    public void race() {
        for (Car car : cars) {
            moveByRandomNo(car);
        }
    }

    /**
     * 우승자 조회
     */
    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinners(maxDistance, winners, car);
        }
        return winners;
    }

    public static Cars create(List<Car> carList) {
        return new Cars(carList);
    }

    private void moveByRandomNo(Car car) {
        int randomNo = Randoms.pickNumberInRange(MIN_NO, MAX_NO);
        if (isMove(randomNo)) {
            car.move();
        }
    }

    private boolean isMove(int randomNo) {
        return randomNo >= MIN_MOVE_NO;
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
