package abstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String input) {
        if (input.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        }
        if (input.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        throw new IllegalArgumentException("Don't know that!");
    }
}
