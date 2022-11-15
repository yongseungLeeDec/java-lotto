package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputGetter {
    private static final String PROMPT_TOTAL_PRICE = "구입금액을 입력해 주세요.";

    private final UserInputValidator userInputValidator;

    public UserInputGetter() {
        this.userInputValidator = new UserInputValidator();
    }

    public int getTotalPriceFromUser() {
        promptUserForTotalPrice();
        String userInput = getTotalPriceFromConsole();
        throwExceptionIfUserInputTotalPriceNotValid(userInput);

        return Integer.parseInt(userInput);
    }

    public void promptUserForTotalPrice() {
        System.out.println(PROMPT_TOTAL_PRICE);
    }

    public String getTotalPriceFromConsole() {
        return readLine();
    }

    public void throwExceptionIfUserInputTotalPriceNotValid(String userInput) {
        UserInputValidationCode result = this.userInputValidator.getUserTotalPriceInputValidationCode(userInput);
        if (result != UserInputValidationCode.VALID_NUMBER) {
            throw new IllegalArgumentException(result.getErrorMessage());
        }
    }
}
