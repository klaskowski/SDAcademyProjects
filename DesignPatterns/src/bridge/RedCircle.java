package bridge;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing red circle with x: " + x + ", y: " + y + " and radius: " + radius);
    }
}
