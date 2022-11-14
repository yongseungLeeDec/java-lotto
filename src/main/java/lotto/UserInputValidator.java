package lotto;

public abstract class UserInputValidator {

    public static UserInputValidationCode getUserTotalPriceInputValidationCode(String userInput) {
        if (!isUserInputValidNumberFormat(userInput) || !isFirstLetterBetweenOneAndNine(userInput)) {
            return UserInputValidationCode.INVALID_NUMBER_FORMAT;
        }

        int value = Integer.parseInt(userInput);
        if (!isValueMoreThanOrEqualToOneThousand(value) || !isValueMultipleOfOneThousand(value)) {
            return UserInputValidationCode.INVALID_NUMBER;
        }

        return UserInputValidationCode.VALID_NUMBER;
    }

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

    public static boolean isValueMoreThanOrEqualToOneThousand(int value) {
        return value >= 1000;
    }

    public static boolean isValueMultipleOfOneThousand(int value) {
        return (value / 1000 >= 1) && (value % 1000 == 0);
    }
}
