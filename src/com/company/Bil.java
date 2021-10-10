package com.company;

import java.util.Random;

public class Bil {

    private String mærke;
    private String model;
    private int stelnummer;
    private int vægt;
    private int antalDøre;
    private int topfart;
    private double hastighed;
    private String drivendeAksel;

    private Motor motor = new Motor();
    private Bremse brems = new Bremse();
    private Hjul hjul = new Hjul();
    private Rat rat = new Rat();


    public String toString(){

        return "Mærke: " + mærke + "\n"
             + "Model: " + model + "\n"
             + "Stelnummer: " + stelnummer + "\n"
             + "Vægt: " + vægt + " Kg" + "\n"
             + "Antal døre: " + antalDøre + "\n"
             + "Topfart: " + topfart + " km/t" + "\n"
             + "Drivlinje: " + drivendeAksel;

    }
    //Default constructor
    public Bil(){
        this.mærke = "Ukendt";
        this.model = "Ukendt";
        this.stelnummer = 0;
        this.vægt = 0;
        this.antalDøre = 0;
        this.topfart = 0;
        this.hastighed = 0;
        this.drivendeAksel = "Ukendt";
    }

    public Bil(String mærke, String model, int vægt, int antalDøre, int topFart, int hestekræfter, String drivendeAksel){

        Random random = new Random();
        this.mærke = mærke;
        this.model = model;
        this.stelnummer = random.nextInt(99999999);
        this.vægt = vægt;
        this.antalDøre = antalDøre;
        this.topfart = topFart;
        this.drivendeAksel = drivendeAksel;
    }

    //Alle metoderne:
    //Tænding
    public void tænd(){
        if (!motor.isTænding() && motor.getAntalOmdrejninger() <= 1000) {
            motor.setTænding(true);
            System.out.println("Køretøjet er tændt!");
        }else{
            System.out.println("Køretøjet er allerede tændt!");
        }
    }
    public void sluk(){
        if (motor.isTænding()) {
            motor.setSpeeder(0);
            motor.setTænding(false);
            System.out.println("Køretøjet er slukket!");
            System.out.println("Husk at trække håndbremsen!");
        }else{
            System.out.println("Bilen er allerede slukket!");
        }
    }

    //Omdrejninger
    public void omdrejningerTomgang(){
        motor.setSpeeder(0);

        if (motor.getAntalOmdrejninger() < 1000 && motor.getSpeeder() == 0) {
            for (int i = 0; i <= 1000; i+=200) {
                motor.setAntalOmdrejninger(i);
                System.out.println("Omdrejninger: " + (int)motor.getAntalOmdrejninger() + " omdr/min.");
            }
        }
    }
    public void omdrejninger(){
        motor.setSpeeder(0);

        if (motor.getAntalOmdrejninger() >= 1000 && motor.getSpeeder() == 0) {
            for (double i = motor.getAntalOmdrejninger(); i >= 0; i -= 200) {
                motor.setAntalOmdrejninger(i);
                System.out.println("Omdr/min: " + (int)motor.getAntalOmdrejninger());
            }
        }
    }

    //Acceleration
    public void acceleration(){
        brems.setFodBremse(0);

        if (!brems.isHåndbremse() && motor.getAntalOmdrejninger() >= 1000 && motor.getAntalOmdrejninger() < 7000 && motor.getSpeeder() < 100 && getHastighed() < 80){

            double øgerAcc = motor.getSpeeder();
            double øgerOmdr = motor.getAntalOmdrejninger();
            double øgerHast = getHastighed();
            motor.setSpeeder(øgerAcc + 1.25);
            motor.setAntalOmdrejninger(øgerOmdr + 75);
            setHastighed(øgerHast + 1);

            System.out.println("Speedertryk: " + motor.getSpeeder() + "%" + ", Hastighed: " + (int)getHastighed() + "km/t" + ", Omdr/min: " + (int)motor.getAntalOmdrejninger());
        }
        else if (!brems.isHåndbremse() && getHastighed() <= 80 && motor.getAntalOmdrejninger() <= 7000 && motor.getAntalOmdrejninger() >= 1000) {
            System.out.println("Max hastighed og omdrejninger er opnået!");
        }
        else if (motor.getAntalOmdrejninger() < 1000){
            System.out.println("Tænd bilen før du kan accelerer!");
        }
        else{
            System.out.println("Slip håndbremsen først!");
        }
    }

