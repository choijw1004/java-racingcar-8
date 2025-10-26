package racingcar.dto;

/**
 * 자동차의 현재 상태를 전달하는 DTO
 *
 * @param name     자동차 이름
 * @param position 현재 위치
 */
public record CarStatusDto(String name, int position) {
}
