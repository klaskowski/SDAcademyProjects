package bridge;

public class Main {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle (200, 250, 125, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
