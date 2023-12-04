import queue.ArrayDownQueue;
import queue.ArrayUpQueueService;
import queue.LinkedQueue;
import stack.ArrayDownStack;
import stack.LinkedStackService;
import stack.ArrayUpStackService;

public class Main {
    public static void main(String[] args){
        //QUEUE
        System.out.println("\nQueue:");
        ArrayUpQueueService queue = new ArrayUpQueueService();

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
        ArrayUpStackService stack = new ArrayUpStackService();

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

        linkedStack.push(1);
        linkedStack.push(6);
        linkedStack.instances();
        System.out.println("Top Instance:" + linkedStack.peek());
        System.out.println("Delete from LinkedStack:" + linkedStack.pop());

        stack.instances();
        //ARRAY DOWN QUEUE
        System.out.println("\nQueueDown:");
        ArrayDownQueue queueDown = new ArrayDownQueue();

        queueDown.enqueue(1);
        queueDown.enqueue(6);
        queueDown.enqueue(4);
        queueDown.instances();

        System.out.println("Deleted from Queue: " + queueDown.dequeue());
        System.out.println("Deleted from Queue: " + queueDown.dequeue());
        queueDown.enqueue(10);
        queueDown.enqueue(1);

        queueDown.instances();

        queueDown.clear();

        System.out.println("Is Queue empty?" + queueDown.isEmpty());
        //Linked Queue
        System.out.println("\nLinkedQueue:");
        LinkedQueue queueLinked = new LinkedQueue();

        queueLinked.enqueue(1);
        queueLinked.enqueue(6);
        queueLinked.enqueue(4);
        queueLinked.instances();

        System.out.println("Deleted from Queue: " + queueLinked.dequeue());
        System.out.println("Deleted from Queue: " + queueLinked.dequeue());
        queueLinked.enqueue(10);
        queueLinked.enqueue(1);

        queueLinked.instances();

        queueLinked.clear();

        System.out.println("Is Queue empty?" + queueLinked.isEmpty());
        //ARRAY DOWN STACK
        System.out.println("\nArray Down Stack");
        ArrayDownStack downStack = new ArrayDownStack();

        downStack.push(1);
        downStack.push(6);
        downStack.instances();
        System.out.println("Top Instance:" + downStack.peek());
        System.out.println("Delete from Stack:" + downStack.pop());

        downStack.instances();
    }
}
