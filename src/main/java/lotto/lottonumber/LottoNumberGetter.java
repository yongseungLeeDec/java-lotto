package lotto.lottonumber;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoNumberGetter {
    private static final String PROMPT_FOR_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public LottoNumberGetter() {

    }

    public void printPromptForWinningNumbers() {
        System.out.println(PROMPT_FOR_WINNING_NUMBERS);
    }

    public String getWinningNumbersFromConsole() {
        return readLine();
    }
}
