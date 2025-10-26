package racingcar.view;

import racingcar.dto.CarStatusDto;

import java.util.List;

/**
 * 게임 결과를 출력 클래스
 */
public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ",";
    private static final String POSITION = "-";

    /**
     * 실행 결과 메시지를 출력하는 메서드
     */
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    /**
     * 각 시도의 결과를 출력하는 메서드
     *
     * @param statuses 자동차 상태 리스트
     */
    public void printAttemptResult(List<CarStatusDto> statuses) {
        for (CarStatusDto status : statuses) {
            String formattedStatus = formatCarStatus(status);
            System.out.println(formattedStatus);
        }

        System.out.println();
    }

    /**
     * 자동차 상태를 출력 형식으로 포맷하는 메서드
     *
     * @param status 포맷할 자동차 상태 DTO
     * @return 포맷된 상태 문자열
     */
    private String formatCarStatus(CarStatusDto status) {
        return status.name() + " : " + POSITION.repeat(status.position());
    }

    /**
     * 최종 우승자들을 출력하는 메서드
     *
     * @param winners 우승자 이름 리스트
     */
    public void printWinners(List<String> winners) {
        System.out.println(WINNER_PREFIX + String.join(WINNER_DELIMITER, winners));
    }
}
