package racingcar.View;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ",";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printAttemptResult(List<String> statuses) {
        for (String status : statuses) {
            System.out.println(status);
        }

        System.out.println();
    }

    public void printWinners(List<String> winners){
        System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winners));
    }
}
