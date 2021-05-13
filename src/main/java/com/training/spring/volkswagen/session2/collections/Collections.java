package com.training.spring.volkswagen.session2.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class Dog {
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println("The dog "+this.name+" eats raw steak");
    }

    public String getName() {
        return name;
    }
}

class PackOfDogs {
    private Set<Dog> dogSet;
    private Map<String, Dog> dogMap;

    public PackOfDogs() {
        this.dogSet = new HashSet<>();
        this.dogMap = new HashMap<>();
    }

    public void addDog(Dog d){
        this.dogSet.add(d);
        this.dogMap.put(d.getName(), d);
    }

    public void feedDogs(){
        for (Dog d: this.dogSet){
            d.eat();
        }
    }

    // O(N) complexity
    public void feedDog1(String name){
        for(Dog d: this.dogSet){
            if(d.getName().equals(name)){
                d.eat();
                break;
            }
        }
    }

    //  < O(N) complexity
    public void feedDog2(String name){
        Dog d = this.dogMap.get(name);
        d.eat();
    }
}

// Exercise
// Create a Flock of birds using datastructures
// Add feed all the birds

public class Collections {

    public static void main(String[] args) {
        Dog boris = new Dog("Boris");
        Dog dora = new Dog("Dora");

        PackOfDogs packOfDogs = new PackOfDogs();
        packOfDogs.addDog(boris);
        packOfDogs.addDog(dora);

        packOfDogs.feedDogs();
        packOfDogs.feedDog1("Boris");
    }
}
