package ru.shapik.leet_code.courseAlgoritmUdemy;

import ru.shapik.leet_code.Solution;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;
    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        } else if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.getFirst().isOlderThan(cats.getFirst())) {
            return dogs.pollFirst();
        } else {
            return cats.pollFirst();
        }
    }

    public Dog dequeueDog() {
        return dogs.pollFirst();
    }

    public Cat dequeueCat() {
        return cats.pollFirst();
    }
}


 abstract class Animal {
    private int order;
    protected String name;
    public Animal(String n) {
        name = n;
    }

    public abstract String name();

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }

    public String name() {
        return "Cat: " + name;
    }
}

class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }

    public String name() {
        return "Dog: " + name;
    }
}