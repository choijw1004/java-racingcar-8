package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
            outputView.printAttemptResult(game.getCurrentStatusStringList());
        }

        outputView.printWinners(game.getWinners());
    }
}
