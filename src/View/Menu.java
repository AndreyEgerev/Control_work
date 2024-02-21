package View;

import Logic.Animal;
import Logic.ListAnimals;
import Logic.ListRegistry;

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
                "3 - Загрузить информацию о животных из файла\n" +
                "4 - Вывести количество животных в реестре\n" +
                "5 - Выход");
        return InputUserData.getData();
    }
    public String menuAddAnimal(){
        menuMessage("Введите имя животного");
        menuMessage("Введите тип животного");
        menuMessage("Введите дату рождения");
        menuMessage("Введите команды");
        return InputUserData.getData();
    }
    /**
     * Меню с перечнем животных
     * @param listAnimals экземпляр класса ListAnimals, содержащий список животных
     * @return выбор пользователя для дальнейших действий
     */
    public String menuAnimals(ListAnimals listAnimals){
        if (listAnimals != null){
            if (!listAnimals.getRegistry().isEmpty()){
                menuMessage("Выберите животное");
                menuMessage(listAnimals.toString());
            }
            menuMessage(listAnimals.size()+" - Возврат в предыдущее меню");
        }else {
            throw new NullPointerException("Ошибка со списком животных");
        }
        return InputUserData.getData();
    }
    public String menuCatalog(ListRegistry catalog){
        if (catalog != null){
            if (!catalog.getRegistry().isEmpty()){
                menuMessage("Выберите перечень");
                menuMessage(catalog.toString());
            }
            menuMessage(catalog.size()+ " - Возврат в предыдущее меню");
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
    public String menuAnimal(Animal animal) {
        if (animal != null) {
            menuMessage(animal.toString());
            menuMessage("1 - Обучить командам" +
                    "2 - Возврат в предыдущее меню");
            return InputUserData.getData();
        }else{
            throw new NullPointerException("Ошибка с данными о животном");
        }
    }

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
