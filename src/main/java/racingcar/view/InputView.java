package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();

        return splitByDelimiter(input);
    }

    private List<String> splitByDelimiter(String input){
        String[] carNames = input.split(DELIMITER);

        return Arrays.asList(carNames);
    }

    public int readAttemptCount(){
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
