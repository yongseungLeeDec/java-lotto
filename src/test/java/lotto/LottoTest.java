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

    // UserInputValidator 테스트
    @DisplayName("사용자가 입력한 구입금액 형식에 따라 올바른 검증결과 코드를 반환한다.")
    @Test
    void userInputValidator_IntegratedTest() {
        UserInputValidator userInputValidator = new UserInputValidator();
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("1000"))
                .isEqualTo(UserInputValidationCode.VALID_NUMBER);
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("3000"))
                .isEqualTo(UserInputValidationCode.VALID_NUMBER);
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("500000"))
                .isEqualTo(UserInputValidationCode.VALID_NUMBER);
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("01000"))
                .isEqualTo(UserInputValidationCode.INVALID_NUMBER_FORMAT);
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("+000"))
                .isEqualTo(UserInputValidationCode.INVALID_NUMBER_FORMAT);
        assertThat(userInputValidator.getUserTotalPriceInputValidationCode("100"))
                .isEqualTo(UserInputValidationCode.INVALID_NUMBER);
    }

    @DisplayName("입력된 구입 금액 문자열이 올바르지 않을 경우 예외가 발생한다.")
    @Test
    void userInputValidator_ExceptionTest() {
        LottoRunner lottoRunner = LottoRunner.getLottoRunner();
        assertThatThrownBy(() -> lottoRunner.throwExceptionIfUserInputTotalPriceNotValid("total price"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoRunner.throwExceptionIfUserInputTotalPriceNotValid("+000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lottoRunner.throwExceptionIfUserInputTotalPriceNotValid("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isUserInputValidNumberFormatTest() {
        UserInputValidator userInputValidator = new UserInputValidator();

        String[] invalidNumberFormatStrings = new String[]{"", "1,000", "1000.00", "30+00", "java", null};
        for (String string : invalidNumberFormatStrings) {
            assertThat(userInputValidator.isUserInputValidNumberFormat(string)).isEqualTo(false);
        }

        String[] validNumberFormatStrings = new String[]{"1000", "9999", "00012340", "500", "0", "-500", "+500"};
        for (String string : validNumberFormatStrings) {
            assertThat(userInputValidator.isUserInputValidNumberFormat(string)).isEqualTo(true);
        }
    }

    @Test
    void isFirstLetterBetweenOneAndNineTest() {
        UserInputValidator userInputValidator = new UserInputValidator();

        String[] validInputs = new String[]{"1000", "9999", "500", "500", "500"};
        for (String string : validInputs) {
            assertThat(userInputValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(true);
        }

        String[] invalidInputs = new String[]{"0", "0100", "00000123", "+500", "-500"};
        for (String string : invalidInputs) {
            assertThat(userInputValidator.isFirstLetterBetweenOneAndNine(string)).isEqualTo(false);
        }
    }

    @Test
    void isValueMoreThanOrEqualToOneThousandTest() {
        UserInputValidator userInputValidator = new UserInputValidator();

        int[] validValues = new int[]{1000, 2000, 3000, 4000, 5000};
        for (int value : validValues) {
            assertThat(userInputValidator.isValueMoreThanOrEqualToOneThousand(value)).isEqualTo(true);
        }

        int[] invalidValues = new int[]{-1000, 0, 500, 30};
        for (int value : invalidValues) {
            assertThat(userInputValidator.isValueMoreThanOrEqualToOneThousand(value)).isEqualTo(false);
        }
    }


    @Test
    void isValueMultipleOfOneThousandTest() {
        UserInputValidator userInputValidator = new UserInputValidator();

        int[] validValues = new int[]{1000, 2000, 3000, 4000, 5000};
        for (int value : validValues) {
            assertThat(userInputValidator.isValueMultipleOfOneThousand(value)).isEqualTo(true);
        }

        int[] invalidValues = new int[]{-1000, 0, 1001, 2002};
        for (int value : invalidValues) {
            assertThat(userInputValidator.isValueMultipleOfOneThousand(value)).isEqualTo(false);
        }
    }
}
