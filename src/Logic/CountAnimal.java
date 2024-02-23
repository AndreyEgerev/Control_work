package Logic;

import java.io.Closeable;

public class CountAnimal implements AutoCloseable{
    private int count;

//    public CountAnimal() {
//        this.count = 0;
//    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void addCount(){
        this.count++;
    }
    public int subtractCount(){
        this.count--;
        return this.count;
    }

    @Override
    public void close() throws Exception {

    }
}
