package lotto;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class PurchaseResultProcessor {
    private static final int LOTTO_START_NUMBER_INCLUSIVE = 1;
    private static final int LOTTO_END_NUMBER_INCLUSIVE = 45;
    private static final int NUMBER_OF_PICKED_NUMBERS = 6;

    public int getPurchasedAmount(int totalPrice) {
        return totalPrice / 1000;
    }

    private Lotto issueNewLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(
                LOTTO_START_NUMBER_INCLUSIVE, LOTTO_END_NUMBER_INCLUSIVE, NUMBER_OF_PICKED_NUMBERS
        );
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}
