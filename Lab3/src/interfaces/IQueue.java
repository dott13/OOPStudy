package interfaces;

public interface IQueue {
    void enqueue(int instance);
    int dequeue();
    int peek();
    void clear();
    void instances();
    boolean isEmpty();
    boolean isFilled();
}
