package lotto;

public class LottoRunner {
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

    }
}
