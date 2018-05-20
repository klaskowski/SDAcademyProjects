public class SDADisplayer implements IDisplay{

    @Override
    public void display(String output) {

        System.out.println("Translated message: ");
        System.out.println(output);
    }
}
