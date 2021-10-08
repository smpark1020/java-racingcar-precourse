package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 전진")
    void 자동차_전진() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        // when
        car1.move();

        // then
        assertThat(car1.getDistance().getValue()).isEqualTo(1);
        assertThat(car2.getDistance().getValue()).isEqualTo(0);
    }
}
