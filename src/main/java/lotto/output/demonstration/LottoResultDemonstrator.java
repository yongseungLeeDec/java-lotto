package lotto.output.demonstration;

import lotto.data.LottoResult;

public class LottoResultDemonstrator {
    private static final String HEADING = "당첨 통계";
    private static final String BREAK_LINE = "---";

    public void printLottoResult(LottoResult lottoResult) {
        printHeading();
        printBreakLine();
        System.out.println(lottoResult);
    }

    private void printHeading() {
        System.out.println(HEADING);
    }

    private void printBreakLine() {
        System.out.println(BREAK_LINE);
    }
}
