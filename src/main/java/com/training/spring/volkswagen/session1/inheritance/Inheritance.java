package com.training.spring.volkswagen.session1.inheritance;

class Animal {
    private String type;
    private String name;

    public Animal(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String printNameAndType(){
        return "This is a "+this.type+" named "+this.name;
    }
}

class Mammal extends Animal{
    public static final String TYPE = "MAMMAL";

    public Mammal(String name){
        super(Mammal.TYPE, name);
    }
}

class Dog extends Mammal{
    public static final String NAME = "DOG";

    public Dog(){
        super(Dog.NAME);
    }
}

// Exercise
// Create super class called Reptile
// Create class Turtle and class Snake who inherits from reptile

public class Inheritance {

    public static void main(String[] args){
        Dog d = new Dog();
        System.out.println(d.printNameAndType());
        System.out.println("Dog is a mammal:"+ (d instanceof Mammal));
        System.out.println("Dog is a animal:"+ (d instanceof Animal));
        System.out.println("Dog is a object:"+ (d instanceof Object));
    }
}
