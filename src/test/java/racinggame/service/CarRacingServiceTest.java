package racinggame.service;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarRacingServiceTest {
    CarRacingService carRacingService = CarRacingService.getInstance();

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0", "5, 1"})
    @DisplayName("자동차 경주")
    void 자동차_경주(int randomNo, int distance) {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            // given
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(randomNo);

            Car car1 = new Car("car1");
            Car car2 = new Car("car2");
            Car car3 = new Car("car3");
            List<Car> carList = Arrays.asList(car1, car2, car3);

            // when
            List<Car> resultCarList = carRacingService.race(carList);

            // then
            assertThat(resultCarList.size()).isEqualTo(carList.size());
            assertThat(resultCarList).contains(car1, car2, car3);
            assertThat(resultCarList.get(0).getDistance().getValue()).isEqualTo(distance);
            assertThat(resultCarList.get(1).getDistance().getValue()).isEqualTo(distance);
            assertThat(resultCarList.get(2).getDistance().getValue()).isEqualTo(distance);
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

        List<Car> carList = new ArrayList<>(Arrays.asList(car1, car2, car3));

        // when
        List<String> winners = carRacingService.getWinners(carList);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains(car1.getName().getValue(), car2.getName().getValue());
        assertThat(winners).doesNotContain(car3.getName().getValue());
    }
}