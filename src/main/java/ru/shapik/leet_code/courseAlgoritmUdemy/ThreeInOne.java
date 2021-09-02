package ru.shapik.leet_code.courseAlgoritmUdemy;

public class ThreeInOne {

        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public ThreeInOne(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize +numberOfStacks];
            sizes = new int[stackSize];
        }

        // isFull
        public boolean isFull(int stackNum) {
            if (sizes[stackNum] == stackCapacity) return true;
            return false;
        }

        // isEmpty
        public boolean isEmpty(int stackNum) {
            if (sizes[stackNum]== 0) return true;
            return false;
        }

        // indexOfTop - this is helper method for push, pop and peek methods

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size -1;
        }

        // push
        public void push(int stackNum, int value) {
            if (!isFull(stackNum)) {
                sizes[stackNum]++;
                values[indexOfTop(stackNum)] = value;
            }
        }

        // pop
        public int pop(int stackNum) {
            if (!isEmpty(stackNum)) {
                int index = indexOfTop(stackNum);
                int value = values[index];
                values[index] = 0;
                return value;
            }
            return -1;
        }

        // peek

        public int peek(int stackNum) {
            if (!isEmpty(stackNum)) {
                return values[indexOfTop(stackNum)];
            }
            return -1;
        }



}
