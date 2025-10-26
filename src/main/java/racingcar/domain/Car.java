package racingcar.domain;

/**
 * 개별 자동차 클래스
 */
public class Car {
    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    /**
     * 자동차 이름의 유효성을 검증하는 메서드
     *
     * @param name 검증할 자동차 이름
     * @throws IllegalArgumentException 이름이 null, 빈 문자열이거나 5자를 초과하는 경우
     */
    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    /**
     * 조건에 따라 자동차를 전진시키는 메서드
     *
     * @param canMove 전진 가능 여부
     */
    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    /**
     * 우승자 여부를 확인하는 메서드
     *
     * @param maxPosition 최대 위치
     * @return 우승자 여부
     */
    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    /**
     * 자동차의 이름을 반환하는 메서드
     *
     * @return 자동차 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 자동차의 현재 위치를 반환하는 메서드
     *
     * @return 현재 위치
     */
    public int getPosition() {
        return position;
    }
}


