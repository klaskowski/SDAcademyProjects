import java.util.Scanner;

public class TheMatrix {

    public static void printMatrix(int[][] myMatrix) {
        System.out.println("Your matrix is: ");
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix[i].length; j++) {
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printReverseMatrix(int[][] myMatrix) {
        System.out.println("Your reverse matrix is: ");
        for (int i = myMatrix.length - 1; i >= 0; i--) {
            for (int j = myMatrix.length - 1; j >= 0; j--) {
                System.out.print(myMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void sumLinePlusCols(int[][] myMatrix) {
        for (int i = 0; i < myMatrix.length; i++) {
            double sumLine = 0;
            double sumCols = 0;
            for (int j = 0; j < myMatrix[i].length; j++) {
                sumLine += myMatrix[i][j];
                sumCols += myMatrix[j][i];
            }
            System.out.println("sum line " + i + ": " + sumLine);
            double avgLine = sumLine / myMatrix.length;
            System.out.println("avg for line " + i + " is: " + avgLine);
            System.out.println();
            System.out.println("sum col: " + i + ": " + sumCols);
            double avgCols = sumCols / myMatrix[i].length;
            System.out.println("avg for col " + i + " is: " + avgCols);
        }
    }

    public static void sumCols(int[][] myMatrix) {
        for (int i = 0; i < myMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < myMatrix[i].length; j++) {
                sum += myMatrix[j][i];
            }
            System.out.println("sum col " + i + ": " + sum);
            double avg = sum / myMatrix.length;
            System.out.println("avg for col " + i + " is: " + avg);
        }
    }

    public static void sumLine(int[][] myMatrix) {

        for (int i = 0; i < myMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < myMatrix[i].length; j++) {
                sum += myMatrix[i][j];
            }
            System.out.println("sum line " + i + ": " + sum);
            double avg = sum / myMatrix.length;
            System.out.println("avg for line " + i + " is: " + avg);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input size: ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        System.out.println("Input matrix elements (" + n + "x" + n + "): ");
        //Reading the Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        printMatrix(a);
        System.out.println();
        printReverseMatrix(a);
        System.out.println();
        sumLine(a);
        System.out.println();
        sumCols(a);
        System.out.println();
        sumLinePlusCols(a);
    }
}
