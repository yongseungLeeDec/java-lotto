package lotto.output.calculation;

import lotto.data.Lotto;
import lotto.data.LottoNumber;
import lotto.data.LottoResult;

import java.util.List;

public class LottoResultEvaluator {
    private static final int NUMBER_TO_EXPRESS_FIVE_AND_BONUS_WIN = 7;

    public int[] countLottosByWinningResult(int[] winningResults) {
        int[] countsByWinningResult = new int[8];

        for (int i = 0; i < winningResults.length; i++) {
            int numberMatched = winningResults[i];
            countsByWinningResult[numberMatched] += 1;
        }

        return countsByWinningResult;
    }

    public int countMatchingNumbers(LottoNumber lottoNumber, Lotto purchasedLotto) {
        List<Integer> winningNumbers = lottoNumber.getLotto().getNumbers();
        int bonusNumber = lottoNumber.getBonusNumber();
        List<Integer> numbers = purchasedLotto.getNumbers();

        int matchCount = (int) numbers.stream().filter(winningNumbers::contains).count();

        if (matchCount == 5 && numbers.contains(bonusNumber)) {
            matchCount = NUMBER_TO_EXPRESS_FIVE_AND_BONUS_WIN;
        }

        return matchCount;
    }
}