    public void fartPilot(int hastighed){

        if (motor.getAntalOmdrejninger() >= 1000 && motor.getAntalOmdrejninger() <= 7000 && motor.isTænding() && !brems.isHåndbremse() && hastighed <= 80 && hastighed >= 30 && getHastighed() >= 30) {
            setHastighed(hastighed);
            motor.setAntalOmdrejninger(1000 + (hastighed * 75));
            motor.setSpeeder(hastighed * 1.25);
            System.out.println("Fartpilot sat til: " + (int)getHastighed() + "km/t" + ", Omdr/min: " + (int)motor.getAntalOmdrejninger());
        }
        else if (brems.isHåndbremse()){
            System.out.println("Du kan IKKE bruge fartpiloten når håndbremsen er trukket!");
        }
        else if (!motor.isTænding()){
            System.out.println("Du kan IKKE bruge fartpiloten når bilen er slukket!");
        }
        else if (hastighed > 80){
            System.out.println("Den maksimale hastighed kan KUN sættes til 80km/t!");
        }
        else if (getHastighed() <= 30){
            System.out.println("Farpilot kan IKKE aktiveres under 30km/t!");
        }
    }

    //Fodbremse
    public void bremser(){
        motor.setSpeeder(0);
        if (!brems.isHåndbremse() && motor.getAntalOmdrejninger() > 1000) {
                brems.setFodBremse(brems.getFodBremse() + 1.25);
                motor.setAntalOmdrejninger(motor.getAntalOmdrejninger() - 75);
                setHastighed(getHastighed() - 1);
                System.out.println("Bremsetryk: " + brems.getFodBremse() + "%" + ", Hastighed: " + (int)getHastighed() + "km/t" + ", Omdr/min: " + (int)motor.getAntalOmdrejninger());
        }
        else if (motor.getAntalOmdrejninger() == 1000 && brems.isHåndbremse()){
            System.out.println("Ingen grund til at bremse. Køretøjet holder i tomgang og håndbremsen er allerede trukket!");
        }
        else if(!brems.isHåndbremse() && !motor.isTænding()){
            System.out.println("Bilen er slukket, måske træk håndbremsen?");
        }
        else if (brems.isHåndbremse() && !motor.isTænding()){
            System.out.println("Ingen grund til at bremse, bilen er slukket og håndbremsen er jo allerede trukket!");
        }else{
            System.out.println("Bilen står i tomgang!");
        }
    }

    public void bremserHårdt(){
        motor.setSpeeder(0);

        while (motor.getSpeeder() == 0 && !brems.isHåndbremse() && motor.getAntalOmdrejninger() > 1000){
                brems.setFodBremse(brems.getFodBremse() + 6.25);
                motor.setAntalOmdrejninger(motor.getAntalOmdrejninger() - 375);
                setHastighed(getHastighed() - 5);
                System.out.println("Bremsetryk: " + brems.getFodBremse() + "%" + ", Hastighed: " + (int)getHastighed() + "km/t" + ", Omdr/min: " + (int)motor.getAntalOmdrejninger());
        }
        if(motor.getAntalOmdrejninger() < 1000 && motor.isTænding()) {
                System.out.println("\n" + "Du bremsede for hårdt og bilen gik i stå!");
                System.out.println("Tænd bilen igen og forsæt!");
                setHastighed(0);
                motor.setTænding(false);
                motor.setAntalOmdrejninger(0);
        }
        else if (motor.getAntalOmdrejninger() == 1000 && brems.isHåndbremse()){
                System.out.println("Ingen grund til at bremse. Køretøjet holder i tomgang og håndbremsen er allerede trukket!");
        }
        else if(!brems.isHåndbremse() && !motor.isTænding()){
                System.out.println("Bilen er slukket, måske træk håndbremsen eller start bilen igen?");
        }
        else if (brems.isHåndbremse() && !motor.isTænding()){
                System.out.println("Ingen grund til at bremse, bilen er slukket og håndbremsen er jo allerede trukket!");
        }else if (!motor.isTænding()){
                System.out.println("Tænd bilen!");
        }else{
                System.out.println("Bilen står i tomgang!");
        }
    }

    //Håndbremse
    public void håndbremseTrukket(){

        if(motor.getAntalOmdrejninger() <= 1000) {
            brems.setHåndbremse(true);
            System.out.println("Håndbremse trukket!");
        }
        else if(motor.getSpeeder() > 0){
            System.out.println("Du kan IKKE trække håndbremsen imens du accelerer!");
        }
        else{
            System.out.println("Håndbremsen er allerede trukket!");
        }
    }

