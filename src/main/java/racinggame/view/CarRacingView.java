package racinggame.view;

import nextstep.utils.Console;
import racinggame.controller.CarRacingController;
import racinggame.domain.Car;
import racinggame.util.CarUtils;

import java.util.List;
import java.util.Map;

public class CarRacingView {

    public static void racingStart() {
        List<Car> carList = createCarList();

        int raceCount = getRaceCount();

        CarRacingController carRacingController = CarRacingController.getInstance();
        DistanceCache distanceCache = new DistanceCache(carList);
        carList = printRaceResult(carList, raceCount, carRacingController, distanceCache);

        printWinners(carList, carRacingController);
    }

    private static void printWinners(List<Car> carList, CarRacingController carRacingController) {
        System.out.print("최종 우승자는 ");
        List<String> winners = carRacingController.getWinners(carList);
        String winnerNames = printWinners(winners);
        System.out.println(winnerNames + " 입니다.");
    }

    private static List<Car> printRaceResult(List<Car> carList, int raceCount, CarRacingController carRacingController, DistanceCache distanceCache) {
        System.out.println();
        System.out.println("실행 결과");
        while (raceCount > 0) {
            carList = carRacingController.race(carList);
            printRacingResult(carList, distanceCache);
            System.out.println();
            raceCount--;
        }
        return carList;
    }

    private static int getRaceCount() {
        int raceCount = 0;
        while (isLessThanOrEqualZero(raceCount)) {
            raceCount = inputAndGetRaceCount();
        }
        return raceCount;
    }

    private static boolean isLessThanOrEqualZero(int count) {
        return count <= 0;
    }

    private static List<Car> createCarList() {
        List<Car> carList = null;
        while (isNullCarList(carList)) {
            carList = inputAndCreateCarList();
        }
        return carList;
    }

    private static boolean isNullCarList(List<Car> carList) {
        return carList == null;
    }

    private static int inputAndGetRaceCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String inputStr = Console.readLine();
            return toInteger(inputStr);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return 0;
    }

    private static List<Car> inputAndCreateCarList() {
        List<Car> carList = null;
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputStr = Console.readLine();
            carList = CarUtils.createCarList(inputStr);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return carList;
    }

    private static String printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {
            sb.append(winner);
            sb.append(",");
        }
        String winnerNames = sb.toString();
        return winnerNames.substring(0, winnerNames.length() - 1);
    }

    private static void printRacingResult(List<Car> carList, DistanceCache distanceCache) {
        for (Car car : carList) {
            System.out.print(car.getName().getValue() + " : ");
            System.out.println(getDistanceHyphen(car, distanceCache));
        }
    }

    private static String getDistanceHyphen(Car car, DistanceCache distanceCache) {
        int distance = car.getDistance().getValue();
        Map<Car, StringBuilder> map = distanceCache.getMap();
        StringBuilder hyphenBuilder = map.get(car);
        if (hyphenBuilder.length() < distance) {
            hyphenBuilder.append("-");
            map.put(car, hyphenBuilder);
        }
        return hyphenBuilder.toString();
    }

    private static int toInteger(String inputStr) {
        try {
            return getRaceCount(inputStr);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다. (입력값: " + inputStr + ")");
            return 0;
        }
    }

    private static int getRaceCount(String inputStr) {
        int inputCount = Integer.parseInt(inputStr);
        if (isLessThanOrEqualZero(inputCount)) {
            throw new IllegalArgumentException("회수는 1회 이상만 가능합니다. (입력값: " + inputCount + ")");
        }
        return inputCount;
    }

}
