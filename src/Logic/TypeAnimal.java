package Logic;

import java.util.HashSet;

public class TypeAnimal {
    private String typeAnimal;
    private static HashSet<String> listTypes;

    public TypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal.trim().toLowerCase();
        listTypes.add(typeAnimal.trim().toLowerCase());
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal.trim().toLowerCase();
        listTypes.add(typeAnimal.trim().toLowerCase());
    }

    public static HashSet<String> getListTypes() {
        return listTypes;
    }

    @Override
    public String toString() {
        return typeAnimal;
    }
}
