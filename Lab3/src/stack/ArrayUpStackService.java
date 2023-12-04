package stack;

import interfaces.IStack;

import java.util.Arrays;

public class ArrayUpStackService implements IStack {
    private int[] stack;
    private int top;

    public ArrayUpStackService(){
        stack = new int[5];
        top = 0;
    }

    @Override
    public void push(int element){
        if(isFilled()){
            stack = Arrays.copyOf(stack, top*2);
        }
        stack[top] = element;
        top++;
    }
    @Override
    public int pop(){
        top--;
        int instance = stack[top];
        stack[top] = 0;
        return instance;
    }
    @Override
    public int peek(){
        return stack[top - 1];
    }
    @Override
    public void clear(){
        stack = new int[5];
        top = 0;
    }
    @Override
    public void instances(){
        for(int i: stack)
        {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty(){
        return top == 0;
    }
    @Override
    public boolean isFilled(){
        return top == stack.length;
    }
}
