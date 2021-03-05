package com.company;

public class Officer extends Person{

    private int officerID;
    private int crimesSolved;

    public Officer(String name, String surname, int officerID,
                   int crimesSolved) {
        this.officerID = officerID;
        this.crimesSolved = crimesSolved;
        super.setName(name);
        super.setSurname(surname);

    }

    public Officer() {
    }

    public int getOfficerID() {
        return officerID;
    }

    public void setOfficerID(int officerID) {
        this.officerID = officerID;
    }

    public int getCrimesSolved() {
        return crimesSolved;
    }

    public void setCrimesSolved(int crimesSolved) {
        this.crimesSolved = crimesSolved;
    }

    public String toString() {
        return "{" + super.getName() + ", " + super.getSurname() + ", " + officerID + ", " + crimesSolved + '}';
    }

    public int calculatedLevel(int crimesSolved) {

        if (this.crimesSolved < 20)
            return 1;
        if (this.crimesSolved < 40)
            return 2;
        return 3;
    }
}