    public void håndbremseSluppet(){

        if (brems.isHåndbremse()){
            brems.setHåndbremse(false);
            System.out.println("Håndbremsen er sluppet!");
        }
        else{
            System.out.println("Håndbremsen er allerede sluppet!");
        }
    }

    //Rattet
    public void drejVenstre(){

        if (motor.isTænding() &&  rat.getDrejRatHøjre() == 0 && rat.getDrejRatVenstre() <= 0 && rat.getDrejRatVenstre() >= -855){

            double graderHjul = hjul.getDrejHjulVenstre();
            hjul.setDrejHjulVenstre(graderHjul - 3.75);
            int graderRat = rat.getDrejRatVenstre();
            rat.setDrejRatVenstre(graderRat - 45);
            System.out.println("Rattet roterer mod venstre: " + rat.getDrejRatVenstre() + "°" + ", Hjul: " + hjul.getDrejHjulVenstre() + "°");

        }else if (motor.isTænding() && rat.getDrejRatHøjre() > 0 && hjul.getDrejHjulHøjre() > 0){

            rat.setDrejRatHøjre(rat.getDrejRatHøjre() - 45);
            hjul.setDrejHjulHøjre(hjul.getDrejHjulHøjre() - 3.75);
            System.out.println("Rattet roterer mod venstre: "+ rat.getDrejRatHøjre() + "°" + ", Hjul: " + hjul.getDrejHjulHøjre()  + "°");
        }
        else if (!motor.isTænding()) {
            System.out.println("Ratlås er slået til. Tænd bilen for at dreje!");
        }
        else{
            System.out.println("Det er ikke muligt at dreje mere!");
        }
    }

    public void ratHorn(){

        if (motor.isTænding()){
            System.out.println("Dyt!");
        }
        else if (!motor.isTænding()){
            System.out.println("Tænd bilen for at bruge hornet!");
        }
    }

    public void drejHøjre(){

        if (motor.isTænding() && rat.getDrejRatVenstre() == 0 && rat.getDrejRatHøjre() >= 0 && rat.getDrejRatHøjre() <= 855){

            double graderHjul = hjul.getDrejHjulHøjre();
            hjul.setDrejHjulHøjre(graderHjul + 3.75);
            int graderRat = rat.getDrejRatHøjre();
            rat.setDrejRatHøjre(graderRat + 45);
            System.out.println("Rattet roterer mod højre: " + rat.getDrejRatHøjre() + "°" + ", Hjul: " + hjul.getDrejHjulHøjre() + "°");

        }else if (motor.isTænding() && rat.getDrejRatVenstre() < 0 && hjul.getDrejHjulVenstre() < 0){

            rat.setDrejRatVenstre(rat.getDrejRatVenstre() + 45);
            hjul.setDrejHjulVenstre(hjul.getDrejHjulVenstre() + 3.75);
            System.out.println("Rattet roterer mod højre: "+ rat.getDrejRatVenstre() + "°" + ", Hjul: " + hjul.getDrejHjulVenstre() + "°");
        }
        else if (!motor.isTænding()) {
            System.out.println("Ratlås er slået til. Tænd bilen for at dreje!");
        }
        else{
            System.out.println("Det er ikke muligt at dreje mere!");
        }
    }

    //Ratlås
    public void ratLås(){

        if (!motor.isTænding()){
            rat.setRatLås(true);
        }
        else if (motor.isTænding()){
            rat.setRatLås(false);
        }
    }

    //Setters og getters:
    //Mærke
    public String getMærke() {
        return mærke;
    }
    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    //Model
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    //Stelnummer
    public int getStelnummer() {
        return stelnummer;
    }
    public void setStelnummer(int stelnummer) {
        this.stelnummer = stelnummer;
    }

    //Vægt
    public int getVægt() {
        return vægt;
    }
    public void setVægt(int vægt) {
        this.vægt = vægt;
    }

    //Antal døre
    public int getAntalDøre() {
        return antalDøre;
    }
    public void setAntalDøre(int antalDøre) {
        this.antalDøre = antalDøre;
    }

    //Topfart
    public int getTopfart() {
        return topfart;
    }
    public void setTopfart(int hastighed) {
        this.topfart = hastighed;
    }

    //Hastighed
    public double getHastighed() {
        return hastighed;
    }
    public void setHastighed(double hastighed) {
        this.hastighed = hastighed;
    }

}

