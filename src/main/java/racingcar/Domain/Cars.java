package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    private final List<Car> cars;

    public Cars(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name.trim()));
        }

        return carList;
    }

    private boolean hasDuplicateName(List<String> names) {
        List<String> trimNameList = makeTrimNameList(names);
        HashSet<String> uniqueNameSet = new HashSet<>(trimNameList);

        if (trimNameList.size() != uniqueNameSet.size()) {
            return false;
        }

        return true;
    }

    private List<String> makeTrimNameList(List<String> names) {
        List<String> trimNameList = new ArrayList<>();

        for (String name : names) {
            trimNameList.add(name.trim());
        }

        return trimNameList;
    }

    public void moveCars(){
        for(Car car : cars){
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(randomValue >= MOVE_CONDITION);
        }
    }


}
