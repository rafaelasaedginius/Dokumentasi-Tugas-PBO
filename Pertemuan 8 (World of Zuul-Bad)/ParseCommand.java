import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParseCommand {
    private Words cmdWords;
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public ParseCommand() {
        cmdWords = new Words();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Command getCommand() {
        String input = "", first, second;
        System.out.print("> ");
        try {
            input = reader.readLine();
        } catch (java.io.IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
        tokenizer = new StringTokenizer(input);
        if (tokenizer.hasMoreTokens()) {
            first = tokenizer.nextToken();
        } else {
            first = null;
        }
        if (tokenizer.hasMoreTokens())
            second = tokenizer.nextToken();
        else
            second = null;
        if (cmdWords.isAllowedCommand(first))
            return new Command(first, second);
        else
            return new Command(null, second);
    }
}
