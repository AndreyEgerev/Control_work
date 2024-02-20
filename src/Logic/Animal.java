package Logic;

import java.time.LocalDate;
import java.util.HashSet;

public class Animal {
    private String nameAnimal;
    private TypeAnimal typeAnimal;
    private LocalDate dateOfBirth;
    private HashSet<String> commands;

    public Animal(String nameAnimal, String typeAnimal, LocalDate dateOfBirth, HashSet<String> commands) {
        this.nameAnimal = nameAnimal;
        this.typeAnimal = new TypeAnimal(typeAnimal);
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public Animal(String nameAnimal, String typeAnimal, LocalDate dateOfBirth) {
        this.nameAnimal = nameAnimal;
        this.typeAnimal = new TypeAnimal(typeAnimal);
        this.dateOfBirth = dateOfBirth;
        this.commands = new HashSet<String>();
        this.commands.add("sit");
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    @Override
    public String toString() {
        return "Animal: name - '" + nameAnimal + '\'' +
                ", type - '" + typeAnimal + '\'' +
                ", Date of birth - " + dateOfBirth +
                ", Execute commands - " + commands ;
    }

//    public String getAge(){
//        LocalDate currentDate = LocalDate.now();
//
//        //int years = ChronoUnit.YEARS.between(this.dateOfBirth, currentDate);
//        //int months = ChronoUnit.MONTHS.between(this.dateOfBirth, currentDate) - years * 12;
//
//        return ("Разница в годах: " + years + ", в месяцах: " + months);
//    }

    public boolean addCommand(String command){
        return this.commands.add(command);
    }
}
