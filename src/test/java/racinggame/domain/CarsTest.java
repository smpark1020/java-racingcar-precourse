package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"4, true", "3, false", "5, true"})
    @DisplayName("randomNo에 따라 전진해도 되는지 여부")
    void isMove(int randomNo, boolean expectResult) throws Exception {
        // given
        Method isMove = Cars.class.getDeclaredMethod("isMove", int.class);
        isMove.setAccessible(true);

        Cars cars = new Cars(Arrays.asList(new Car("car")));
        // when
        boolean result = (boolean) isMove.invoke(cars, randomNo);

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0", "5, 1"})
    @DisplayName("randomNo에 따라 자동차 전진")
    void moveByRandomNo(int randomNo, int distance) throws Exception {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            Method moveByRandomNo = Cars.class.getDeclaredMethod("moveByRandomNo", Car.class);
            moveByRandomNo.setAccessible(true);

            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomNo);

            Car car = new Car("car");
            Cars cars = new Cars(Arrays.asList(car));

            // when
            moveByRandomNo.invoke(cars, car);

            // then
            assertThat(car.getDistance().getValue()).isEqualTo(distance);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0", "5, 1"})
    @DisplayName("자동차 경주 시작")
    void race(int randomNo, int distance) throws Exception {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomNo);

            Car car1 = new Car("car1");
            Car car2 = new Car("car2");
            Car car3 = new Car("car3");
            Cars cars = new Cars(Arrays.asList(car1, car2, car3));

            // when
            cars.race();

            // then
            assertThat(car1.getDistance().getValue()).isEqualTo(distance);
            assertThat(car2.getDistance().getValue()).isEqualTo(distance);
            assertThat(car3.getDistance().getValue()).isEqualTo(distance);
        }
    }

    @Test
    @DisplayName("우승자 조회")
    void 우승자_조회() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move();
        car2.move();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        // when
        List<String> winners = cars.getWinners();

        // then
        assertThat(winners).contains(car1.getName().getValue());
        assertThat(winners).contains(car2.getName().getValue());
        assertThat(winners).doesNotContain(car3.getName().getValue());
    }
}
