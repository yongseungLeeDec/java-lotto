package lotto.lottonumber.winningnumber;

import java.util.List;

public class WinningNumberValidator {

    public boolean hasExactlySixTokens(List<String> tokens) {
        return tokens.size() == 6;
    }
}
