package interfaces;

public interface IStack {
    void push(int instance);
    int pop();
    int peek();
    void clear();
    void instances();
    boolean isEmpty();
    boolean isFilled();
}
