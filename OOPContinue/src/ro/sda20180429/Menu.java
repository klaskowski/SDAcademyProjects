package ro.sda20180429;

import ro.sda20180429.shapes.*;

import java.util.Scanner;

public class Menu {
    private final int EXIT_OPTION = 0;
    private Scanner scanner = new Scanner(System.in);
    private Bucket bucket;


    public void displayMenu() {
        int option = -1;
        displayOptions();
        option = readOption();
        if (option != EXIT_OPTION) {
            displayMenu();
        } else {
            processOption(option);
        }
    }

    private void displayOptions() {
        System.out.println("1. Create Rectangle");
        System.out.println("2. Create Square");
        System.out.println("3. Create Circle");
        System.out.println("4. Create Triangle");
        System.out.println("5. Test Casts");
        System.out.println("6. Create Bucket");
        System.out.println("7. Display Bucket");
        System.out.println("8. Add shape");
        System.out.println("9. Reset Bucket");
        System.out.println("0. Exit");
        System.out.println();
    }

    private int readOption() {
        System.out.print("Option: ");
        return new Scanner(System.in).nextInt();
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                createRectangle();
                break;
            case 2:
                createSquare();
                break;
            case 3:
                createCircle();
                break;
            case 4:
                createTriangle();
                break;
            case 6:
                createBucket();
                break;
            case 7:
                displayBucket();
                break;
            case 8:
                addShape();
                break;
            case 9:
                resetBucket();
                break;
            case 0:
            default:
        }
    }

    private void createRectangle() {
        System.out.println("read rectangle width: ");
        Double width = scanner.nextDouble();
        System.out.println("read rectangle height: ");
        Double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle);
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Rectangle perimeter: " + rectangle.calculatePerimeter());
    }

    private void createSquare() {
        System.out.print("Read square side: ");
        Double side = scanner.nextDouble();
        Square square = new Square(side);
        System.out.println(square);
        System.out.println("Square area: " + square.calculateArea());
        System.out.println("Square perimeter: " + square.calculatePerimeter());
    }

    private void createCircle() {
        System.out.print("read circle radius: ");
        Double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Circle perimeter: " + circle.calculatePerimeter());
    }

    private void createTriangle() {
        System.out.print("read triangle L1: ");
        Double L1 = scanner.nextDouble();
        System.out.print("read triangle L2: ");
        Double L2 = scanner.nextDouble();
        System.out.print("read triangle L3: ");
        Double L3 = scanner.nextDouble();
        Triangle triangle = new Triangle(L1, L2, L3);
        System.out.println(triangle);
        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
    }


    private void createBucket() {
        System.out.println("Please input bucket size:");
        int bucketSize = scanner.nextInt();
        this.bucket = new Bucket(bucketSize);
    }

    private void displayBucket() {
        if (this.bucket != null) {
            this.bucket.displayShapes();
        } else {
            System.out.println("Bucket not created");
        }
    }

    private void addShape() {
        String shapeName = scanner.nextLine();
        Shape newShape = null;
        switch (shapeName) {
            case "rectangle":
                newShape = new Rectangle(5.00, 8.00);
                break;
            case "square":
                newShape = new Square(8.00);
                break;
            case "triangle":
                newShape = new Triangle(5.00, 8.00, 12.00);
                break;
            case "circle":
                newShape = new Circle(12.00);
                break;
            default:
                break;
        }
        if (newShape != null) {
            bucket.addShape(newShape);
        }
    }

    private void resetBucket() {
        this.createBucket();
    }
}
