import java.util.Scanner;

public class Tree {
    Node rootNode;
    Scanner scanner = new Scanner(System.in);

    public void generateTree(){
        generateTreeStructure();
    }

    private void generateTreeStructure(){
        System.out.println("Input tree: ");
        String root = scanner.next();
        rootNode = new Node();
        rootNode.setValue(Integer.valueOf(root));
        generateNodes(rootNode);
    }

    private void generateNodes(Node node){
        System.out.println("node value: " + node.getValue());
        while(!scanner.next().equals("x")){
            String right = scanner.next();
            if(!right.equals("-")){
                node.setRightNode(new Node());
                node.getRightNode().setValue(Integer.valueOf(right));
                generateNodes(node.getRightNode());
            }
            String left = scanner.next();
            if(!left.equals("-")){
                node.setLeftNode(new Node());
                node.getLeftNode().setValue(Integer.valueOf(left));
                generateNodes(node.getLeftNode());
            }
        }
        if(scanner.next().equals("x")){
            System.out.println("Finished reading tree");
        }
        displayTree(rootNode);
    }

    private void displayTree(Node node){
        System.out.println(node.getValue());
        if(node.getRightNode() != null){
            displayTree(node.getRightNode());
            System.out.print(node.getRightNode().getValue());
        }
        System.out.println(node.getValue() + " ");
        if (node.getLeftNode() != null){
            displayTree(node.getLeftNode());
            System.out.println(node.getLeftNode().getValue());
        }
    }
}
