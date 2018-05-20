package sda20180428;

import java.util.Scanner;

public class Tree {
    Node root;

    public void readUnbalancedTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please read tree: ");
        String sRoot = scanner.next();
        System.out.println(sRoot);
        if (!"-".equals(sRoot)) {
            root = new Node();
            root.value = Integer.valueOf(sRoot);
            readUnbalancedTree(root);
        }
    }

    public void readUnbalancedTree(Node node) {
        System.out.print("node value : " + node.value);
        Scanner scanner = new Scanner(System.in);
        String sL = scanner.next();
        if (!"-".equals(sL)) {
            node.left = new Node();
            node.left.setValue(Integer.valueOf(sL));
            readUnbalancedTree(node.left);
        }

        String sR = scanner.next();
        if (!"-".equals(sR)) {
            node.right = new Node();
            node.right.setValue(Integer.valueOf(sR));
            readUnbalancedTree(node.right);
        }
    }


    public void generateDefaultTree(int numberOfLevels) {
        root = generateTree(0, numberOfLevels);
    }

    private Node generateTree(int currentLevel, int numberOfLevels) {
        if (currentLevel < numberOfLevels) {
            Node node = new Node();

            node.left = generateTree(currentLevel + 1, numberOfLevels);
            node.right = generateTree(currentLevel + 1, numberOfLevels);

            //temp - poate fi inlocuit cu citire de la tastatura/ din fisier etc
            node.setValue(currentLevel);
            return node;
        }
        return null;
    }

    public void showTreeNLR(Node node) {
        System.out.print(node.value + " ");

        if (node.getLeft() != null) {
            showTreeNLR(node.getLeft());
        }
        if (node.getRight() != null) {
            showTreeNLR(node.getRight());
        }
    }

    public void showTreeLNR(Node node) {

        if (node.getLeft() != null) {
            showTreeNLR(node.getLeft());
        }
        System.out.print(node.value + " ");

        if (node.getRight() != null) {
            showTreeNLR(node.getRight());
        }
    }

    public void showTreeLRN(Node node) {

        if (node.getLeft() != null) {
            showTreeNLR(node.getLeft());
        }
        if (node.getRight() != null) {
            showTreeNLR(node.getRight());
        }
        System.out.print(node.value + " ");
    }

}
