package Logic;

import java.util.ArrayList;



public class ListAnimals extends AbstractListAnimals{
    private ArrayList<Animal> registry;
    private TypeAnimal typeAnimals;

    public ListAnimals(ArrayList<Animal> registry, String typeAnimals) {
        this.registry = registry;
        this.typeAnimals = new TypeAnimal(typeAnimals);

    }

    public ListAnimals(String typeAnimals) {
        this.typeAnimals = new TypeAnimal(typeAnimals);
        this.registry = new ArrayList<Animal>();
    }

    public ListAnimals(String typeAnimals, Animal animal) {
        this.typeAnimals = new TypeAnimal(typeAnimals);
        this.registry = new ArrayList<Animal>();
        this.registry.add(animal);
    }

    public String getTypeAnimals() {
        return typeAnimals.getTypeAnimal();
    }

    public void setTypeAnimals(String typeAnimals) {
        this.typeAnimals.setTypeAnimal(typeAnimals);
    }

    public ArrayList<Animal> getRegistry() {
        return registry;
    }

    public void addAnimal(String animal){

    }
    public  void addAnimal(Animal animal){
        this.registry.add(animal);
    }

    public boolean removeAnimal(int indexAnimal){
        if (indexAnimal>=this.registry.size() || indexAnimal< 0){
            return false;
        }
        this.registry.remove(indexAnimal-1);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder listAnimalToView = new StringBuilder();
        listAnimalToView.append(typeAnimals).append("\n");
        if (this.registry.isEmpty()){
            listAnimalToView.append("is empty");
        }
        else {
            int indexAnimal = 1;
            for (Animal animal : this.registry
            ) {
                if (indexAnimal == this.registry.size()){
                    listAnimalToView.append(indexAnimal).append(" - ").append(animal.getNameAnimal());
                }else {
                    listAnimalToView.append(indexAnimal).append(" - ").append(animal.getNameAnimal()).append("\n");
                }
                indexAnimal++;
            }
        }
        return listAnimalToView.toString();
    }

    /**
     * Вывод размрера списка, количества животных в списке
     * @return количество животных в списке - размер списка
     */
    public int size(){
        if (super.get() != null){
            return super.get().size();
        }
        return this.registry.size();
    }

}
