import Logic.Animal;
import Logic.ListAnimals;
import View.Menu;

import java.time.LocalDate;
import java.util.HashSet;
/*
        14. Написать программу, имитирующую работу реестра домашних животных.
        В программе должен быть реализован следующий функционал:
        14.1 Завести новое животное
        14.2 определять животное в правильный класс
        14.3 увидеть список команд, которое выполняет животное
        14.4 обучить животное новым командам
        14.5 Реализовать навигацию по меню
        15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
        значение внутренней int переменной на 1 при нажатие “Завести новое
        животное” Сделайте так, чтобы с объектом такого типа можно было работать в
        блоке try-with-resources. Нужно бросить исключение, если работа с объектом
        типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
        считать в ресурсе try, если при заведения животного заполнены все поля
 */
public class Main {
    public static void main(String[] args) {
//        ListAnimals listAnimals = new ListAnimals("cat");
//        HashSet<String> commands = new HashSet<>();
//        commands.add("meow");
//        commands.add("jump");
//        Animal cat = new Animal("Tom","cat",LocalDate.now(), commands);
//        System.out.println(cat);
//        listAnimals.addAnimal(cat);
//        System.out.println(listAnimals);

        Presenter program = new Presenter();
        program.onRun();


    }
}