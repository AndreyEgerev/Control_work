import Logic.*;
import View.Menu;

public class Presenter {
    private Menu menu;
    private ListRegistry catalog;
    private CountAnimal countAnimal;

    public Presenter() {
        this.menu = new Menu();
        this.catalog = new ListRegistry("animal");
        this.countAnimal = new CountAnimal();
    }

    public void onRun(){
        onStart();
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
                    runFlag = false;
                    menu.menuMessage("Выход");
                    break;
                default:
                    menu.menuMessage("Неверный ввод");
            }
        }
    }

    /**
     * Тестовое наполнение реестра
     */
    public void onStart(){
        addNewAnimalNewType("dog","Muxtar, 01.01.2021, Paw,Run");
        addNewAnimalExecType(0,"dog","Butch,10.12.2019,Paw,Run");
        addNewAnimalNewType("cat","Barsik,01.01.2021,meow");
        addNewAnimalExecType(1,"cat","Murka, 02.02.2020,meow");
        addNewAnimalExecType(1,"cat","Markiza, 02.03.2021,meow");
        addNewAnimalNewType("hamster","Xoma,10.01.2023,run,spin");
        addNewAnimalNewType("horse","Julius, 10.01.1456,trot,gallop,speak");
        addNewAnimalExecType(3,"horse","Spirit, 08.05.1864,trot,gallop");
        addNewAnimalNewType("donkey","Moses, 03.10.1440, walk,carry lyubava");
        addNewAnimalExecType(4,"donkey","Ia, 15.04.2015,walk");
        addNewAnimalExecType(4,"donkey","Donkey, 07.11.2001,walk,sarcasm");

        //catalog.getRegistry().get(4).addAnimal(new Animal("Donkey","donkey", "2010-11-07","walk,sarcasm"));
    }

    /**
     * Выбор первой опции меню
     * просмотр информации по реестру животных,
     * возможность просмотра информации о животном
     * добавление новых команд
     */
    private void selectOne() {
        System.out.println("selectOne");
        boolean choice = true, selectRight;
        int numberCatalog = 0;
        String selectUser;
        while (choice) {
            selectRight = false;
            selectUser = menu.menuCatalog(catalog);
            try {
                numberCatalog = Integer.parseInt(selectUser);
                //choice = false;
            } catch (NumberFormatException e) {
                menu.menuMessage("Неправильный выбор");
            }
            if (numberCatalog > catalog.size() + 1 || numberCatalog < 1) {
                //choice = true;
                menu.menuMessage("Выбран неверный номер");
            } //else choice = false;
            else selectRight = true;
        if (numberCatalog == catalog.size() + 1) return;
        numberCatalog--;
        if (selectRight) selectViewAnimals(catalog.getRegistry().get(numberCatalog));
        }
    }

    /**
     * Просмотр информации о списке животных с дальнейшими командами
     * @param listAnimals объект класса ListAnimal, содержащий информации о животных
     */
    private void selectViewAnimals(ListAnimals listAnimals){
        boolean choice = true, selectRight;
        String selectUser;
        int numberAnimal =0;
        while (choice){
            selectRight = false;
            selectUser = menu.menuAnimals(listAnimals);
            try {
                numberAnimal = Integer.parseInt(selectUser);
                //choice = false;
            } catch (NumberFormatException e){
                menu.menuMessage("Неправильный выбор");
            }
            if (numberAnimal > listAnimals.size()+1 || numberAnimal < 1){
                //choice = true;
                menu.menuMessage("Выбран неверный номер");
            } //else choice = false;
            else selectRight = true;
            if (numberAnimal == listAnimals.size()+1) return;
            numberAnimal--;
            if (selectRight) selectViewInfoAnimal(listAnimals.getRegistry().get(numberAnimal));
        }
    }

    /**
     * Просмотр информации о конкретном животном с дальнейшими командами
     * @param animal объект класса Animal
     */
    private void selectViewInfoAnimal(Animal animal){
        boolean choice = true;
        while (choice) {
            String selectUser = menu.menuAnimal(animal);
            switch (selectUser) {
                case "1":
                    selectAddCommandAnimal(animal);
                    break;
                case "2":
                    choice = false;
                    break;
                default:
                    menu.menuMessage("Неверный ввод");
            }
        }
    }

    /**
     * Добавление команд животному
     * @param animal объект класса Animal, которому требуется добавить команды
     */
    private void selectAddCommandAnimal(Animal animal){
        String commands = menu.menuAddCommand();
        String[] commandsParse = commands.split(",");
            for (String command :
                    commandsParse) {
                animal.addCommand(command);
            }
    }

    /**
     * Выбор второй опции меню
     * добавление животного в существующие списки или в новый
     */
    private void selectTwo(){
        String newAnimalType = menu.menuAddTypeAnimal();
        String newAnimalDescription = menu.menuAddAnimalDescription();
        if (checkExecTypeAnimal(newAnimalType)){
            int numberListOnType = selectListAnimalOnType(newAnimalType);
            if (numberListOnType != -1){
                addNewAnimalExecType(numberListOnType, newAnimalType, newAnimalDescription);
            }else {
                addNewAnimalNewType(newAnimalType, newAnimalDescription);
            }
        }else {
            addNewAnimalNewType(newAnimalType, newAnimalDescription);
        }
    }

    /**
     * Проверка на существование типа животного
     * @param typeAnimal проверяемый тип животного
     * @return результат проверки true если есть/ false если нет
     */
    private boolean checkExecTypeAnimal(String typeAnimal){
        for (String execType:
             TypeAnimal.getListTypes()) {
            if (typeAnimal.equals(execType)){
                return true;
            }
        }
        return false;
    }

    /**
     * Выбор требуемого индекса списка животных
     * @param typeAnimal тип животного
     * @return значение индекса списка животных с запрашиваемым типом
     */
    private int selectListAnimalOnType(String typeAnimal){
        for (int i = 0 ; i < catalog.size(); i++){
            if (catalog.getRegistry().get(i).getTypeAnimals().equals(typeAnimal)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Добавление нового животного нового типа
     * @param type новый тип животного
     * @param description описание животного
     *                    вида "том, 23.02.20224, бег,прыг"
     */
    private void addNewAnimalNewType(String type, String description){
        catalog.addRegistry(type);
        int numberList = selectListAnimalOnType(type);
        addNewAnimalExecType(numberList, type, description);
    }

    /**
     * Добавление животного в существующий список
     * @param numberList номел списка животных, куда необходимо добавить
     * @param type тип животного
     * @param description описание животного
     *                    вида "том, 23.02.20224, бег,прыг"
     */
    private void addNewAnimalExecType(int numberList, String type, String description){
        catalog.getRegistry().get(numberList).addAnimal(ParseService.parseData(type, description));
        countAnimal.addCount();
    }
    /**
     * Выбор третьей опции меню
     * просмотр информации о количестве животных в реестре
     */
    private void selectTree(){
        menu.menuCountAnimal(countAnimal.getCount());

    }
    private void selectFour(){
        menu.menuMessage("Option is not available");
    }
}
