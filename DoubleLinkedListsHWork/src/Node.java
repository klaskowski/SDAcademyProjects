public class Node {
    private String value;
    private Node previousNode;
    private Node nextNode;

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

    public void setPreviousNode(Node previousNode){
        this.previousNode = previousNode;
    }
    public Node getPreviousNode(){
        return previousNode;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }
    public Node getNextNode(){
        return nextNode;
    }
}
