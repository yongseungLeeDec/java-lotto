package lotto;

public class LottoRunner {
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

    public void run() {

    }
}
