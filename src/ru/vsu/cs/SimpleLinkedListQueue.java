package ru.vsu.cs;

public class SimpleLinkedListQueue<T> implements SimpleQueue<T> {

    SimpleLinkedListQueue(SimpleLinkedListQueue<T> queue) {
        this.head = queue.head;
        this.tail = queue.tail;
        this.count = queue.count;
    }

    SimpleLinkedListQueue() {
    }

    private static class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;


    @Override
    public void offer(T value) {
        ListNode<T> newNode = new ListNode<>(value, null);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    @Override
    public T poll() {
        if (count == 0) {
            return null;
        }
        T value = head.value;
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    @Override
    public T peek() {
        if (count == 0) {
            return null;
        }
        return head.value;
    }

    @Override
    public int size() {
        return count;
    }
}

