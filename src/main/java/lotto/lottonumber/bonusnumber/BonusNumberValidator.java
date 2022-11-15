package lotto.lottonumber.bonusnumber;

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
}
