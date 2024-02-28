package View;

import Logic.Animal;
import Logic.ListAnimals;
import Logic.ListRegistry;

import java.util.ArrayList;

public class Menu {
    ViewData view;
    InputUserData userData;
    public Menu() {
        this.view = new ViewData();
        this.userData = new InputUserData();
    }

    /**
     * Главное меню
     * @return выбор пользователя для дальнейших действий
     */
    public String mainMenu(){
        menuMessage("Registry Animal\n" +
                "Выберите действие\n" +
                "1 - Получить информацию о животных\n" +
                "2 - Добавить информацию о животном\n" +
                "3 - Вывести количество животных в реестре\n" +
                "4 - Выход");
        return InputUserData.getData();
    }

    public String menuAddTypeAnimal(){
        menuMessage("Введите тип животного");
        return InputUserData.getData();
    }

    public String menuAddAnimalDescription(){
        menuMessage("Введите имя животного, дату рождения в формате дд.мм.гггг и выполняемые команды через запятую\n" +
                "Можно вводить несколько команд через запятую");
        return InputUserData.getData();
    }

    /**
     * Меню для вывода общего количества животных
     * @param countAnimal общее количество животных
     */
    public void menuCountAnimal(int countAnimal){
        menuMessage("Животных в реестре - " + countAnimal + "\n");
    }
    /**
     * Меню с перечнем животных
     * @param listAnimals экземпляр класса ListAnimals, содержащий список животных
     * @return выбор пользователя для дальнейших действий
     */
    public String menuAnimals(String listAnimals, int size){
        if (listAnimals != null){
            if (!listAnimals.isEmpty()){
                menuMessage("Выберите животное");
                menuMessage(listAnimals);
            }
            menuMessage((size+1) + " - Возврат в предыдущее меню");
        }else {
            throw new NullPointerException("Ошибка со списком животных");
        }
        return InputUserData.getData();
    }

    /**
     * Меню с перечнем списков животных по типам
     * @param catalog экземпляр класса ListRegistry, содержащий список с вложенными списками животных
     * @return выбор пользователя для дальнейших действий
     */
    public String menuCatalog(String catalog, int size){
        if (catalog != null){
            if (!catalog.isEmpty()){
                menuMessage("Выберите перечень");
                menuMessage(catalog);
            }
            menuMessage((size+1) + " - Возврат в предыдущее меню");
        }else {
            throw new NullPointerException("Ошибка со списком животных");
        }
        return InputUserData.getData();
    }

    /**
     * Меню с действиями над конкретным животным
     * @param animal экземпляр класса Animal, о котором выводится информация
     * @return выбор пользователя для дальнейших действий
     */
    public String menuAnimal(String animal) {
        if (animal != null) {
            menuMessage(animal);
            menuMessage("1 - Обучить командам\n" +
                    "2 - Возврат в предыдущее меню");
            return InputUserData.getData();
        }else{
            throw new NullPointerException("Ошибка с данными о животном");
        }
    }

    /**
     * Меню добавления команд
     * @return перечень команд для добавления
     */
    public String menuAddCommand(){
        menuMessage("Введите новую команду, можно ввести несколько через \',\'");
        return InputUserData.getData();
    }
    /**
     *
     * @param message - выводимое сообщение
     */
    public void menuMessage(String message){
        view.writeMessage(message);
    }
}
