package lotto.data;

public class LottoResult {
    private final int lottosWonThree;
    private final int lottosWonFour;
    private final int lottosWonFive;
    private final int lottosWonFiveAndBonus;
    private final int lottosWonSix;

    public LottoResult(int[] countResults) {
        assert (countResults.length == 8);

        this.lottosWonThree = countResults[3];
        this.lottosWonFour = countResults[4];
        this.lottosWonFive = countResults[5];
        this.lottosWonFiveAndBonus = countResults[7];
        this.lottosWonSix = countResults[6];
    }

    public int getTotalPrizeAmount() {
        int prize = 0;
        prize += lottosWonThree * WinningResult.THREE.getPrizeAmount();
        prize += lottosWonFour * WinningResult.FOUR.getPrizeAmount();
        prize += lottosWonFive * WinningResult.FIVE.getPrizeAmount();
        prize += lottosWonFiveAndBonus * WinningResult.FIVE_AND_BONUS.getPrizeAmount();
        prize += lottosWonSix * WinningResult.SIX.getPrizeAmount();
        return prize;
    }

}
