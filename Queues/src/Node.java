public class Node {
    private Node nextNode;
    private Node previousNode;
    private String value;

    public Node(String value){
        this.value = value;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }
    public Node getNextNode(){
        return nextNode;
    }

    public void setPreviousNode(Node previousNode){
        this.previousNode = previousNode;
    }
    public Node getPreviousNode(){
        return previousNode;
    }

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
