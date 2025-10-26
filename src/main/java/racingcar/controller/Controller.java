package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
