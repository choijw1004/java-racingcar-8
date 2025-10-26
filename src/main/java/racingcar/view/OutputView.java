package racingcar.view;

import racingcar.dto.CarStatusDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ",";
    private static final String POSITION = "-";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printAttemptResult(List<CarStatusDto> statuses) {
        for (CarStatusDto status : statuses) {
            String formattedStatus = formatCarStatus(status);
            System.out.println(formattedStatus);
        }

        System.out.println();
    }

    private String formatCarStatus(CarStatusDto status){
        return status.name() + " : " + POSITION.repeat(status.position());
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winners));
    }
}
