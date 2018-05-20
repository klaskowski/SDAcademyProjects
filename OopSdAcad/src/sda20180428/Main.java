package sda20180428;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please read number of levels for tree: ");
//        int n = scanner.nextInt();
//
//        System.out.println("The tree will have " + n + " levels");
//
          Tree tree = new Tree();
//        tree.generateDefaultTree(n);
        tree.readUnbalancedTree();
        System.out.println("Display NLR:");
        tree.showTreeNLR(tree.root);
        System.out.println();
        System.out.println("Display LNR");
        tree.showTreeLNR(tree.root);
        System.out.println();
        System.out.println("Display LRN");
        tree.showTreeLRN(tree.root);
    }
}
