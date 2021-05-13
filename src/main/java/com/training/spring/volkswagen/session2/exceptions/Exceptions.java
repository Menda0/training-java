package com.training.spring.volkswagen.session2.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NoFoodAvailable extends Exception {
    public NoFoodAvailable(){
        super("There is no food available in the supply");
    }
}

class UnableToFeed extends RuntimeException{
    private Dog dog;

    public UnableToFeed(Dog dog){
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

class FoodSupply {
    private int foodUnits;

    public FoodSupply(int foodUnits){
        this.foodUnits = foodUnits;
    }

    public void addFoodSupply() {
        this.foodUnits += 5;
    }

    public void getFoodUnit() throws NoFoodAvailable {
        if(foodUnits <= 0){
            throw new NoFoodAvailable();
        }
        this.foodUnits--;
    }
}

class Dog{
    private String name;
    private FoodSupply foodSupply;

    public Dog(String name, FoodSupply foodSupply){
        this.name = name;
        this.foodSupply = foodSupply;
    }

    public void eat() {
        // if(this.foodSupply.getFoodUnits() > 0)
        try {
            this.foodSupply.getFoodUnit();
            System.out.println("The dog "+this.name+" eats raw steak");
        } catch (NoFoodAvailable noFoodAvailable) {
            this.foodSupply.addFoodSupply();
            throw new UnableToFeed(this);
        }
    }

    public String getName() {
        return name;
    }
}

// Exercise
// Create a drink water method in Dog
// Create water a supply
// Decrement water supply whenever a dog drinks water
// If there is no water throw exception

public class Exceptions {

    public static void main(String[] args) {

        File file = new File("src/main/resources/dogs.csv");
        List<Dog> dogs = new ArrayList<>();
        FoodSupply foodSupply = new FoodSupply(0);

        try{
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String dogName = myReader.nextLine();
                Dog d = new Dog(dogName, foodSupply);
                dogs.add(d);
            }
        } catch (FileNotFoundException e){
            System.out.println("Cannot read file dogs.csv");
        }


        for(Dog d: dogs){
            try{
                d.eat();
            }catch (UnableToFeed e ){
                System.out.println("The dog "+e.getDog().getName()+ " was not able to feed");
            }
        }
    }
}
