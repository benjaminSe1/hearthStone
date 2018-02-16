package util;


public class MyLogger {

    /**
     * Méthode du Logger permettant d'afficher des informations dans le terminal
     * @param message - Le message
     */
    public static void info(String message) {
        System.out.println(" INFO : " + message);
    }

    /**
     * Méthode du Logger permettant d'afficher des erreurs dans le terminal
     * @param message - L'erreur
     */
    public static void error(String message) {
        System.out.println(" ERROR : " + message);
    }

    /**
     * Méthode du Logger permettant d'afficher des informations sur le jeu dans le terminal
     * @param message - Le message
     */
    public static void game(String message) {
        System.out.println("-- " + message);
    }

    public static void emptyStdOut() {
        System.out.println("");
    }

    /**
     * Méthode du Logger permettant d'afficher une ligne dans le terminal
     */
    public static void line() {
        System.out.println("--------------------------------------------------");
        emptyStdOut();
    }

    /**
     * Méthode du Logger permettant d'afficher le message de changement de joueur
     */
    public static void switchPlayer() {
        emptyStdOut();
        System.out.println("-------------------------Changement De joueur-------------------------");
        emptyStdOut();
    }
}
