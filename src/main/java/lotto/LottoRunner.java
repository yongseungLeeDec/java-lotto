package lotto;

import lotto.data.LottoNumber;
import lotto.data.LottoResult;
import lotto.data.PurchaseResult;
import lotto.input.LottoNumberGetter;
import lotto.output.calculation.LottoResultEvaluator;
import lotto.output.demonstration.LottoResultDemonstrator;
import lotto.output.demonstration.PurchaseResultDemonstrator;
import lotto.output.calculation.PurchaseResultProcessor;
import lotto.input.TotalPriceGetter;

public class LottoRunner {
    private static LottoRunner lottoRunner;

    private final TotalPriceGetter totalPriceGetter;
    private final PurchaseResultDemonstrator purchaseResultDemonstrator;
    private final PurchaseResultProcessor purchaseResultProcessor;
    private final LottoNumberGetter lottoNumberGetter;

    private LottoRunner() {
        this.totalPriceGetter = new TotalPriceGetter();
        this.purchaseResultDemonstrator = new PurchaseResultDemonstrator();
        this.purchaseResultProcessor = new PurchaseResultProcessor();
        this.lottoNumberGetter = new LottoNumberGetter();
    }

    public static LottoRunner getLottoRunner() {
        if (lottoRunner == null) {
            lottoRunner = new LottoRunner();
        }
        return lottoRunner;
    }

    public void run() {
        int totalPrice = this.totalPriceGetter.getTotalPriceFromUser();
        System.out.println();

        PurchaseResult purchaseResult = this.purchaseResultProcessor.getPurchaseResult(totalPrice);
        this.purchaseResultDemonstrator.printPurchaseResult(purchaseResult);
        System.out.println();

        LottoNumber lottoNumber = this.lottoNumberGetter.getLottoNumber();
        System.out.println();
    }
}
