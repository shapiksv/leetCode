package ru.shapik.leet_code.courseAlgoritmUdemy;

import java.util.Stack;

public class QueueViaStack {
    Stack<Integer> stackNewest,  stackOldest;

    public QueueViaStack() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackOldest.size();
    }


    public void enqueue(int value) {
        stackNewest.push(value);
    }

    public int dequeue() {
        move();
        return stackOldest.pop();

    }
    public void move() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
