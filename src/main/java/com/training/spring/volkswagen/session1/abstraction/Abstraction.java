package com.training.spring.volkswagen.session1.abstraction;

abstract class Animal{
    private String name;

    public Animal(String name){
        this.name = name;
    }

    // Every class with an abstract method must be an abstract class
    public abstract void move();
}

class Dog extends Animal{

    public static final String NAME = "DOG";

    public Dog(){
        super(Dog.NAME);
    }

    // Every class the extends an abstract class must implement the abstract methods
    // Unless the child class is abstract
    @Override
    public void move() {
        System.out.println("Dogs starts running");
    }
}

// Exercise
// Create class Salmon and Eagle who inherits from Animal
// Override the move function

public class Abstraction {
    public static void main(String[] args){
        // Animal a = new Animal(); // You cannot intiate a abstract class

        Dog d1 = new Dog();
        d1.move();
    }
}
