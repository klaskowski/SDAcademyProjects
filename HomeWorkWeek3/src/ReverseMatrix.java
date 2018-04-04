import java.util.Scanner;

public class ReverseMatrix {

    public static void readMatrix(int x, int y, int[][] myMatrix){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input matrix elements: ");
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                myMatrix[i][j] = sc.nextInt();
            }
        }
    }

    public static void displayMatrix(int[][] myMatrix){
        System.out.println("Your matrix is: ");
        for(int i = 0; i < myMatrix.length; i++){
            for(int j = 0; j < myMatrix[i].length; j++){
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void displayReverseMatrix(int[][] myMatrix){
        System.out.println("This is the reversed matrix: ");
        for(int i = myMatrix.length-1; i >= 0; i--){
            for(int j = myMatrix[i].length-1; j >= 0; j--){
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input lines: ");
        int lineNumber = sc.nextInt();
        System.out.print("Input columns: ");
        int colsNumber = sc.nextInt();
        int[][] matrix1 = new int[lineNumber][colsNumber];
        readMatrix(lineNumber, colsNumber, matrix1);
        displayMatrix(matrix1);
        System.out.println();
        displayReverseMatrix(matrix1);

    }

}
