package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveDistanceTest {
    @Test
    void 전진() {
        // given
        MoveDistance distance1 = new MoveDistance();
        MoveDistance distance2 = new MoveDistance();

        // when
        distance1.move();

        // then
        assertThat(distance1.getValue()).isEqualTo(1);
        assertThat(distance2.getValue()).isEqualTo(0);
    }
}