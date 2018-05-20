package ro.sda20180429.shapes;

public abstract class Shape {
    public abstract Double calculateArea();

    public abstract Double calculatePerimeter();

    @Override
    public String toString() {
        return "This is a shape";
    }
}
