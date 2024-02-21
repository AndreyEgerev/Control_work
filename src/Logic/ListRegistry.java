package Logic;

import java.util.ArrayList;
import java.util.List;

public class ListRegistry {
    TypeAnimal typeAnimal;
    List<ListRegistry> catalog;
    ArrayList<ListAnimals> registry;

    public ListRegistry(String typeAnimal) {
        this.registry = new ArrayList<ListAnimals>();
        this.typeAnimal = new TypeAnimal(typeAnimal);
    }

    public List<ListAnimals> getRegistry(){
        return this.registry;
    }
    public List<ListRegistry> getCatalog(){
        return this.catalog;
    }
    public void addRegistry(String typeAnimal){
        if (!this.registry.isEmpty()){
            for (ListAnimals listAnimal:
                    this.registry) {
                if (listAnimal.getTypeAnimals().equals(typeAnimal.trim().toLowerCase())) return;
            }
        }
        this.registry.add(new ListAnimals(typeAnimal));
    }

    public void removeRegistry(int numberCatalog){
        this.registry.remove(numberCatalog);
    }

    public int size(){
        return this.registry.size();
    }

    @Override
    public String toString() {
        StringBuilder listCatalogToView = new StringBuilder();
        listCatalogToView.append(typeAnimal).append("\n");
        if (this.registry.isEmpty()){
            listCatalogToView.append("is empty");
        }
        else {
            int indexAnimal = 1;
            for (ListAnimals listAnimals : this.registry
            ) {
                if (indexAnimal == this.registry.size()){
                    listCatalogToView.append(indexAnimal).append(" - ").append(listAnimals.getTypeAnimals());
                }else{
                    listCatalogToView.append(indexAnimal).append(" - ").append(listAnimals.getTypeAnimals()).append("\n");
                }
                indexAnimal++;
            }
        }
        return listCatalogToView.toString();
    }
}
