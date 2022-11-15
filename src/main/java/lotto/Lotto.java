package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

    }

    public boolean isNumbersSizeExactlySix(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public boolean isEveryNumberDistinct(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
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
