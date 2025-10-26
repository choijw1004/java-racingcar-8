package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    private final InputView inputView;
    private final OutputView outputView;

    public Application() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static void main(String[] args) {
        try {
            new Application().run();
        } finally {
            Console.close();
        }
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();

        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, attemptCount);

        play(racingGame);
    }

    private void play(RacingGame game) {
        outputView.printResultMessage();

        for (int attempt = 0; attempt < game.getAttemptCount(); attempt++) {
            game.startRacing();
            outputView.printAttemptResult(game.getStatusDtos());
        }

        outputView.printWinners(game.getWinners());
    }
}
