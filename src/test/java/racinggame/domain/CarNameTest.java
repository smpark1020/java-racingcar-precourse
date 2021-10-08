package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름 유효성 검증 - 5자 이하 성공")
    void 자동차_이름_유효성_검증_5자_이하() {
        // given
        String name = "12345";

        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName.getValue()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름 유효성 검증 - 5자 초과로 실패")
    void 자동차_이름_유효성_검증_5자_초과() {
        // given
        String name = "123456";

        // when, then
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
                .hasMessageContaining(name);
    }
}