package racinggame.util;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarUtils {
    /**
     * 쉼표(,) 기준으로 파싱해서 자동차 리스트 생성
     */
    public static List<Car> createCarList(String inputStr) {
        String[] carNames = inputStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
