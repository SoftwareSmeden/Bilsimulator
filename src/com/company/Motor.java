package com.company;

public class Motor {

    private boolean tænding;
    private double antalOmdrejninger;
    private double speeder;

    private int antalCylindere;
    private int hestekræfter;
    private String brændstof;


    public String toString(){
        return    "Antal Cylindere: " + antalCylindere + " Cyl." + "\n"
                + "Hestekræfter: " + hestekræfter + "HK" + "\n"
                + "Brændstof: " + brændstof;
    }

    //Default constructor
    public Motor(){
        this.antalCylindere = 0;
        this.hestekræfter = 0;
        this.brændstof = "Ukendt";
    }

    public Motor(int antalCylindere, int hestekræfter, String brændstof){
        this.antalCylindere = antalCylindere;
        this.hestekræfter = hestekræfter;
        this.brændstof = brændstof;
    }

    //Getters og Setters:
    //Tænding
    public boolean isTænding() {
        return tænding;
    }
    public void setTænding(boolean tænding) {
        this.tænding = tænding;
    }

    //Antal omdrejninger
    public double getAntalOmdrejninger() {
        return antalOmdrejninger;
    }
    public void setAntalOmdrejninger(double antalOmdrejninger) {
        this.antalOmdrejninger = antalOmdrejninger;
    }

    //Acceleration
    public double getSpeeder() {
        return speeder;
    }
    public void setSpeeder(double speeder) {
        this.speeder = speeder;
    }
}
