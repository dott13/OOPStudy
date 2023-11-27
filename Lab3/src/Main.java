import queue.QueueService;
import stack.LinkedStackService;
import stack.StackService;

public class Main {
    public static void main(String[] args){
        //QUEUE
        System.out.println("\nQueue:");
        QueueService queue = new QueueService();

        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(4);
        queue.instances();

        System.out.println("Deleted from Queue: " + queue.dequeue());
        System.out.println("Deleted from Queue: " + queue.dequeue());
        queue.enqueue(10);
        queue.enqueue(1);

        queue.instances();

        queue.clear();

        System.out.println("Is Queue empty?" + queue.isEmpty());
        //STACK
        System.out.println("\nStack:");
        StackService stack = new StackService();

        stack.push(1);
        stack.push(5);
        stack.push(4);

        System.out.println("Top instance:" + stack.peek());
        System.out.println("Deleted from Stack:" + stack.pop());

        System.out.print("Show all: ");
        stack.instances();

        System.out.println("Empty Stack.");
        stack.clear();

        System.out.println("Is the stack empty?" + stack.isEmpty());

        //LINKED STACK
        System.out.println("\nLinked Stack");
        LinkedStackService linkedStack = new LinkedStackService();

        stack.push(1);
        stack.push(6);
        stack.instances();
        System.out.println("Top Instance:" + stack.peek());
        System.out.println("Delete from LinkedStack:" + stack.pop());

        stack.instances();
    }
}
