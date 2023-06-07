//Author: Thomas Caneday
//Date: 4-21-2023
//Discrete Structures project computing Power Set, Cartesian Product, Union, Intersection, Difference, Complements of user input

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
//        Declare two sets
        Set<Integer> setS = new HashSet<Integer>();
        Set<Integer> setT = new HashSet<Integer>();
        Set<Integer> setUniversal = new HashSet<Integer>();
        for(int i = 1; i <= 100; i++) {
            setUniversal.add(i);
        }

        List arListS = new ArrayList<>();
        List arListT = new ArrayList<>();
        Scanner scannerS = new Scanner(System.in);
        Scanner scannerT = new Scanner(System.in);
        System.out.println("Enter first set (put spaces between and after, and end set of numbers with any character): ");

        while(scannerS.hasNextInt()) {
            int w = scannerS.nextInt();
            arListS.add(w);
        }
        System.out.println("Enter second set (put spaces between and after, and end set of numbers with any character): ");

        while(scannerT.hasNextInt()) {
            int q = scannerT.nextInt();
            arListT.add(q);
        }
        // System.out.println(numbers);
        setS.addAll(arListS);
        setT.addAll(arListT);
        System.out.println("Set S: " + setS);
        System.out.println("Set T: " + setT);


//        Power Set S
        List<Integer> listS = new ArrayList<Integer>(arListS);
        Object[] aSetS = listS.toArray();

        System.out.print("Power Set of S: ");

        long sizeSetS = (long) Math.pow(2, aSetS.length);

        for(int c = 0; c < sizeSetS; c++) {
            System.out.print("[");
            for(int j = 0; j < aSetS.length; j++) {
                if((c & (1 << j)) > 0) {
                    System.out.print(aSetS[j]);
                }

            }
            System.out.print("], ");
        }
        System.out.println();

//        Power Set T
        List<Integer> listT = new ArrayList<Integer>(arListT);
        Object[] aSetT = listT.toArray();

        System.out.print("Power Set of T: ");

        long sizeSetT = (long) Math.pow(2, aSetT.length);

        for(int c = 0; c < sizeSetT; c++) {
            System.out.print("[");
            for(int j = 0; j < aSetT.length; j++) {
//                Check whether next location is true
                if((c & (1 << j)) > 0) {
                    System.out.print(aSetT[j]);
                }

            }
            System.out.print("], ");
        }



//        Cartesian Product
        System.out.println();
        System.out.print("Cartesian Product: [");

        for(int i = 0; i < aSetS.length; i++) {
            for(int j = 0; j < aSetT.length; j++) {
                System.out.print("{" + aSetS[i] + ", " + aSetT[j] + "}, ");
            }
        }
        System.out.println();

//        Union
        Set<Integer> setUnion = new HashSet<Integer>(setS);
        setUnion.addAll(setT);
        System.out.println("Union: " + setUnion);

//        Intersection
        Set<Integer> setIntersection = new HashSet<Integer>(setS);
        setIntersection.retainAll(setT);
        System.out.println("Intersection: " + setIntersection);

//        Difference
        Set<Integer> setDifference = new HashSet<Integer>(setS);
        setDifference.removeAll(setT);
        System.out.println("Difference: " + setDifference);

//        Complements
        Set<Integer> setComplement = new HashSet<Integer>(setUniversal);
        setComplement.removeAll(setS);
        System.out.println("Complement of set S: " + setComplement);

        setComplement.clear();
        setComplement.addAll(setUniversal);

        setComplement.removeAll(setT);
        System.out.println("Complement of set T: " + setComplement);

    }

}