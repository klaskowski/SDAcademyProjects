public class Node {
    private int value;
    private Node nextNode;

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }
    public Node getNextNode(){
        return nextNode;
    }
}
