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

    public Animal(String nameAnimal, String typeAnimal, LocalDate dateOfBirth, String commands) {
        this.nameAnimal = nameAnimal;
        this.typeAnimal = new TypeAnimal(typeAnimal);
        this.dateOfBirth = dateOfBirth;
        this.commands = new HashSet<String>();
        String[] commandsParse = commands.split(",");
        for (String command :
                commandsParse) {
            this.commands.add(command.trim().toLowerCase());
        }
    }

    public Animal(String nameAnimal, String typeAnimal, String dateOfBirth, String commands) {
        this.nameAnimal = nameAnimal;
        this.typeAnimal = new TypeAnimal(typeAnimal);
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.commands = new HashSet<String>();
        String[] commandsParse = commands.split(",");
        for (String command :
             commandsParse) {
            this.commands.add(command.trim().toLowerCase());
        }
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

    public boolean addCommand(String command){
        return this.commands.add(command);
    }
}
