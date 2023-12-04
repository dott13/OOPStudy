package queue;

import interfaces.IQueue;

import java.util.Arrays;

public class ArrayDownQueue implements IQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayDownQueue() {
        this.array = new int[5];
        this.front = 4;
        this.rear = 0;
        this.size = 5;
    }

    @Override
    public void enqueue(int instance) {
        if (isFilled()) {
            System.out.println("Array full.");
            return;
        }

        array[front] = instance;
        front--;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        }

        int data = peek();
        for(int i = size - 1; i > front + 1; i--){
            array[i] = array[i -1];
        }
        front += 1;
        return data;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        }

        return array[size - 1];
    }

    @Override
    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public void instances() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[rear]);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFilled() {
        return front == -1;
    }

}
