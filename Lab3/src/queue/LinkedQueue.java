package queue;

import helpers.Link;
import interfaces.IQueue;
import interfaces.IStack;

public class LinkedQueue implements IQueue {
    private Link front;
    private Link rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(int instance) {
        Link link = new Link(instance);
        if( isEmpty()){
            front = link;
        } else {
            rear.setNext(link);
        }
        rear = link;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        int data = front.getData();
        front = front.getNext();
        size--;
        return data;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return front.getData();
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void instances() {
        Link current = front;
        while(current != null){
            System.out.println(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFilled() {
        return size > 0;
    }
}
