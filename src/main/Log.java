package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void info(String message) {
        System.out.println(sdf.format(Calendar.getInstance().getTime()) + " INFO : " + message);
    }

    public static void error(String message) {
        System.out.println(sdf.format(Calendar.getInstance().getTime()) + " ERROR : " + message);
    }

    public static void jeu(String message) {
        System.out.println("-- " + message);
    }

    public static void vide() {
        System.out.println("");
    }

    public static void line() {
        System.out.println("--------------------------------------------------");
        vide();
    }

    public static void changementJoueur() {
        vide();
        System.out.println("-------------------------Changement De joueur-------------------------");
        vide();
    }
}
