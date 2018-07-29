package bridge;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing green circle with x: " + x + ", y: " + y + " and radius: " + radius);
    }
}
