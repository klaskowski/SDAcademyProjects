package factoryMethod;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("Circle").draw();
        System.out.println();
        shapeFactory.getShape("Square").draw();
        System.out.println();
        shapeFactory.getShape("Rectangle").draw();
        System.out.println();
        //shapeFactory.getShape("Triangle").draw();
    }
}
