package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.List;

public class CarRacingService {

    private static CarRacingService instance = new CarRacingService();

    private CarRacingService() {

    }

    public static CarRacingService getInstance() {
        return instance;
    }

    /**
     * 자동차 경주 시작
     */
    public List<Car> race(List<Car> carList) {
        Cars cars = Cars.create(carList);
        cars.race();
        return cars.getCars();
    }

    /**
     * 우승자 조회
     */
    public List<String> getWinners(List<Car> carList) {
        Cars cars = Cars.create(carList);
        return cars.getWinners();
    }

}
