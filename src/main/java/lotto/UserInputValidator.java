package lotto;

public abstract class UserInputValidator {

    public static boolean isUserInputValidNumberFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public static boolean isFirstLetterBetweenOneAndNine(String userInput) {
        char firstLetter = userInput.charAt(0);
        return firstLetter >= '1' && firstLetter <= '9';
    }
}
