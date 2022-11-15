package lotto.lottonumber.bonusnumber;

import java.util.List;

public class BonusNumberValidator {

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
