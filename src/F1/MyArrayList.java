package F1;
import java.util.Arrays;

/**
 *  *** Make a ArrayList Class
 *
 *  *** Requirements ***
 *  boolean add
 *  boolean remove
 *  "maxSize"*2  if "nrOfElements" == "maxSize"
 *  boolean contains
 */


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
            return false;   // make data lager
        }
        data[nrOfElements+1] = element;
        nrOfElements++;
        return true;
    }

    public boolean remove(E element) {
        if (nrOfElements >= maxSize) {
            return false;
        }
        

        return true;

    }
}
