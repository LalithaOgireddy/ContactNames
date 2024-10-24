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
        int j=0;
        for(String name : names){
            if(name.startsWith(firstName)){
                j++;
            }
        }
        String[] resultArr = new String[j];
        j=0;
        for(String name : names){
            if(name.contains(firstName)){
                resultArr[j] = name;
                j++;
            }
        }
        return resultArr;
    }

    public static String[] findByLastName(final String lastName){
        int j=0;
        for(String name : names){
            if(name.endsWith(lastName)){
                j++;
            }
        }
        String[] resultArr = new String[j];
        j=0;
        for(String name : names){
            if(name.contains(lastName)){
                resultArr[j] = name;
                j++;
            }
        }
        return resultArr;
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