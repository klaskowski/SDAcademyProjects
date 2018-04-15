public class LinkedLists {

    static Node firstNode;
    static Node lastNode;

    static void add(int value) {
        if (firstNode == null) {
            firstNode = new Node();
            firstNode.setValue(value);
            //firstNode.setNextNode(null);
            lastNode = firstNode;
        } else{
            Node newNode = new Node();
            newNode.setValue(value);
            //newNode.setNextNode(null);
            lastNode = newNode;
        }
    }

    static void remove(int value) {
        while (true) {

        }
    }

    public static void main(String[] args) {


    }
}
