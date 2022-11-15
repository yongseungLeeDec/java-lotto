package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가거나 적으면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(2, 3, 4, 5, 7, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 3, 4, 5, 7, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성에 사용되는 번호가 정확히 6개인지 확인한다")
    @Test
    void isNumbersSizeExactlySix() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(1000, 1, 2, 3, 4, 100));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 45, 7));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(false);
    }

    @DisplayName("로또 생성에 사용되는 번호에 중복되는 번호가 없는지 확인한다")
    @Test
    void isEveryNumberDistinct() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(3, 45, 26, 28, 17, 9));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 45, 7));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(false);
    }

    @DisplayName("로또 생성에 사용되는 번호가 올바른 범위의 숫자인지 확인한다")
    @Test
    void isEveryNumberInRange() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(3, 45, 26, 28, 17, 9));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 46, 7));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 46, 0));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(false);
    }

    @DisplayName("사용자가 올바른 형식의 구입 금액을 입력할 경우, 이를 정수로 변환한 값을 반환한다.")
    @Test
    void convertValidUserInputForTotalPriceToIntegerTest() {
        UserInputGetter userInputGetter = new UserInputGetter();

        String[] validTotalPrices = new String[]{"1000", "2000", "3000", "1000000", "500000", "35000"};
        List<Integer> result = new ArrayList<>();
        List<Integer> validResult = new ArrayList<>(List.of(1000, 2000, 3000, 1000000, 500000, 35000));

        for (String price : validTotalPrices) {
            System.setIn(new ByteArrayInputStream((price).getBytes()));
            result.add(userInputGetter.getTotalPriceFromUser());
        }

        assertThat(result.size()).isEqualTo(6);
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).isEqualTo(validResult.get(i));
        }
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
        UserInputGetter userInputGetter = new UserInputGetter();
        assertThatThrownBy(() -> userInputGetter.throwExceptionIfUserInputTotalPriceNotValid("total price"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userInputGetter.throwExceptionIfUserInputTotalPriceNotValid("+000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> userInputGetter.throwExceptionIfUserInputTotalPriceNotValid("01000"))
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
