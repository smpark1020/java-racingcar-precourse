package racinggame.util;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarUtils {
    public static List<Car> createCarList(String inputStr) {
        String[] carNames = inputStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
