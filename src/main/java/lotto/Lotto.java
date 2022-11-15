package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
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

    public static void validate(List<Integer> numbers) {

    }

    public static boolean isNumbersSizeExactlySix(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public static boolean isEveryNumberDistinct(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    public static boolean isEveryNumberInRange(List<Integer> numbers) {
        List<Integer> filtered = numbers.stream().filter(num -> num >= 1 && num <= 45).collect(Collectors.toList());
        return filtered.size() == numbers.size();
    }
}
