package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Loger {
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public static void info(String message) {
        line();
        System.out.println(sdf.format(Calendar.getInstance().getTime()) + " INFO : "+message);
        line();
    }
	
	public static void error(String message) {
        line();
        System.out.println(sdf.format(Calendar.getInstance().getTime()) + " ERROR : " + message);
        line();
    }
	
	public static void jeu(String message) {
        line();
        System.out.println("JEU : " + message);
        line();
    }
	
	public static void vide(){
		System.out.println("\n");
	}
	
	public static void line(){
		vide();
		System.out.println("---------------------------------------------");
		vide();
	}
}
