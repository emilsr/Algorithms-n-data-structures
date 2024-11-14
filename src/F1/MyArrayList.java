package F1;
import java.util.Arrays;



public class MyArrayList<E> {

    private E[] data;
    private int nrOfElements;
    private int maxSize;

    public MyArrayList() {
        nrOfElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];

        if (nrOfElements < maxSize) {

        } else {

        }
    }

    public boolean add(E element) {
        if (nrOfElements >= maxSize) {

            return false;   // make data lageer
        }
                return false;
    }
}
