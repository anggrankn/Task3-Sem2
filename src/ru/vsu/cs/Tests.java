package ru.vsu.cs;

import org.junit.Assert;
import org.junit.Test;

public class Tests<T> {
    @Test
    public void test1GetTheResult() throws Exception {
        SimpleQueue<Integer> simpleQueue = new SimpleLinkedListQueue<>();
        int testSize = 3;
        simpleQueue.offer(1);
        simpleQueue.offer(2);
        simpleQueue.offer(3);
        Assert.assertEquals(testSize, simpleQueue.size());
    }

    @Test
    public void test2GetTheResult() throws Exception {
        SimpleQueue<Integer> simpleQueue = new SimpleLinkedListQueue<>();
        int headValue, testSize = 2, testNum = 5;
        simpleQueue.offer(5);
        simpleQueue.offer(8);
        simpleQueue.offer(-1);
        headValue = simpleQueue.poll();
        Assert.assertEquals(testSize, simpleQueue.size());
        Assert.assertEquals(testNum, headValue);
    }

    @Test
    public void test3GetTheResult() throws Exception {
        SimpleQueue<Integer> simpleQueue = new SimpleLinkedListQueue<>();
        int headValue, testSize = 3, testNum = 10;
        simpleQueue.offer(10);
        simpleQueue.offer(80);
        simpleQueue.offer(-100);
        headValue = simpleQueue.peek();
        Assert.assertEquals(testSize, simpleQueue.size());
        Assert.assertEquals(testNum, headValue);
    }
}
