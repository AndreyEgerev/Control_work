import View.InputUserData;
import View.Menu;

public class Presenter {
    private Menu menu;


    public Presenter() {
        this.menu = new Menu();
    }

    public void onRun(){
        boolean runFlag = true;
        String choiseUseer;
        while (runFlag){
            choiseUseer = menu.mainMenu();
            switch (choiseUseer){
                case "5" :
                    runFlag = false;
                    menu.menuMessage("Выход");
                    break;
                default:
                    menu.menuMessage("Неверный ввод");
            }
        }


    }
}
