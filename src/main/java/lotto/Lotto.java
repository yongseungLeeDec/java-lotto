package lotto;

import java.util.List;

public class Lotto {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        int index;
        for (index = 0; index < this.numbers.size() - 1; ++index) {
            stringBuilder.append(this.numbers.get(index)).append(", ");
        }
        stringBuilder.append(this.numbers.get(index)).append("]");

        return stringBuilder.toString();
    }
}
