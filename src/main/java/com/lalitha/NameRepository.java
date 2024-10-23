package com.lalitha;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NameRepository {
    private static String[] names = {};

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("Size of array initially: "+getSize());

        String[] contacts = {"Lalitha Ogireddy","Sayana Surendran","Valerii Borisenko","Imad kassar"};
        setNames(contacts);
        System.out.println("----------------------------------------------------");
        System.out.println("Size of array after setNames: "+getSize());
        System.out.println("The array is : "+Arrays.toString(findAll()));
        System.out.println("----------------------------------------------------");

        System.out.println("Clearing the array..");
        clear();
        System.out.println("Size of array after clearing :"+getSize());

        contacts = Arrays.copyOf(contacts,2);
        contacts[0] = "Mehrdad Javan";
        contacts[1] = "Marcus Gudmundsen";
        setNames(contacts);
        System.out.println("----------------------------------------------------");
        System.out.println("Size of array after setNames: "+getSize());
        System.out.println("The array is : "+Arrays.toString(findAll()));
        System.out.println("----------------------------------------------------");

        System.out.println("Finding Mehrdad Javan is present in array : "+find("Mehrdad Javan"));
        System.out.println("Finding Alex Nolan is present in array : "+find("Alex Nolan"));

        System.out.println("----------------------------------------------------");
        System.out.println("Is new name (\"Alex Nolan\") added :"+add("Alex Nolan"));
        System.out.println("----------------------------------------------------");
        System.out.println("Final  array is : "+Arrays.toString(findAll()));

    }

    public static int getSize(){
        return names.length;
    }

    public static void setNames(String[] names) {
        NameRepository.names = Arrays.copyOf(names,names.length);
    }

    public static void clear() {
        names = new String[0];
    }

    public static String[] findAll(){
        String[] allNames = Arrays.copyOf(names,names.length);
        return allNames;
    }

    public static String find(final String fullName){
         for(String name : names){
             if(name.equals(fullName)){
                 return name;
             }
         }
         return null;
    }

    public static boolean add(final String fullName){
        String name = find(fullName);
        if(name==null){
            names = Arrays.copyOf(names,names.length+1);
            names[names.length-1] = fullName;
            return true;
        }
        return false;
    }

}