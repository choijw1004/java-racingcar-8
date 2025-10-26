package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarStatusDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 자동차 집합 클래스
 */
public class Cars {
    private static final int START_MAX_POSITION = 0;
    private static final int MIN_RANDOM = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_RANDOM = 9;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    /**
     * 자동차 이름의 중복 여부를 검증하는 메서드
     *
     * @param names 검증할 자동차 이름 목록
     * @throws IllegalArgumentException 중복된 이름이 있는 경우
     */
    private void validateDuplicateName(List<String> names) {
        HashSet<String> uniqueNameSet = new HashSet<>(names);

        if (names.size() != uniqueNameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    /**
     * 모든 자동차를 무작위로 이동시키는 메서드
     */
    public void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(randomValue >= MOVE_CONDITION);
        }
    }

    /**
     * 모든 자동차의 현재 상태를 반환하는 메서드
     *
     * @return 자동차 상태 DTO 리스트
     */
    public List<CarStatusDto> getStatusDtos() {
        List<CarStatusDto> statusDtos = new ArrayList<>();

        for (Car car : cars) {
            statusDtos.add(new CarStatusDto(car.getName(), car.getPosition()));
        }

        return statusDtos;
    }


    /**
     * 우승자들의 이름 리스트를 반환하는 메서드
     *
     * @return 우승자 이름 리스트
     */
    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    /**
     * 모든 자동차 중 최대 위치를 찾는 메서드
     *
     * @return 최대 위치
     */
    private int findMaxPosition() {
        int maxPosition = START_MAX_POSITION;

        for (Car car : cars) {
            int position = car.getPosition();
            maxPosition = Math.max(position, maxPosition);
        }

        return maxPosition;
    }


}
