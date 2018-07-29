package singleton;

public class Main {
    public static void main(String[] args) {
        SingleObject singleObject1 = SingleObject.getInstance();
        SingleObject singleObject2 = SingleObject.getInstance();
        singleObject1.showMessage();
        singleObject2.showMessage();
    }
}
