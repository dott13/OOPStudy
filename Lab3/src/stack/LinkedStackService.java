package stack;

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
        top = new Link(instance, top);
        size++;
    }

    @Override
    public int pop(){
        int instance = top.data;
        top = top.next;
        return instance;
    }

    @Override
    public int peek() {
        return top.data;
    }

    @Override
    public void instances(){
        Link temp = top;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }
    @Override
    public void clear(){
        Link temp = top;
        while (temp != null) {
            System.out.println(temp.data);
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
