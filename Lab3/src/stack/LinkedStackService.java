package stack;

import helpers.Link;
import interfaces.IStack;

public class LinkedStackService implements IStack {
    private Link top;
    private int size;

    public LinkedStackService(){
        top = null;
        size = 0;
    }

    @Override
    public void push(int instance){
        top = new Link(instance);
        size++;
    }

    @Override
    public int pop(){
        int instance = top.getData();
        top = top.getNext();
        return instance;
    }

    @Override
    public int peek() {
        return top.getData();
    }

    @Override
    public void instances(){
        Link temp = top;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        System.out.println("null");
    }
    @Override
    public void clear(){
        Link temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
        }
        System.out.println("null");
    }

    @Override
    public boolean isEmpty(){
        return top == null;
    }
    @Override
    public boolean isFilled(){
        return false;
    }
}
