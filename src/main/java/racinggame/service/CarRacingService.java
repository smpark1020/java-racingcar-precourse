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

    public List<Car> race(List<Car> carList) {
        Cars cars = Cars.create(carList);
        cars.race();
        return cars.getCars();
    }

    public List<String> getWinners(List<Car> carList) {
        Cars cars = Cars.create(carList);
        return cars.getWinners();
    }

}
