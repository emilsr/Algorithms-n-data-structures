package F1;
import java.util.Arrays;

/**
 *  * Make a ArrayList Class
 *  *** Requirements ***
 *  boolean add
 *  boolean remove(index)
 *  boolean remove(element)
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
        for (int i = 0; i <= nrOfElements; i++) {
            if (data[i] == element) {
                for (int j = i; j <= nrOfElements; j++) {
                    data[j] = data[j+1];
                }
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= nrOfElements) {
            for (int i = index; i <= nrOfElements; i++) {
                data[i] = data[i+1];
            }
            return true;
        }
        return false;
    }

    public boolean contains(E element) {    //maybe return index instead?
        for (int i = 0; i <= nrOfElements; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }
}
