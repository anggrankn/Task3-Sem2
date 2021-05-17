package ru.vsu.cs;

public interface SimpleQueue<T> {
    void offer(T value);
    T poll();
    T peek();
    int size();
}
