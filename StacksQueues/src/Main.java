import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Capacity: ");
        int capacity = scanner.nextInt();
        Stack stack = new Stack(capacity);
        System.out.println("You created a stack with a capacity of " + stack.getCapacity());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }
    }
}
