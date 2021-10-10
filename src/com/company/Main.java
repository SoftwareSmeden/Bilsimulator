package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Bilsimulator Øvelse.

        //Objekterne
        Bil toyotaSupra = new Bil("Toyota", "Supra", 1410, 2, 310,6,"Baghjulstrukket");
        System.out.println("\n" + "Køretøjets info: " + "\n" + toyotaSupra + "\n");

        Motor motorDetaljer = new Motor(6,330,"Benzin");
        System.out.println("Motor: " + "\n" + motorDetaljer + "\n");

        //Kommando listen
        String kommandoListe = "Sådan styrer du køretøjet: " + "\n"
                             + "Kommando:    -Info:" + "\n"
                             + "tænd         -Starter bilen" + "\n"
                             + "sluk         -Slukker for bilen" + "\n"
                             + "spdt         -Forøger bilens acceleration" + "\n"
                             + "fp           -Sætter fartpiloten" + "\n"
                             + "brems        -Bremser bilen" + "\n"
                             + "BREMS        -bremser bilen hurtigt" + "\n"
                             + "trækh        -Trækker håndbremsen" + "\n"
                             + "sliph        -Slipper håndbremsen" + "\n"
                             + "dv           -Bilen drejer mod venstre" + "\n"
                             + "dh           -Bilen drejer mod højre" + "\n"
                             + "dyt          -Hornet bliver aktiveret" + "\n"
                             + "help         -Viser kommandolisten" + "\n"
                             + "quit         -Lukker programmet ned";
                             System.out.println(kommandoListe);

        System.out.println("\n" + "Skriv 'help' hvis du vil se kommando listen undervejs!");
        System.out.println("\n" + "Hvis du vil starte og køre i bilen, skriv 'tænd' eller 'quit' for exit? (De to ymboler '' skal ikke skrives)");

        //Her starter bruger inputs:
        Scanner chauffør = new Scanner(System.in);
        while (chauffør.hasNextInt()) {
            chauffør.nextInt();
            System.err.println("Forkert! Prøv igen!");
        }
        boolean kørNu = true;
        while (kørNu) {
            String driver = chauffør.nextLine();
            switch (driver) {

                //Tændingssystem
                case "tænd" -> {
                    toyotaSupra.omdrejningerTomgang();
                    toyotaSupra.tænd();
                }
                case "sluk" -> {
                    toyotaSupra.omdrejninger();
                    toyotaSupra.sluk();
                }
                //Bremsesystem
                case "sliph" -> {
                    toyotaSupra.håndbremseSluppet();
                }
                case "trækh" -> {
                    toyotaSupra.håndbremseTrukket();
                }
                //Håndbremse
                case "brems" -> {
                    toyotaSupra.bremser();
                }
                case "BREMS" -> {
                    toyotaSupra.bremserHårdt();
                }

                //Acceleration
                case "spdt" -> {
                    toyotaSupra.acceleration();
                }

                //Fartpilot
                case "fp" -> {
                    System.out.println("Hvad skal farten sættes til?");
                    while (!chauffør.hasNextInt()) {
                        chauffør.next();
                        System.err.println("Forkert! Prøv igen!");
                    }
                    toyotaSupra.fartPilot(chauffør.nextInt());
                }

                //Rat og hjul
                case "dv" -> {
                    toyotaSupra.drejVenstre();
                }
                case "dh" -> {
                    toyotaSupra.drejHøjre();
                }

                //Rathorn
                case "dyt" -> {
                    toyotaSupra.ratHorn();
                }

                //Viser kommando listen
                case "help" -> {
                    System.out.println(kommandoListe);
                }

                //Lukker program
                case "quit" -> {
                    System.out.println("Programmet lukker ned!");
                    System.out.println("Tak for turen! Genstart, hvis du vil køre igen!");
                    kørNu = false;
                }
            }
        }
    }
}
