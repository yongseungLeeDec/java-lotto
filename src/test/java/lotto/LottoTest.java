package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // UserInput
    @Test
    void isUserInputValidNumberFormatTest() {
        String[] invalidNumberFormatStrings = new String[]{"", "1,000", "1000.00", "30+00", "java", null};
        for (String string : invalidNumberFormatStrings) {
            assertThat(UserInputValidator.isUserInputValidNumberFormat(string)).isEqualTo(false);
        }

        String[] validNumberFormatStrings = new String[]{"1000", "9999", "00012340", "500", "0", "-500", "+500"};
        for (String string : validNumberFormatStrings) {
            assertThat(UserInputValidator.isUserInputValidNumberFormat(string)).isEqualTo(true);
        }
    }

    @Test
    void isFirstLetterBetweenOneAndNineTest() {
        String[] validInputs = new String[]{"1000", "9999", "500", "500", "500"};
        for (String string : validInputs) {
            assertThat(UserInputValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(true);
        }

        String[] invalidInputs = new String[]{"0", "0100", "00000123", "+500", "-500"};
        for (String string : invalidInputs) {
            assertThat(UserInputValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(false);
        }
    }
}
