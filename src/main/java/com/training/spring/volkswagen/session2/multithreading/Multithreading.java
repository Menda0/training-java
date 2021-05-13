package com.training.spring.volkswagen.session2.multithreading;

import java.util.Random;

class Dog{
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public void eat() {
        System.out.println("The dog "+this.name+" eats raw steak");
    }

    public void move() {
        System.out.println("The dog "+this.name+" starts running");
    }

    public String getName() {
        return name;
    }
}

class FeedTheDog implements Runnable{

    private Dog dog;

    public FeedTheDog(Dog dog){
        this.dog = dog;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int mills = rand.nextInt(5000);

        System.out.println("Feeding the dog "+ this.dog.getName()+ " in "+mills+" milliseconds");

        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.dog.eat();
    }
}

// Exercise
// Create a thread to walk the dogs

public class Multithreading {

    public static void main(String[] args) {
        Dog boris = new Dog("Boris");
        Dog dora = new Dog("Dora");

        FeedTheDog feedBoris = new FeedTheDog(boris);
        Thread t1 = new Thread(feedBoris);
        t1.start();

        FeedTheDog feedDora = new FeedTheDog(dora);
        Thread t2 = new Thread(feedDora);
        t2.start();

        System.out.println("End of execution");
    }
}
