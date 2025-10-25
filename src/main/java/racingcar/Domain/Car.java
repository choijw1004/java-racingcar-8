package racingcar.Domain;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String POSITION = "-";

    private final String name;
    private int position;

    public Car(String name) {
        isValidateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void isValidateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public String getStatusString() {
        return name + " : " + POSITION.repeat(position);
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}


