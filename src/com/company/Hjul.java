package com.company;

public class Hjul {

    private int antalHjul;
    private double drejHjulVenstre;
    private double drejHjulHøjre;

    //Default constructor
    Hjul(){
        this.antalHjul = 0;
        this.drejHjulVenstre = 0;
        this.drejHjulHøjre = 0;
    }


    //Getters og Setters:
    //Antal hjul
    public int getAntalHjul() {
        return antalHjul;
    }
    public void setAntalHjul(int antalHjul) {
        this.antalHjul = antalHjul;
    }

    //Drej til venstre
    public double getDrejHjulVenstre() {
        return drejHjulVenstre;
    }
    public void setDrejHjulVenstre(double drejHjulVenstre) {
        this.drejHjulVenstre = drejHjulVenstre;
    }

    //Drej til højre
    public double getDrejHjulHøjre() {
        return drejHjulHøjre;
    }
    public void setDrejHjulHøjre(double drejHjulHøjre) {
        this.drejHjulHøjre = drejHjulHøjre;
    }
}
