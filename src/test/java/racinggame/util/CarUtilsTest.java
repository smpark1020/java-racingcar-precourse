package racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarUtilsTest {
    @Test
    @DisplayName("자동차리스트 생성 성공")
    void 자동차리스트_생성_성공() {
        // given
        String inputStr = "pobi,crong,honux";

        // when
        List<Car> carList = CarUtils.createCarList(inputStr);

        // then
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName().getValue()).isEqualTo("pobi");
        assertThat(carList.get(1).getName().getValue()).isEqualTo("crong");
        assertThat(carList.get(2).getName().getValue()).isEqualTo("honux");
        assertThat(carList.get(0).getDistance().getValue()).isEqualTo(0);
        assertThat(carList.get(1).getDistance().getValue()).isEqualTo(0);
        assertThat(carList.get(2).getDistance().getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차리스트 생성 실패 - 5자 초과")
    void 자동차리스트_생성_실패_5자_초과() {
        // given
        String inputStr = "pobi,crong,honuxx";

        // when, then
        assertThatThrownBy(() -> CarUtils.createCarList(inputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
                .hasMessageContaining("honuxx");
    }
}