public class TreeUtils extends Tree {


    private int numberOfLevelsRight(Node node) {
        int levelCounterRight = 1;
        if (node.equals(null)) {
            return 0;
        } else {
            while (!node.getRightNode().equals(null)) {
                levelCounterRight++;
                numberOfLevelsRight(node.getRightNode());

            }
            return levelCounterRight;
        }
    }

    private int numbersOfLevelsLeft(Node node) {
        int levelCounterLeft = 1;
        if(node.equals(null)){
            return 0;
        } else {
            while (!node.getLeftNode().equals(null)){
                levelCounterLeft++;
                numbersOfLevelsLeft(node.getLeftNode());
            }
            return levelCounterLeft;
        }
    }

    public int numberOfLevels(Node node){
        if (numbersOfLevelsLeft(node) >= numberOfLevelsRight(node)){
            return numbersOfLevelsLeft(node);
        }
        return numberOfLevelsRight(node);
    }
}


