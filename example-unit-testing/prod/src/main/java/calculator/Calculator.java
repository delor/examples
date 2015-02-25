package calculator;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Calculator {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String SPECIAL_SEPARATOR = "\\n";

    public int add(String arg) {
        if (arg.isEmpty()) return 0;

        String numbersString;
        String separator = DEFAULT_SEPARATOR;

        if (arg.startsWith("//")) {
            separator = extractSeparator(arg);
            numbersString = arg.substring(arg.indexOf("\n") + 1);
        } else {
            numbersString = arg;
        }

        separator += "|" + SPECIAL_SEPARATOR;
        String[] numbers = numbersString.split(separator);

        int result = 0;
        for (String number : numbers)
            result += Integer.valueOf(number);
        return result;
    }

    private String extractSeparator(String arg) {
        String[] separators = arg.substring(3, arg.indexOf("\n") - 1).split("\\]\\[");
        return Arrays.asList(separators)
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
