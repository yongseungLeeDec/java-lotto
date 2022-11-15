package lotto;

import lotto.data.Lotto;
import lotto.data.LottoNumber;
import lotto.output.calculation.LottoResultEvaluator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultEvaluatorTest {
    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_1() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(6);
    }

    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_2() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(7);
    }

    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_3() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(0);
    }


    @DisplayName("당첨 번호와 구매한 로또 번호 간 일치하는 숫자의 개수를 반환한다")
    @Test
    void countMatchingNumbersTest_4() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        LottoNumber lottoNumber = new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto purchasedLotto = new Lotto(List.of(40, 3, 42, 4, 44, 5));
        assertThat(
                lottoResultEvaluator.countMatchingNumbers(lottoNumber, purchasedLotto))
                .isEqualTo(3);
    }
}
