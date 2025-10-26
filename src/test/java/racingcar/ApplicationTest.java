package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러_번_시도_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("choi,jang,woo", "5");
                    assertThat(output()).contains("choi :", "jang :", "woo :", "최종 우승자 :");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("choi,jang", "1");
                    assertThat(output()).contains("choi : -", "jang : -", "최종 우승자 : choi,jang");  // 공백 제거
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 세_명_이상_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("choi,jang,woo", "1");
                    assertThat(output()).contains("최종 우승자 : choi,jang,woo");  // 공백 제거
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 빈_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("choi,,jang", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("choi,abcdef", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
