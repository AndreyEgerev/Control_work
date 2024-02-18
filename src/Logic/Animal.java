package Logic;

import java.time.LocalDate;
import java.util.HashSet;

public class Animal {
    private String nameAnimal;
    private String typeAnimal;
    private LocalDate dateOfBirth;
    private HashSet<String> commands;

    public Animal(String nameAnimal, String typeAnimal, LocalDate dateOfBirth, HashSet<String> commands) {
        this.nameAnimal = nameAnimal;
        this.typeAnimal = typeAnimal;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Animal" +
                "name= '" + nameAnimal + '\'' +
                ", type= '" + typeAnimal + '\'' +
                ", Date of birth= " + dateOfBirth +
                ", Execute commands= " + commands ;
    }

    public int
}
