public class MySystemDisplay implements IDisplay{

    @Override
    public void display(String output) {
        if(output == null){
            return;
        }
        System.out.println("Translated message: ");
        System.out.println(output);
    }
}
