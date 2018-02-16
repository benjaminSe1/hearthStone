package util;



public class MyLogger {

    public static void info(String message) {
        System.out.println(" INFO : " + message);
    }

    public static void error(String message) {
        System.out.println(" ERROR : " + message);
    }

    public static void game(String message) {
        System.out.println("-- " + message);
    }

    public static void emptyStdOut() {
        System.out.println("");
    }

    public static void line() {
        System.out.println("--------------------------------------------------");
        emptyStdOut();
    }

    public static void switchPlayer() {
        emptyStdOut();
        System.out.println("-------------------------Changement De joueur-------------------------");
        emptyStdOut();
    }
}
