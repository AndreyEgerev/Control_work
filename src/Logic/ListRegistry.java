package Logic;

import java.util.ArrayList;
import java.util.List;

public class ListRegistry {
    TypeAnimal typeAnimal;
    ArrayList<ListAnimals> catalog;

    public ListRegistry(String typeAnimal) {
        this.catalog = new ArrayList<ListAnimals>();
        this.typeAnimal = new TypeAnimal(typeAnimal);
    }

    public List<ListAnimals> getCatalog(){
        return this.catalog;

    }
    public void addRegistry(String typeAnimal){
        if (!this.catalog.isEmpty()){
            for (ListAnimals listAnimal:
                    this.catalog) {
                if (listAnimal.getTypeAnimals().equals(typeAnimal.trim().toLowerCase())) return;
            }
        }
        this.catalog.add(new ListAnimals(typeAnimal));
    }

    public void removeCatalog(int numberCatalog){
        this.catalog.remove(numberCatalog);
    }

}
