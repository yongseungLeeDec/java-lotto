package lotto;

import java.util.List;

public class PurchaseResultDemonstrator {
    private static final String PURCHASED_AMOUNT_NOTICE = "개를 구매했습니다.";

    public void printPurchasedAmount(int purchasedAmount) {
        System.out.println(purchasedAmount + PURCHASED_AMOUNT_NOTICE);
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
