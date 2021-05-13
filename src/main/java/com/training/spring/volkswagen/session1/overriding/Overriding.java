package com.training.spring.volkswagen.session1.overriding;

import javax.sound.midi.SysexMessage;

class Animal{
    public void move(){
        System.out.println("Animal will start moving ...");
    }

    public void noise(){
        System.out.println("Animal will start making noises ...");
    }

    public String toString(){
        return "I am an animal";
    }
}

class Dog extends Animal{

    public void move(){
        super.move();
        System.out.println("Dog start running");
    }

    public void noise(){
        super.noise();
        System.out.println("Dog start barking");
    }

    public void waveTail(){
        System.out.println("Dog start waving the tail");
    }
}

// Exercise
// Create class Fox and Eagle who inherits from Animal
// Override the move and noise functions

public class Overriding {

    public static void main(String [] args){

        Animal a1 = new Animal();

        System.out.println(a1);

        a1.move();
        a1.noise();

        Dog d1 = new Dog();
        d1.move();
        d1.noise();
        d1.waveTail();

        Animal d2 = new Dog();
        d2.move();
        d2.noise();
        // d2.waveTail();
        Dog d3 = (Dog) d2;
        d3.waveTail();
    }
}
