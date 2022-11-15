package lotto;

public class LottoRunner {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static LottoRunner lottoRunner;

    private final UserInputGetter userInputGetter;
    private final UserInputValidator userInputValidator;
    private final PurchaseResultDemonstrator purchaseResultDemonstrator;
    private final PurchaseResultProcessor purchaseResultProcessor;

    private LottoRunner() {
        this.userInputGetter = new UserInputGetter();
        this.userInputValidator = new UserInputValidator();
        this.purchaseResultDemonstrator = new PurchaseResultDemonstrator();
        this.purchaseResultProcessor = new PurchaseResultProcessor();
    }

    public static LottoRunner getLottoRunner() {
        if (lottoRunner == null) {
            lottoRunner = new LottoRunner();
        }
        return lottoRunner;
    }

    public void run() {
        int totalPrice = getTotalPriceFromUser();
    }

    public int getTotalPriceFromUser() {
        this.userInputGetter.promptUserForTotalPrice();
        String userInput = this.userInputGetter.getTotalPriceFromUser();
        throwExceptionIfUserInputTotalPriceNotValid(userInput);

        return Integer.parseInt(userInput);
    }

    public void throwExceptionIfUserInputTotalPriceNotValid(String userInput) {
        UserInputValidationCode result = this.userInputValidator.getUserTotalPriceInputValidationCode(userInput);
        if (result != UserInputValidationCode.VALID_NUMBER) {
            throw new IllegalArgumentException(ERROR_PREFIX + result.getErrorMessage());
        }
    }
}
