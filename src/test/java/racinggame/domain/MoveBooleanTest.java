package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveBooleanTest {
    @Test
    void move() {
        // given
        MoveBoolean moveBoolean = new MoveBoolean();

        // when
        moveBoolean.move();

        // then
        assertThat(moveBoolean.getValue()).isTrue();
    }

    @Test
    void stop() {
        // given
        MoveBoolean moveBoolean = new MoveBoolean();
        moveBoolean.move();
        assertThat(moveBoolean.getValue()).isTrue();

        // when
        moveBoolean.stop();

        // then
        assertThat(moveBoolean.getValue()).isFalse();
    }
}