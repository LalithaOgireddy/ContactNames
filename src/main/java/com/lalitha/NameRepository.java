package com.lalitha;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = {};

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

    public static String[] findByFirstName(final String firstName){
        String[] resultArr = new String[0];
        for(String name : names){
            String[] split = name.split(" ");
            if(split[0].equals(firstName)){
                resultArr=extendArray(name,resultArr);
            }
        }
        return resultArr;
    }

    public static String[] findByLastName(final String lastName){
        String[] resultArr = new String[0];
        for(String name : names){
            String[] split = name.split(" ");
            if(split[1].equals(lastName)){
                resultArr=extendArray(name,resultArr);
            }
        }
        return resultArr;
    }

    public static String[] extendArray(String element,String[] arr){
        String[] newArr = Arrays.copyOf(arr,arr.length+1);
        newArr[arr.length] = element;
        return newArr;
    }

    public static boolean update(final String original, final String updatedName){
        boolean isUpdated=false;
        for(String name : names){
            if(name.equals(updatedName)){
                isUpdated=false;
                return isUpdated;
            }
        }
        for(int i=0;i<names.length;i++){
            if(names[i].equals(original)){
                names[i] = updatedName;
                isUpdated=true;
            }
        }
        return isUpdated;
    }

    public static boolean remove(final String fullName){
        String[] newArray;
        String foundString = find(fullName);
        if(foundString==null){
            return false;
        } else {
            newArray = new String[names.length-1];
            int j=0;
            for(int i=0;i<names.length;i++){
                if(!(names[i].equals(fullName))){
                    newArray[j] = names[i];
                    j++;
                }
            }
        }
        names=newArray;
        return true;
    }

}