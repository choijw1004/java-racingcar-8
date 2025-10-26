package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


class CarsTest {

    @Test
    void cars_정상_생성() {
        List<String> names = Arrays.asList("choi", "jang", "woo");
        assertThatCode(() -> new Cars(names))
                .doesNotThrowAnyException();
    }

    @Test
    void cars_중복_이름_예외() {
        List<String> names = Arrays.asList("choi", "choi", "woo");
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void cars_공백_제거_후_중복_예외() {
        List<String> names = Arrays.asList("choi", " choi ", "woo");
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void cars_빈_이름_예외() {
        List<String> names = Arrays.asList("choi", "", "woo");
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void cars_이름_5자_초과_예외() {
        List<String> names = Arrays.asList("choi", "verylongname", "woo");
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void cars_초기_우승자_모두() {
        List<String> names = Arrays.asList("choi", "jang", "woo");
        Cars cars = new Cars(names);

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("choi", "jang", "woo");
    }
}