package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

/**
 * 자동차 경주 게임 애플리케이션 진입점 클래스
 */
public class Application {
    private final InputView inputView;
    private final OutputView outputView;

    public Application() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 애플리케이션의 메인 메서드
     *
     * @param args 커맨드 라인 매개변수
     */
    public static void main(String[] args) {
        try {
            new Application().run();
        } finally {
            Console.close();
        }
    }

    /**
     * 게임을 실행하는 메서드
     */
    public void run() {
        List<String> carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();

        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, attemptCount);

        play(racingGame);
    }

    /**
     * 게임을 진행하고 결과를 출력하는 메서드
     *
     * @param game 진행할 레이싱 게임
     */
    private void play(RacingGame game) {
        outputView.printResultMessage();

        for (int attempt = 0; attempt < game.getAttemptCount(); attempt++) {
            game.startRacing();
            outputView.printAttemptResult(game.getStatusDtos());
        }

        outputView.printWinners(game.getWinners());
    }
}
