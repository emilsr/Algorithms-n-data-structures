package uppgift3;

public class Main {

    public static void main(String[] args){
        StringQueue q = new StringQueue();
        System.out.println(q.peak());
        System.out.println(q.dequeue());
        for(int i=0;i<5;i++)
            q.enqueue("s"+i);
        System.out.println(q.dequeue());
        for(int i=5;i<10;i++)
            q.enqueue("s"+i);
        while(!q.isEmpty()) {
            System.out.println(q.peak());
            System.out.println(q.dequeue());
        }
        System.out.println(q.dequeue());
    }
}
