import java.util.Scanner;

public class Main {

    static Node firstNode;
    static Node lastNode;

    public static void main(String[] args) {
        readList();
        displayList();
        removeFirstValue(3);
        displayList();
        int counter = removeAllValues(1);
        displayList();
        System.out.println("You deleted " + counter + " items");
        removeForIndex(0);
        displayList();
    }

    public static void readList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int itemCount = scanner.nextInt();

        for (int i = 0; i < itemCount; i++) {
            readItem(scanner, i);
        }
    }

    public static void readItem(Scanner scanner, int index) {
        System.out.print("Item " + index + ": ");
        int value = scanner.nextInt();
        add(value);
    }

    public static void add(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        //daca sunt la prima adaugare
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = firstNode;
        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
    }

    private static void deleteNode(Node previousNode) {
        if (previousNode == null) {
            deleteFirstNode();
        } else if (previousNode.getNextNode() == lastNode) {
            deleteLastNode(previousNode);
        } else {
            deleteInlineNode(previousNode);
        }
    }

    private static void deleteFirstNode() {
        firstNode = firstNode.getNextNode();
    }

    private static void deleteLastNode(Node previousNode) {
        previousNode.setNextNode(null);
        lastNode = previousNode;
    }

    private static void deleteInlineNode(Node previousNode) {
        previousNode.setNextNode(previousNode.getNextNode().getNextNode());
    }

    public static int removeFirstValue(int value) {
        return removeValues(value, true);
    }
    public static int removeAllValues(int value) {
        return removeValues(value, false);
    }

    /**
     * removes occurring values from a list.
     * @param value the value to be removed
     * @param stopOnFirst specifies if it should stop after the first removal
     * @return the number of removed items
     */
    private static int removeValues(int value, boolean stopOnFirst){
        Node currentNode = firstNode;
        Node previousNode = null;
        int counter = 0;
        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                deleteNode(previousNode);
                counter++;
                if(stopOnFirst){
                    break;
                }
            }else{
                previousNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return counter;
    }

    public static int removeForIndex(int index) {
        Node currentNode = firstNode;
        Node previousNode = null;
        int position = 0;
        while(currentNode != null){
            if(position == index){
                deleteNode(previousNode);
            }else{
                previousNode = currentNode;
            }
            position++;
            currentNode = currentNode.getNextNode();
        }

        return 0;
    }


    public static void displayList() {
        Node currentNode = firstNode;
        System.out.print("{");
        while (currentNode != null) {
            System.out.print(currentNode.getValue());
            if(currentNode != lastNode){
                System.out.print(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println("}");
    }
}
