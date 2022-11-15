package lotto.lottonumber.winningnumber;

import java.util.List;

public class WinningNumberValidator {

    public boolean hasExactlySixTokens(List<String> tokens) {
        return tokens.size() == 6;
    }

    public boolean hasNumberElementsOnly(List<String> tokens) {
        return tokens.stream().filter(this::isNumericExpression).count() == tokens.size();
    }

    private boolean isNumericExpression(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public boolean hasValidNumberFormatElementsOnly(List<String> tokens) {
        return tokens.stream().filter(this::isValidNumberFormat).count() == tokens.size();
    }

    private boolean isValidNumberFormat(String string) {
        return string.charAt(0) >= '1' && string.charAt(0) <= '9';
    }
}
