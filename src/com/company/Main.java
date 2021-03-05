package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Officer officer1 = new Officer("Ivo", "Domijan", 1011, 5);
        Officer officer2 = new Officer("Linda", "Domijan", 1012, 6);
        Officer officer3 = new Officer("Vigo", "Domijan", 1013, 7);
        Officer officer4 = new Officer("John", "Smith", 1015, 5);
        Officer officer5 = new Officer("Jim", "Smith2", 1016, 2);
        Officer officer6 = new Officer("Jane", "Smith3", 1017, 6);
        Officer officer7 = new Officer("June", "Smith4", 1018, 5);

        District district1 = new District("A", "Riga", 1, new Officer[0]);
        District district2 = new District("B", "Tukums", 2, new Officer[0]);

        Lawyer lawyer1 = new Lawyer("Jānis", "Bērziņš", 32, 100);
        Lawyer lawyer2 = new Lawyer("Līga", "Ozoliņa", 31, 45);
        Lawyer lawyer3 = new Lawyer("Zane", "Zaķe", 33, 500);

        district1.addNewOfficer(officer1);
        district1.addNewOfficer(officer2);
        district1.addNewOfficer(officer3);

        district2.addNewOfficer(officer4);
        district2.addNewOfficer(officer5);
        district2.addNewOfficer(officer6);
        district2.addNewOfficer(officer7);

        ArrayList<Lawyer> lawyerArray = new ArrayList<>();
        lawyerArray.add(lawyer1);
        lawyerArray.add(lawyer2);
        lawyerArray.add(lawyer3);

        System.out.println("Lawyers have solved " + numberOfCrimeSolved(lawyerArray) + " crimes.");

        System.out.println("This lawyer has helped to solve most crimes: " + whichLawyerBetter(lawyerArray).stream().
                map(Lawyer::getName).collect(Collectors.joining(", ")));
    }

    public static int numberOfCrimeSolved(ArrayList<Lawyer> lawyerArray) {
        int numberOfCrimeSolved = 0;
        for (Lawyer lawyer : lawyerArray) {
            numberOfCrimeSolved = numberOfCrimeSolved + lawyer.getHelpedInCrimesSolving();
        }
        return numberOfCrimeSolved;
    }

    public static ArrayList<Lawyer> whichLawyerBetter(ArrayList<Lawyer> lawyerArray) {
        ArrayList<Lawyer> bestLawyers = new ArrayList<>(2);
        bestLawyers.add(lawyerArray.get(0));
        for (int i = 1; i < lawyerArray.size(); i++) {
            Lawyer currentLawyer = lawyerArray.get(i);
            if (currentLawyer.getHelpedInCrimesSolving() ==
                    bestLawyers.get(0).getHelpedInCrimesSolving()) {
                bestLawyers.add(currentLawyer);
            } else if (currentLawyer.getHelpedInCrimesSolving() >
                    bestLawyers.get(0).getHelpedInCrimesSolving()) {
                bestLawyers.clear();
                bestLawyers.add(currentLawyer);
            }
        } return bestLawyers;
    }
}