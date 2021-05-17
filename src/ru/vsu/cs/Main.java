package ru.vsu.cs;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        SimpleQueue<Integer> simpleQueue = new SimpleLinkedListQueue<>();
        Queue<Integer> queue = new LinkedList<>();

        simpleQueue.offer(null);
        queue.offer(null);

        int[] array = ArrayUtils.readIntArrayFromFile("input.txt");
        assert array != null;
        if (array.length == 0) {
            System.out.println("Can't read from file.");
        } else {
            for (int n : array) {
                simpleQueue.offer(n);
                queue.offer(n);
            }
        }

        outputTheResult(getSimpleQueue(simpleQueue), getQueue(queue), simpleQueue, queue);
    }

    private static int[] getSimpleQueue(SimpleQueue<Integer> simpleQueue) {
        int count = 1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        simpleQueue.offer(simpleQueue.poll());
        while (simpleQueue.peek() != null) {
            int n = simpleQueue.poll();
            simpleQueue.offer(n);
            count++;
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        return new int[]{count, max, min};
    }

    private static int[] getQueue(Queue<Integer> queue) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        queue.offer(queue.poll());
        while (queue.peek() != null) {
            int n = queue.poll();
            queue.offer(n);
            count++;
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        return new int[]{count, max, min};
    }

    private static void printSimpleQueue(SimpleQueue<Integer> simpleQueue) {
        SimpleQueue<Integer> queue = new SimpleLinkedListQueue<>((SimpleLinkedListQueue<Integer>) simpleQueue);
        if (queue.size() == 0) {
            System.out.print("Is empty.");
        }
        System.out.print("SimpleQueue: ");
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }

    private static void printQueue(Queue<Integer> queue1) {
        Queue<Integer> queue = new LinkedList<>(queue1);
        if (queue.size() == 0) {
            System.out.print("Is empty.");
        }
        System.out.print("Queue: ");
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }

    private static void outputTheResult(int[] arr, int[] arr1, SimpleQueue<Integer> simpleQueue, Queue<Integer> queue) {
        System.out.println("It was read from file: ");
        printSimpleQueue(simpleQueue);
        System.out.println();
        printQueue(queue);

        System.out.println("\n\nSize SimpleQueue: " + arr[0]);
        System.out.println("Max element: " + arr[1]);
        System.out.println("Min element: " + arr[2]);

        System.out.println("\nSize Queue: " + arr1[0]);
        System.out.println("Max element: " + arr1[1]);
        System.out.println("Min element: " + arr1[2]);

        System.out.println();
        printSimpleQueue(simpleQueue);
        System.out.println();
        printQueue(queue);
    }

}

