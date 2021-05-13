package com.training.spring.volkswagen.session1.interfaces;

interface Animal{
    void move();
    void noise();
}

interface HasTail{
    void waveTail();
}

class Dog implements Animal, HasTail{

    @Override
    public void move() {
        System.out.println("Dog starts running");
    }

    @Override
    public void noise() {
        System.out.println("Dog starts barking");
    }

    @Override
    public void waveTail() {
        System.out.println("Dog is waving the tail");
    }
}

// Exercise
// Create a class eagle which implements Animal and Dives
// Create a class fox which implements Animal and HasTail

public class Interfaces {
    public static void main(String[] args){
        Animal d1 = new Dog();
        d1.move();
        d1.noise();
        // d1.waveTail() Animal interface does not have method waveTail()

        Dog d2 = new Dog();
        d2.move();
        d2.noise();
        d2.waveTail();

        HasTail d3 = new Dog();
        d3.waveTail();

        System.out.println("D1 is instance of Animal:"+(d1 instanceof Animal));
        System.out.println("D1 is instance of HasTail:"+(d1 instanceof HasTail));
    }
}
