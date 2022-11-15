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
}
