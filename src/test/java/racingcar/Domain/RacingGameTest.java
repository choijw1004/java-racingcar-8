package racingcar.Domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    void game_정상_생성() {
        List<String> names = Arrays.asList("choi", "jang", "woo");
        Cars cars = new Cars(names);

        assertThatCode(() -> new RacingGame(cars, 5))
                .doesNotThrowAnyException();
    }

    @Test
    void game_시도_횟수_1_생성() {
        List<String> names = Arrays.asList("choi", "jang");
        Cars cars = new Cars(names);

        assertThatCode(() -> new RacingGame(cars, 1))
                .doesNotThrowAnyException();
    }

    @Test
    void game_시도_횟수_0_예외() {
        List<String> names = Arrays.asList("choi", "jang");
        Cars cars = new Cars(names);

        assertThatThrownBy(() -> new RacingGame(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    void game_시도_횟수_음수_예외() {
        List<String> names = Arrays.asList("choi", "jang");
        Cars cars = new Cars(names);

        assertThatThrownBy(() -> new RacingGame(cars, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }
}