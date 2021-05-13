package com.training.spring.volkswagen.session3.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

interface Animal{
    void feed();
    void move();

    String getName();
    Integer getAge();
}

class Dog implements Animal {

    private String name;
    private Integer age;

    public Dog(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void feed() {
        System.out.println("The dog "+this.name+" eat raw steak");
    }

    @Override
    public void move() {
        System.out.println("The dog "+this.name+" starts running");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }
}

class Sparrow implements Animal{

    private String name;
    private Integer age;

    public Sparrow(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void feed() {
        System.out.println("The sparrow "+this.name+" eats the worm");
    }

    @Override
    public void move() {
        System.out.println("The sparrow "+this.name+" flies away");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }
}

// Exercise
// Move all the animals
// Get a list of animals sorted by age
// Get a list of sparrow with age > 5
// Get the youngest dog

public class Streams {
    public static void main(String[] args) {
        Animal boris = new Dog("Boris", 10);
        Animal marta = new Dog("Marta", 3);
        Animal rocky = new Dog("Rocky", 2);
        Animal mafalda = new Dog("Mafalda", 14);
        Animal jack = new Sparrow("Jack", 1);
        Animal linda = new Sparrow("Linda", 1);
        Animal tobias = new Sparrow("Tobias", 5);
        Animal roger = new Sparrow("Roger", 8);

        Animal[] animals = new Animal[]{boris, marta, rocky, mafalda, jack, linda, tobias, roger};

        // For each
        // Feed all animals
        // Consumer<Animal> feedAllAnimals = a -> a.feed();
        // Arrays.stream(animals).forEach(feedAllAnimals);
        System.out.println("Feed all the animals");
        Arrays.stream(animals).forEach(a -> a.feed());
        // Limit, Pipelining
        // Feed only three animals
        System.out.println("Feed only three animals");
        Arrays.stream(animals).limit(3).forEach(a -> a.feed());
        // Map, Collect
        // Get all animal names
        System.out.println("Get all animal names");
        // Function<Animal, String> getAnimalNames = a -> a.getName();
        String animalNames = Arrays.stream(animals).map(a -> a.getName()).collect(Collectors.joining(","));
        System.out.println(animalNames);
        // Sort
        // Get all animal names in alphabetical order
        System.out.println("Get all animal names in alphabetical order");
        Comparator<Animal> compareAnimals = (a, b) -> a.getName().compareTo(b.getName());
        // List<Animal> animalsOrderedByName = Arrays.stream(animals).sorted(compareAnimals).collect(Collectors.toList());
        // System.out.println(animalsOrderedByName);
        // Arrays.stream(animals).map(a -> a.getName()).sorted().collect(Collectors.joining(", "));
        String animalsOrderedByName = Arrays.stream(animals).sorted(compareAnimals).map(a -> a.getName()).collect(Collectors.joining(","));
        System.out.println(animalsOrderedByName);
        // Distinct
        // Get all types of animals
        System.out.println("Get all types of animals");
        String typesOfAnimals = Arrays.stream(animals).map(a -> a.getClass().getSimpleName()).distinct().collect(Collectors.joining(","));
        System.out.println(typesOfAnimals);
        // Filter
        // Feed only the dogs
        System.out.println("Feed only the dogs");
        // Arrays.stream(animals).filter(a -> a.getClass().equals(Dog.class)).forEach(a -> a.feed());
        Arrays.stream(animals).filter(a -> a instanceof Dog).forEach(a -> a.feed());
        // Collectors
        // Get a list of dogs
        System.out.println("Get a list of dogs");
        List<Animal> dogs = Arrays.stream(animals).filter(a -> a instanceof Dog).collect(Collectors.toList());
        System.out.println("There is a total of "+dogs.size()+" dogs");
        // Count
        // Count get number of sparrows
        System.out.println("Count get number of sparrows");
        Long numberOfSparrows = Arrays.stream(animals).filter(a -> a instanceof Sparrow).count();
        System.out.println(numberOfSparrows);
        // Max
        // Get the oldest animal
        System.out.println("Get the oldest animal");
        Comparator<Animal> compareAge = (a,b) -> a.getAge().compareTo(b.getAge());
        Optional<Animal> oldestAnimal = Arrays.stream(animals).max(compareAge);
        Animal a = oldestAnimal.get();
        System.out.println(a.getName());
    }
}
