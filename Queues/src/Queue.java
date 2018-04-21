public class Queue {
    private Node firstNode;
    private Node lastNode;
    private int count;


    public void enqueue(String value){
        Node newNode = new Node(value);
        if(lastNode == null){
            addFirstNode(newNode);
        }else{
            addLastNode(newNode);
        }
        count++;
    }

    private void addFirstNode(Node newNode){
        firstNode = newNode;
        lastNode = newNode;
    }

    private void addLastNode(Node newNode){
        lastNode.setNextNode(newNode);
        newNode.setPreviousNode(lastNode);
        lastNode = newNode;
    }

    private String removeFirstNode(){
        String deletedValue = firstNode.getValue();
        firstNode = null;
        lastNode = null;
        return deletedValue;
    }

    private String removeNode(){
        String deletedValue = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        firstNode.setPreviousNode(null);
        return deletedValue;
    }

    public String dequeue(){
        String deletedValue = null;
        if(firstNode == null){
            System.err.println("Queue is empty. Can not delete.");
            return null;
        }else if(firstNode.getNextNode() == null){
            deletedValue = removeFirstNode();
        } else {
            deletedValue = removeNode();
        }
        count--;
        return deletedValue;
    }

    public int getCount(){
        return count;
    }
}
