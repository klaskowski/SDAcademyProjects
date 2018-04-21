import java.util.Scanner;

public class Menu {
    private final int EXIT_OPTION = 0;
    private Queue queue;

    public Menu(Queue queue) {
        this.queue = queue;
    }

    private void addToQueue() {
        System.out.print("Input value: ");
        Scanner scanner = new Scanner(System.in);
        queue.enqueue(scanner.nextLine());
    }

    private void displayCount() {
        System.out.println("Queue size: " + queue.getCount());
    }

    public void displayMenu() {
        int option = -1;
        while (option != EXIT_OPTION) {
            displayOptions();
            option = readOption();
            processOption(option);
        }
    }

    public void displayOptions() {
        System.out.println();
        System.out.println("1. Add to queue");
        System.out.println("2. Extract from queue");
        System.out.println("3. Get queue size");
        System.out.println("0. Exit");
        System.out.println();
    }

    public int readOption() {
        System.out.print("Option: ");
        return new Scanner(System.in).nextInt();
    }

    private void displayDequeue(){
        System.out.println(queue.dequeue() + " was removed from the queue");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                addToQueue();
                break;
            case 2:
                displayDequeue();
                break;
            case 3:
                displayCount();
                break;
            case 0:
            default:
                //do nothing
        }

    }
}
