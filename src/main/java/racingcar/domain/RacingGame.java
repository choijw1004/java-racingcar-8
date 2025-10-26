package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.List;

/**
 * 자동차 경주 게임 관리 클래스
 */
public class RacingGame {
    private static final int MIN_ATTEMPT_COUNT = 1;

    private final Cars cars;
    private final int attemptCount;

    public RacingGame(Cars cars, int attemptCount) {
        validateAttemptCount(attemptCount);
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    /**
     * 시도 횟수의 유효성을 검증하는 메서드
     *
     * @param attemptCount 검증할 시도 횟수
     * @throws IllegalArgumentException 시도 횟수가 1 미만인 경우
     */
    private void validateAttemptCount(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    /**
     * 한 번의 경주를 진행하는 메서드
     */
    public void startRacing() {
        cars.moveCars();
    }

    /**
     * 모든 자동차의 현재 상태를 반환하는 메서드
     *
     * @return 자동차 상태 DTO 리스트
     */
    public List<CarStatusDto> getStatusDtos() {
        return cars.getStatusDtos();
    }

    /**
     * 우승자들의 이름을 반환하는 메서드
     *
     * @return 우승자 이름 리스트
     */
    public List<String> getWinners() {
        return cars.getWinners();
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
