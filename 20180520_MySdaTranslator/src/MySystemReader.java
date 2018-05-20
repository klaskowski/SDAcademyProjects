import java.util.Scanner;

public class MySystemReader implements IReader{

    @Override
    public String read() {
        System.out.println("Please input your message:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Original message: ");
        System.out.println(input);
        return input;
    }
}
