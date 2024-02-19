package Logic;

import java.util.List;

public abstract class AbstractListAnimals {
    private List<ListAnimals> registryList;

//    public AbstractListAnimals(List<ListAnimals> registryList) {
//        this.registryList = registryList;
//    }
    public List<ListAnimals> get(){
        return this.registryList;
    }
}
