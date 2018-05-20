package ro.sda20180429.shapes;

public class Square extends Rectangle {

    public Square(Double side){
        super(side, side);
//        System.out.println("Created Square {side: " + side + "}");
    }

    public Square(Double width, Double height){
        super(width, height);
        System.out.println("Created Square { width: " + width + " height: " + height + "}");
    }

    @Override
    public Double calculateArea() {
        return getWidth() * getWidth();
    }

    @Override
    public Double calculatePerimeter() {
        return getWidth() * 4;
    }

    @Override
    public String toString() {
        return "Square { side: " + getWidth() + "}";
    }
}
