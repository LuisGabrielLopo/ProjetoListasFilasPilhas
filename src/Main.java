import controller.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.inicio();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Main.main(args);
        }
    }
}
