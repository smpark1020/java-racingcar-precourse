package racinggame.controller;

import racinggame.domain.Car;
import racinggame.service.CarRacingService;

import java.util.List;

public class CarRacingController {
    private static final CarRacingController instance = new CarRacingController();

    private final CarRacingService carRacingService;

    private CarRacingController() {
        this.carRacingService = CarRacingService.getInstance();
    }

    public static CarRacingController getInstance() {
        return instance;
    }

    /**
     * 자동차 경주 시작
     */
    public List<Car> race(List<Car> carList) {
        return carRacingService.race(carList);
    }

    /**
     * 우승자 조회
     */
    public List<String> getWinners(List<Car> carList) {
        return carRacingService.getWinners(carList);
    }
}
