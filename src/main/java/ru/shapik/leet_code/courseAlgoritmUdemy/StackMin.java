package ru.shapik.leet_code.courseAlgoritmUdemy;

public class StackMin {
    Node top;
    Node min;

    public StackMin() {
        top = null;
        min = null;
    }

    public int min() {
        return min.value;
    }

    public void push(int value) {
        Node newTop = new Node();
        newTop.value = value;
        if (top == null) {
            top = newTop;
            Node newMin = new Node();
            newMin.value = value;
        } else {
            newTop.next = top;
            top = newTop;
            if (value <= min.value) {
                Node newMin = new Node();
                newMin.value = value;
                newMin.next = min;
                min = newMin;
            }
        }
    }

    public int pop() {
        if (top == null) return -1;
        if (top.value == min.value) {
            min = min.next;
        }
        int value = top.value;
        top = top.next;
        return value;
    }

}
class Node {
    int value;
    Node next;
}

