package ro.sda20180429.shapes;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
//        System.out.println("Created rectangle { width: " + width + " height: " + height + "}");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{ width: " + getWidth() + " height: " + getHeight() + "}";
    }

    public Double calculateArea() {
        return getWidth() * getHeight();
    }

    public Double calculatePerimeter() {
        return 2 * getWidth() + 2 * getHeight();
    }
}
