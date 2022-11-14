package lotto;

import java.util.List;

public class Lotto {
    private static final String PROMPT_TOTAL_PRICE = "구입금액을 입력해 주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void promptUserForTotalPrice() {
        System.out.println(PROMPT_TOTAL_PRICE);
    }
}
