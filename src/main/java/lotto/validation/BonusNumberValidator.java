package lotto.validation;

import lotto.validation.code.BonusNumberValidationCode;

import java.util.List;

public class BonusNumberValidator {
    public BonusNumberValidationCode validateBonusNumber(String token, List<Integer> winningNumbers) {
        if (!isTokenNumber(token) || !isNumberFormatValid(token)) {
            return BonusNumberValidationCode.INVALID_FORMAT;
        }
        int bonusNumber = Integer.parseInt(token);
        if (!isNumberInRange(bonusNumber)) {
            return BonusNumberValidationCode.NUMBER_OUT_OF_RANGE;
        }
        if (!isNumberDistinctFromWinningNumbers(bonusNumber, winningNumbers)) {
            return BonusNumberValidationCode.DUPLICATE_EXIST_IN_WINNING_NUMBERS;
        }
        return BonusNumberValidationCode.VALID;
    }

    public boolean isTokenNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public boolean isNumberFormatValid(String token) {
        return token.charAt(0) >= '1' && token.charAt(0) <= '9';
    }

    public boolean isNumberInRange(int number) {
        return number >= 1 && number <= 45;
    }

    public boolean isNumberDistinctFromWinningNumbers(int number, List<Integer> winningNumbers) {
        return !winningNumbers.contains(number);
    }
}