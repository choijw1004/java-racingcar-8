package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자 입력 클래스
 */
public class InputView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    /**
     * 자동차 이름들을 입력받는 메서드
     *
     * @return 자동차 이름 리스트
     */
    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();

        return splitByDelimiter(input);
    }

    /**
     * 입력 문자열을 구분자로 분리하는 메서드
     *
     * @param input 분리할 입력 문자열
     * @return 분리된 문자열 리스트
     */
    private List<String> splitByDelimiter(String input) {
        String[] carNames = input.split(DELIMITER);

        return Arrays.asList(carNames);
    }

    /**
     * 시도 횟수를 입력받는 메서드
     *
     * @return 시도 횟수
     */
    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
