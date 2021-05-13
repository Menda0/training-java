package com.training.spring.volkswagen.session3.annotations;

import java.lang.annotation.*;

// No value annotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Animal {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface FoodType {
    String value() default "Meat";
}

@Animal
class BaseAnimal {
    private String name;

    public BaseAnimal(String name) {
        this.name = name;
    }

    public void feed() {
        FoodType foodType = this.getClass().getAnnotation(FoodType.class);
        System.out.println("The animal " + this.name + " eats the " + foodType.value());
    }

    public void move() {
        System.out.println("The animal " + this.name + " starts moving");
    }
}

// Dog is animal
// Dog eats Steaks
// Dog runs
@FoodType(value = "Steak")
class Dog extends BaseAnimal {

    public Dog(String name) {
        super(name);
    }
}

// Exercise
// Create a parrot name jack
// The parrot eats worms
// Create an annotation that defines the type of movements of the animal
public class Annotations {

    public static void main(String[] args) {

        Dog boris = new Dog("Boris");
        boris.feed();

        boolean isBorisAnAnimal = boris.getClass().getAnnotation(Animal.class) != null;

        System.out.println("Is boris an animal:" + isBorisAnAnimal);
    }
}
