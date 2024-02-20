import Logic.ListAnimals;
import Logic.ListRegistry;
import View.Menu;

public class Presenter {
    private Menu menu;
    private ListAnimals registry;
    private ListRegistry catalog;
    private int menuLevel;


    public Presenter() {
        this.menu = new Menu();
        this.registry = new ListAnimals("animal");
        this.catalog = new ListRegistry("animal");
        this.menuLevel = 0;
    }

    public void onRun(){
        boolean runFlag = true;
        String choiceUser;
        int choise;
        while (runFlag){
            choiceUser = menu.mainMenu();
            switch (choiceUser){
                case "1" :
                    selectOne();
                    break;
                case "2" :
                    selectTwo();
                    break;
                case "3" :
                    selectTree();
                    break;
                case "4" :
                    selectFour();
                    break;
                case "5" :
                    runFlag = false;
                    menu.menuMessage("Выход");
                    break;
                default:
                    menu.menuMessage("Неверный ввод");
            }
        }
    }

    public void onStart(){

    }
    private void selectOne(){
        boolean choice = true;
        int numberChoice = 0;
        while (choice){
            String selestUser = menu.menuAnimals(registry);
            try {
                numberChoice = Integer.parseInt(selestUser);
                choice = false;
            } catch (NumberFormatException e){
                menu.menuMessage("Неправильный выбор");
            }
            if (numberChoice > registry.size()+1 || numberChoice < 1){
                choice = true;
                menu.menuMessage("Выбран неверный номер");
            } else choice = false;
        }
        if (numberChoice == registry.size()+1) return;
        numberChoice--;



    }

    private void selectTwo(){
        menu.menuMessage("Option is not available");
    }
    private void selectTree(){
        menu.menuMessage("Option is not available");
    }
    private void selectFour(){
        menu.menuMessage("Option is not available");
    }
}
