package queue;

import interfaces.IQueue;

import java.util.Arrays;

public class ArrayUpQueueService implements IQueue {
    private int[] queue;
    private int size;
    private int front;
    private int back;

    public ArrayUpQueueService(){
        queue = new int[5];
        size = 0;
        front = 0;
        back = -1;
    }

    @Override
    public void enqueue(int instance){
        if(isFilled()) {
            queue = Arrays.copyOf(queue, queue.length*2);
            front = 0;
            back = size - 1;
        }
        back = (back + 1) % queue.length;
        queue[back] = instance;
        size++;
    }
    @Override
    public int dequeue(){
        if(isEmpty()){
            return 0;
        }
        int removedElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return  removedElement;
    }
    @Override
    public int peek(){
        if(isEmpty()){
            return 0;
        }
        return queue[front];
    }

    @Override
    public void clear(){
        queue = new int[queue.length];
        size = 0;
        front = 0;
        back = -1;
    }
    @Override
    public void instances(){
        for(int i = 0; i < size; i++){
            int index = (front + i) % queue.length;
            System.out.println(queue[index] + " ");
        }
        System.out.println();
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFilled() {
        return size == queue.length;
    }
}
