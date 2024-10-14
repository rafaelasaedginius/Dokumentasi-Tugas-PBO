import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String captureInput() {
        System.out.print("> ");
        return scanner.nextLine();
    }
}
