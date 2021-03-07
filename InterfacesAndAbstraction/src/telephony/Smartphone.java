package telephony;
//created by J.M.

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {

    private static final Pattern noDigits = Pattern.compile("^[^0-9]+$");
    private static final Pattern onlyDigits = Pattern.compile("^[0-9]+$");
    private static Matcher findDigit;

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        this.urls.forEach(e -> {
            findDigit = noDigits.matcher(e);
            output.append(findDigit.find() ? String.format("Browsing: %s!", e)
                    : "Invalid URL!").append(System.lineSeparator());
        });
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        this.numbers.forEach(e -> {
            findDigit = onlyDigits.matcher(e);
            output.append(findDigit.find() ? String.format("Calling... %s", e)
                    : "Invalid number!").append(System.lineSeparator());
        });
        return output.toString().trim();
    }
}
