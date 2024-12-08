package f4;

/**
 *  Circular array
 *
 *  Data
 *  -- int front, rear, size, maxSize
 *  -- E[] data
 *
 *  Pinter to head and rear of que
 *  if rear = maxSize
 *      move que so rear = 0
 *  if front = max Size
 *      set front = 0
 *  if rear = head
 *      Que is full, and we need to reallocate
 *
 *  Methods
 *  boolean add(E e)
 *  -- trys to add element to Que. Return ture if successful, throw if not
 *  boolean offer(E e)
 *  -- trys to add element to Que. Return ture if successful, return false if fails
 *  E remove()
 *  -- remove and return element in the front of the Que, throw exemption oif Que is empty
 *  E poll()
 *  -- remove and return element in the front of the Que, return null if Que is empty
 *  E element()
 *  -- returns first element in Que, throws if Que is empty
 *  E peek()
 *  -- returns first element in Que, return null if Que is empty
 *
 *  inmp isEmpty and size from interface
 *
 */
public class MyCircularQue {

    public class ArrayQueue<E> {
        private int front, rear, size, maxSize;
        private E[] data;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
        }
    }

}
