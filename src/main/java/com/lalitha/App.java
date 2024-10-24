package com.lalitha;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("Size of array initially: "+NameRepository.getSize());

        String[] contacts = {"Lalitha Ogireddy","Sayana Surendran","Valerii Borisenko","Imad kassar"};
        NameRepository.setNames(contacts);
        System.out.println("----------------------------------------------------");
        System.out.println("Size of array after setNames: "+NameRepository.getSize());
        System.out.println("The array is : "+ Arrays.toString(NameRepository.findAll()));
        System.out.println("----------------------------------------------------");

        System.out.println("Clearing the array..");
        NameRepository.clear();
        System.out.println("Size of array after clearing :"+NameRepository.getSize());

        contacts = Arrays.copyOf(contacts,contacts.length+2);
        contacts[contacts.length-2] = "Lalitha Dinesh";
        contacts[contacts.length-1] = "Raghav Ogireddy";
        NameRepository.setNames(contacts);
        System.out.println("----------------------------------------------------");
        System.out.println("Size of array after setNames: "+NameRepository.getSize());
        System.out.println("The array is : "+Arrays.toString(NameRepository.findAll()));
        System.out.println("----------------------------------------------------");

        System.out.println("Finding Mehrdad Javan is present in array : "+NameRepository.find("Mehrdad Javan"));
        System.out.println("Finding Alex Nolan is present in array : "+NameRepository.find("Alex Nolan"));

        System.out.println("----------------------------------------------------");
        System.out.println("Is new name (\"Alex Nolan\") added :"+NameRepository.add("Alex Nolan"));
        //System.out.println("----------------------------------------------------");
        System.out.println("Final  array is : "+Arrays.toString(NameRepository.findAll()));

        System.out.println("----------------------------------------------------");
        String[] sameFName = NameRepository.findByFirstName("Lalitha");
        System.out.println("All the names with firstname as Lalitha: "+Arrays.toString(sameFName));

        System.out.println("----------------------------------------------------");
        String[] sameLName = NameRepository.findByLastName("Ogireddy");
        System.out.println("All the names with lastname as Ogireddy: "+Arrays.toString(sameLName));

        System.out.println("----------------------------------------------------");
        System.out.println("Is the name updated from Raghav Ogireddy to DSSR Ogireddy: "+NameRepository.update("Raghav Ogireddy","DSSR Ogireddy"));
        System.out.println("----------------------------------------------------");
        System.out.println("Is the name updated from Raghav Ogireddy to DSSR Ogireddy: "+NameRepository.update("Raghav Ogireddy","DSSR Ogireddy"));
        System.out.println("----------------------------------------------------");
        System.out.println("Is the name updated from Lalitha Ogireddy to Lalitha Dinesh: "+NameRepository.update("Lalitha Ogireddy","Lalitha Dinesh"));

        System.out.println("----------------------------------------------------");
        System.out.println("Name removed :"+NameRepository.remove("Alex Nolan"));
        System.out.println("Final  array is : "+Arrays.toString(NameRepository.findAll()));
    }
}
