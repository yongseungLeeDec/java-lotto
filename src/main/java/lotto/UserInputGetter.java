package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputGetter {
    private static final String PROMPT_TOTAL_PRICE = "구입금액을 입력해 주세요.";

    private void promptUserForTotalPrice() {
        System.out.println(PROMPT_TOTAL_PRICE);
    }

    private String getTotalPriceFromUser() {
        return readLine();
    }
}
