package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private static final int START_MAX_POSITION = 0;
    private static final int MIN_RANDOM = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_RANDOM = 9;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name.trim()));
        }

        return carList;
    }

    private void validateDuplicateName(List<String> names) {
        List<String> trimNameList = makeTrimNameList(names);
        HashSet<String> uniqueNameSet = new HashSet<>(trimNameList);

        if(trimNameList.size() != uniqueNameSet.size()){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private List<String> makeTrimNameList(List<String> names) {
        List<String> trimNameList = new ArrayList<>();

        for (String name : names) {
            trimNameList.add(name.trim());
        }

        return trimNameList;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(randomValue >= MOVE_CONDITION);
        }
    }

    public List<String> getCurrentStatusStringList() {
        List<String> statuses = new ArrayList<>();

        for (Car car : cars) {
            statuses.add(car.getStatusString());
        }

        return statuses;
    }

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

    private int findMaxPosition() {
        int maxPosition = START_MAX_POSITION;

        for (Car car : cars) {
            int position = car.getPosition();
            maxPosition = Math.max(position, maxPosition);
        }

        return maxPosition;
    }


}
