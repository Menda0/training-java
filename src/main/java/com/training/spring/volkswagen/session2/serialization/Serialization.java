package com.training.spring.volkswagen.session2.serialization;

import java.io.*;

class Dog implements Serializable{
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(){
        System.out.println("The dog "+this.name+" eats raw steak");
    }
}

public class Serialization {

    public static void serializeDog(Dog d) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(d.getName()+".ser");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(d);
        objectOut.close();
        fileOut.close();
        System.out.println("The dog "+ d.getName()+" is serialized into the file "+d.getName()+".ser");
    }

    public static Dog deserializeDog(String dogName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(dogName+".ser");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        Dog d = (Dog) objectIn.readObject();
        fileIn.close();
        objectIn.close();
        return d;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog boris = new Dog("boris");

        serializeDog(boris);

        Dog cloneOfBoris = deserializeDog("boris");

        System.out.println("The clone dog name is "+cloneOfBoris.getName());
        System.out.println("The original dog name is "+boris.getName());
    }
}
