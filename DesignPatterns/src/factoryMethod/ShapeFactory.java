package factoryMethod;

public class ShapeFactory {
    public Shape getShape(String shapeName) {
        if(shapeName == null){
            throw new IllegalArgumentException("Input can't be null");
        }
        switch (shapeName) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("I don't know that shape yet");
        }
    }
}
