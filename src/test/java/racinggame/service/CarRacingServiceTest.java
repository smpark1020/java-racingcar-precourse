package racinggame.service;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarRacingServiceTest {
    CarRacingService carRacingService = CarRacingService.getInstance();

    @ParameterizedTest
    @CsvSource(value = {"4, 1, true", "3, 0, false", "5, 1, true"})
    @DisplayName("자동차 경주")
    void race(int randomNo, int distance, boolean isMove) {
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
            assertThat(resultCarList.get(0).isMove().getValue()).isEqualTo(isMove);
            assertThat(resultCarList.get(1).isMove().getValue()).isEqualTo(isMove);
            assertThat(resultCarList.get(2).isMove().getValue()).isEqualTo(isMove);
        }
    }
}