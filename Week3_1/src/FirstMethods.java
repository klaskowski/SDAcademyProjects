public class FirstMethods {
    public static int sum(int x, int y) {
        return x + y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int sumArray(int[] myArray) {
        int sumOfArray = 0;
        for (int i = 0; i < myArray.length; i++) {
            //sumOfArray += myArray[i];
            sumOfArray = sum(sumOfArray, myArray[i]);
        }
        return sumOfArray;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 3;

        int z = sum(x, y);
        System.out.println(z);

        System.out.println(multiply(x, y));

        int[] numbers = {5, 8, 9, 23};
        System.out.println(sumArray(numbers));
    }
}
