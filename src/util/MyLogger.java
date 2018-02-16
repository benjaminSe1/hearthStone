package util;



public class MyLogger {
    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void info(String message) {
        System.out.println(sdf.format(Calendar.getInstance().getTime()) + " INFO : " + message);
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
