import java.util.Scanner;

public class MirroredMatrix {

    public static void readMatrix(int x, int y, int[][] myMatrix) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input matrix elements: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                myMatrix[i][j] = sc.nextInt();
            }
        }
    }

    public static void displayMatrix(int[][] myMatrix) {
        System.out.println("Your matrix is:");
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix[i].length; j++) {
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input lines: ");
        int linesNumber = sc.nextInt();
        System.out.print("Input columns: ");
        int colsNumber = sc.nextInt();
        int[][] matrix1 = new int[linesNumber][colsNumber];
        readMatrix(linesNumber, colsNumber, matrix1);
        System.out.println();
        displayMatrix(matrix1);
        System.out.println();

        //display side-mirrored matrix

        System.out.println("Your side-mirrored matrix is: ");
        for (int i = 0; i < linesNumber; i++) {
            for (int j = colsNumber - 1; j >= 0; j--) {
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }

        //display base-mirrored matrix
        System.out.println("Your base-mirrored matrix is: ");
        for(int i = linesNumber - 1; i >= 0; i--){
            for(int j = 0; j < colsNumber; j++){
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }
    }

}


