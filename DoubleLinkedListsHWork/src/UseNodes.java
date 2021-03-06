import java.util.Scanner;

public class UseNodes {
    static Node firstNode;
    static Node lastNode;

    public static void main(String[] args) {
        createList();
        System.out.println();
        displayList();
        System.out.println();
        //removeValue("as");
        //displayList();
        //deleteElementByIndex(2);
        //displayList();
        //insertElementToIndex(0, "InsertedTo0");
        //displayList();
        displayReverseList();
    }

    private static void createList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of nodes: ");
        int nodesCount = sc.nextInt();
        for (int i = 0; i < nodesCount; i++) {
            readItem(sc, i);
        }
    }

    private static void readItem(Scanner scanner, int index) {
        System.out.print("Item " + index + ": ");
        //de ce cu nextLine trece peste elementul 0 ????
        String value = scanner.next();
        add(value);
    }

    private static void add(String value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = firstNode;
            firstNode.setPreviousNode(null);
            firstNode.setNextNode(null);
        } else {
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            newNode.setNextNode(null);
            lastNode = newNode;
        }
    }

    private static void displayList() {
        Node currentNode = firstNode;
        System.out.print("{");
        while (currentNode != null) {
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNextNode();
            if (currentNode != null) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    private static void displayReverseList(){
        Node currentNode = lastNode;
        System.out.print("{");
        while(currentNode != null){
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getPreviousNode();
            if(currentNode != null){
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    private static Node iterateToIndex(int index) {
        Node currentNode = firstNode;
        Node targetNode;
        int counter = 0;
        while (counter != index) {
            currentNode = currentNode.getNextNode();
            counter++;
        }
        targetNode = currentNode;
        return targetNode;
    }

    private static void insertElementToIndex(int index, String value) {
        Node newNode = new Node();
        newNode.setValue(value);
        Node currentIndexNode = iterateToIndex(index);
        insertElementByPositionInList(newNode, currentIndexNode);
    }

    private static void insertElementByPositionInList(Node newNode, Node currentNode) {
        if (currentNode.getPreviousNode() == null) {
            insertToFirstPosition(newNode);
        } else if (currentNode.getNextNode() == null) {
            insertToLastPosition(newNode);
        } else {
            insertToInlinePosition(newNode, currentNode);
        }
    }

    private static void insertToFirstPosition(Node newNode){
        firstNode.setPreviousNode(newNode);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
    }

    private static void insertToInlinePosition(Node newNode, Node currentNode){
        newNode.setPreviousNode(currentNode.getPreviousNode());
        newNode.getPreviousNode().setNextNode(newNode);
        newNode.setNextNode(currentNode);
        newNode.getNextNode().setPreviousNode(newNode);
    }

    private static void insertToLastPosition(Node newNode){
        lastNode.setNextNode(newNode);
        newNode.setPreviousNode(lastNode);
        lastNode = newNode;
    }

    private static int removeValue(String value) {
        Node currentNode = firstNode;
        int countDeleted = 0;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                deleteNode(currentNode);
                countDeleted++;
            } else {
                currentNode.setPreviousNode(currentNode);
            }
            currentNode = currentNode.getNextNode();
        }
        return countDeleted;
    }

    private static void deleteNode(Node currentNode) {
        if (currentNode.getPreviousNode() == null) {
            deleteFirstNode();
        } else if (currentNode.getNextNode() == null) {
            deleteLastNode();
        } else {
            deleteInlineNode(currentNode);
        }
    }

    private static void deleteFirstNode() {
        firstNode = firstNode.getNextNode();
        if (firstNode != null) {
            firstNode.setPreviousNode(null);
        }
    }

    private static void deleteInlineNode(Node currentNode) {
        currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
        currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
    }

    private static void deleteLastNode() {
        lastNode = lastNode.getPreviousNode();
        lastNode.setNextNode(null);
    }

    private static void deleteElementByIndex(int index) {
        Node targetNode = iterateToIndex(index);
        deleteNode(targetNode);
    }
}