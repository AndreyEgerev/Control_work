import Logic.Animal;
import Logic.ListAnimals;
import Logic.ListRegistry;
import View.Menu;

import java.time.LocalDate;
import java.util.HashSet;

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
        onStart();
        boolean runFlag = true;
        String choiceUser;
        int choise;
        while (runFlag){
            menuLevel = 0;
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
        catalog.addRegistry("dog");
        catalog.addRegistry("cat");
        catalog.addRegistry("hamster");
        catalog.addRegistry("horse");
        catalog.addRegistry("donkey");
        catalog.getRegistry().get(0).addAnimal(new Animal("Muxtar","dog", "2021-01-01","Paw,Run"));
        catalog.getRegistry().get(0).addAnimal(new Animal("Butch","dog", "2019-12-10","Paw,Run"));
        catalog.getRegistry().get(1).addAnimal(new Animal("Barsik","cat", "2021-01-01","meow"));
        catalog.getRegistry().get(1).addAnimal(new Animal("Murka","cat", "2020-02-02","meow"));
        catalog.getRegistry().get(1).addAnimal(new Animal("Murka","cat", "2020-02-02","meow"));
        catalog.getRegistry().get(2).addAnimal(new Animal("Xoma","hamster", "2023-01-10","run,spin"));
        catalog.getRegistry().get(3).addAnimal(new Animal("Julius","horse", "1456-01-10","trot,gallop,speak"));
        catalog.getRegistry().get(3).addAnimal(new Animal("Thunder","horse", "2019-09-10","trot,gallop"));
        catalog.getRegistry().get(4).addAnimal(new Animal("Moses","donkey", "1440-03-10","walk,carry lyubava"));
        catalog.getRegistry().get(4).addAnimal(new Animal("Ia","donkey", "2015-04-15","walk"));
    }
    private void selectOne(){
        boolean choice = true;
        int numberCatalog = 0, numberAnimal = 0;
        String selectUser;
        while (choice){
            selectUser = menu.menuCatalog(catalog);
            try {
                numberCatalog = Integer.parseInt(selectUser);
                choice = false;
            } catch (NumberFormatException e){
                menu.menuMessage("Неправильный выбор");
            }
            if (numberCatalog > catalog.size()+1 || numberCatalog < 1){
                choice = true;
                menu.menuMessage("Выбран неверный номер");
            } else choice = false;
        }
        if (numberCatalog == catalog.size()+1) return;
        numberCatalog--;
        choice = true;
        while (choice){
            selectUser = menu.menuAnimals(catalog.getRegistry().get(numberCatalog));
            try {
                numberAnimal = Integer.parseInt(selectUser);
                choice = false;
            } catch (NumberFormatException e){
                menu.menuMessage("Неправильный выбор");
            }
            if (numberCatalog > catalog.size()+1 || numberCatalog < 1){
                choice = true;
                menu.menuMessage("Выбран неверный номер");
            } else choice = false;
        }





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
