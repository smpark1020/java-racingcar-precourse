package racinggame.view;

import racinggame.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceCache {
    private Map<Car, StringBuilder> map = new HashMap<>();

    public DistanceCache(List<Car> carList) {
        for (Car car : carList) {
            map.put(car, new StringBuilder());
        }
    }

    public Map<Car, StringBuilder> getMap() {
        return map;
    }
}
