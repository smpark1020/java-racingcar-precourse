package racinggame.controller;

import racinggame.domain.Car;
import racinggame.service.CarRacingService;

import java.util.List;

public class CarRacingController {
    private static CarRacingController instance = new CarRacingController();

    private final CarRacingService carRacingService;

    private CarRacingController() {
        this.carRacingService = CarRacingService.getInstance();
    }

    public static CarRacingController getInstance() {
        return instance;
    }

    public List<Car> race(List<Car> carList) {
        return carRacingService.race(carList);
    }

}
