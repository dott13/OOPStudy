import queue.QueueService;

public class Main {
    public static void main(String[] args){
        //QUEUE
        System.out.println("\nQueue:");
        QueueService queue = new QueueService();

        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(2);
        queue.enqueue(4);

        System.out.println("Deleted from Queue: " + queue.dequeue());
        System.out.println("Deleted from Queue: " + queue.dequeue());
        queue.enqueue(10);
        queue.enqueue(1);

        queue.instances();

    }
}
