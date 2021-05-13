package com.training.spring.volkswagen.session3.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

interface Animal{
    void feed();
}

class Dog implements Animal{

    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void feed() {
        System.out.println("The dog "+this.name+" eats raw steak");
    }
}

class Sparrow implements Animal {

    private String name;

    public Sparrow(String name){
        this.name = name;
    }

    @Override
    public void feed() {
        System.out.println("The sparrow "+this.name+" ets the worm");
    }
}

@FunctionalInterface
interface CheckTypeOfAnimal{
    boolean evaluate(Animal a);
}

class IsDog implements CheckTypeOfAnimal{

    @Override
    public boolean evaluate(Animal a) {
        return a instanceof Dog;
    }
}

// Exercise
// Create a lambda function that check if its a Sparrow
// Create a lambda function that check if its a Sparrow using a predicate
// Use the foreach statement to check if the animals are dogs

public class Lambda {

    public static void main(String[] args) {

        Animal boris = new Dog("Boris");
        Sparrow jack = new Sparrow("Jack");

        // parameters -> expression
        CheckTypeOfAnimal isDog = a -> a instanceof Dog;
        //CheckTypeOfAnimal isDogImpl = new IsDog();

        //System.out.println("Is Boris a dog? "+ isDogImpl.evaluate(boris));
        //System.out.println("Is Jack a dog? "+ isDogImpl.evaluate(jack));
        System.out.println("Is Boris a dog? "+ isDog.evaluate(boris));
        System.out.println("Is Jack a dog? "+ isDog.evaluate(jack));

        Predicate<Animal> isDogWithPredicate = a -> a instanceof Dog;

        System.out.println("Is Boris a dog? "+ isDogWithPredicate.test(boris));
        System.out.println("Is Jack a dog? "+ isDogWithPredicate.test(jack));

        List<Animal> animalList = new ArrayList<>();
        animalList.add(boris);
        animalList.add(jack);

        // Consumer<Animal> feedTheAnimals = a -> a.feed();
        // animalList.forEach(feedTheAnimals);

        animalList.forEach(a -> a.feed());
    }
}
