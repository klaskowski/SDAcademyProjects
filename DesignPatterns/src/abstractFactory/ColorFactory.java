package abstractFactory;

public class ColorFactory extends AbstractFactory{

    @Override
    public Color getColor(String colorName){
        if(colorName == null){
            throw new IllegalArgumentException("Input can't be null");
        }
        switch (colorName) {
            case "Red":
                return new Red();
            case "Green":
                return new Green();
            case "Blue":
                return new Blue();
            default:
                throw new IllegalArgumentException("I don't know that color yet");
        }
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }

}
