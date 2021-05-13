package com.training.spring.volkswagen.session2.generics;

abstract class Animal{
    private String type;

    public Animal(String type){
        this.type = type;
    }

    public abstract void move();
}

abstract class Mammal extends Animal{

    public static final String TYPE = "MAMMAL";

    public Mammal(){
        super(Mammal.TYPE);
    }
}

abstract class Bird extends Animal{
    public static final String TYPE = "BIRD";

    public Bird(){
        super(Bird.TYPE);
    }
}

class Sparrow extends Bird{

    public String name;

    public Sparrow(String name){
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("The sparrow "+this.name+" flies away");
    }
}

class Dog extends Mammal{

    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("The dog "+this.name+" runs");
    }
}

class Group<E> {
    private E[] animals;

    public Group(E[] animals){
        this.animals = animals;
    }

    public void move(){
        for(E animal: animals){
            Animal a = (Animal) animal;
            a.move();
        }
    }
}

class Pack<E extends Dog> {
    private E[] dogs;

    public Pack(E [] dogs){
        this.dogs = dogs;
    }

    public void move(){
        for(E animal: this.dogs){
            animal.move();
        }
    }
}

// Exercise
// Create a method feed on animal
// Create generic class which represents flock of birds
// Feed all birds

public class Generics {

    public static <E extends Pack> void moveAll(E[] packs){
        for(E pack: packs){
            pack.move();
        }
    }

    public static void main(String[] args) {
        Dog boris = new Dog("boris");
        Dog dora = new Dog("dora");
        Dog sara = new Dog("Sara");
        Dog manuel = new Dog("Manuel");
        Sparrow jack = new Sparrow("Jack");

        /*Dog[] dogs = new Dog[2];
        dogs[0] = boris;
        dogs[1] = dora;*/
        Dog[] dogs = new Dog[]{boris, dora};
        Group<Dog> groupOfDogs = new Group<Dog>(dogs);
        // groupOfDogs.move();

        Dog[] animals = new Dog[]{boris, dora};

        Pack<Dog> dogPack1 = new Pack<Dog>(animals);
        // dogPack1.move();

        Dog[] dogs2 = new Dog[]{sara, manuel};
        Pack<Dog> dogPack2 = new Pack<Dog>(dogs2);

        Pack<Dog>[] packs = new Pack[]{dogPack1, dogPack2};

        moveAll(packs);
    }
}
