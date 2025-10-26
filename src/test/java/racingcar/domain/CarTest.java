package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


public class CarTest {

    @Test
    void car_정상_생성() {
        assertThatCode(() -> new Car("choi"))
                .doesNotThrowAnyException();
    }

    @Test
    void car_이름_5자_생성() {
        assertThatCode(() -> new Car("12345"))
                .doesNotThrowAnyException();
    }

    @Test
    void car_이름_5자_초과_예외() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_이름_null_예외() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_이름_빈문자열_예외() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_이름_공백_예외() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_우승자_판단_true() {
        Car car = new Car("choi");
        car.move(true);
        car.move(true);
        car.move(true);
        assertThat(car.isWinner(3)).isTrue();
    }

    @Test
    void car_우승자_판단_false() {
        Car car = new Car("choi");
        car.move(true);
        car.move(true);
        assertThat(car.isWinner(3)).isFalse();
    }

    @Test
    void car_우승자_판단_위치0() {
        Car car = new Car("choi");
        assertThat(car.isWinner(0)).isTrue();
    }
}