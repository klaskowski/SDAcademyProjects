public class MainMenu {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Menu menu = new Menu(queue);
        menu.displayMenu();
    }
}
