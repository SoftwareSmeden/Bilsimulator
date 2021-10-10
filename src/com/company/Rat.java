package com.company;

public class Rat {

    private int drejRatVenstre;
    private int drejRatHøjre;
    private boolean ratLås;
    private boolean horn;


    //Default constructor
    Rat(){
        this.drejRatVenstre = 0;
        this.drejRatHøjre = 0;
        this.horn = false;
    }


    //Getters og Setters:
    //Drej til venstre
    public int getDrejRatVenstre() {
        return drejRatVenstre;
    }
    public void setDrejRatVenstre(int drejRatVenstre) {
        this.drejRatVenstre = drejRatVenstre;
    }

    //Drej til højre
    public int getDrejRatHøjre() {
        return drejRatHøjre;
    }
    public void setDrejRatHøjre(int drejRatHøjre) {
        this.drejRatHøjre = drejRatHøjre;
    }

    //Ratlås
    public boolean isRatLås() {
        return ratLås;
    }
    public void setRatLås(boolean ratLås) {
        this.ratLås = ratLås;
    }

    //Horn
    public boolean isHorn() {
        return horn;
    }
    public void setHorn(boolean horn) {
        this.horn = horn;
    }
}
