import java.io.*;
import java.util.*;

/**
 * Fortune implementation in Java
 * Reads in the % delimited fortune file and picks a random one, much like the actual fortune program.
 *
 * @author faintshadows
 * @date 2021/4/9
 */
public class Jortune {

    public static void main(String[] args) {
        final String firstArgument = args.length >= 1 ? args[0] : "";
        final String path = firstArgument.trim();
        if (path.isEmpty()) {
            bailWithMessage("No filename given!");
        }

        try {
            printRandomQuoteForQuotesAtPath(path);
        } catch (IOException ioException) {
            bailWithIOException(ioException);
        }
    }

    private static void bailWithMessage(final String message) {
        System.err.println("Error: " + message);
        System.exit(1);
    }

    private static void printRandomQuoteForQuotesAtPath(final String path) throws IOException {
        final List<String> quotes = readFortuneFormattedFileAtPath(path);

        final String randomQuote = pickRandomQuoteFromQuotes(quotes);
        System.out.println(randomQuote);
        System.exit(0);
    }

    private static List<String> readFortuneFormattedFileAtPath(final String path) throws IOException {
        final BufferedReader quotesReader = new BufferedReader(new FileReader(path));

        final List<String> quotes = new ArrayList<>();
        try (final Scanner scanner = new Scanner(quotesReader)) {
            // fortune files use % on a newline as the delimiter
            scanner.useDelimiter("%\n");

            while (scanner.hasNext()) {
                quotes.add(scanner.next());
            }
        }

        return quotes;
    }

    private static String pickRandomQuoteFromQuotes(final List<String> quotes) {
        final int randomIndex = (int) (Math.random() * quotes.size());
        return quotes.get(randomIndex);
    }

    private static void bailWithIOException(final IOException ioException) {
        final String errorMessage = "Reading from the provided file was impossible, error was: ["
                + ioException.getClass().getName()
                + "] '"
                + ioException.getLocalizedMessage()
                + "'";
        bailWithMessage(errorMessage);
    }
}
