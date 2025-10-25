package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final int MIN_ATTEMPT_COUNT = 1;

    private final Cars cars;
    private final int attemptCount;

    public RacingGame(Cars cars, int attemptCount) {
        validateAttemptCount(attemptCount);
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    private void validateAttemptCount(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void startRacing() {
        cars.moveCars();
    }

    public List<String> getCurrentStatusStringList() {
        return cars.getCurrentStatusStringList();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
