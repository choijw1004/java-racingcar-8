package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Controller controller = new Controller(new InputView(), new OutputView());
            controller.run();
        } finally {
            Console.close();
        }
    }
}
