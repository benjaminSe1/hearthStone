package util;

public class MyScanner {

    public static int getInt(java.util.Scanner sc, int max) {
        MyLogger.jeu("Entrez un nombre entre 1 et " + max);
        int res = -1;
        while (true) {
            while (!sc.hasNextInt()) {
                MyLogger.jeu("Erreur, entrez un NOMBRE entre 1 et " + max);
                sc.nextLine(); //si c'est pas un int on va à la ligne l'après
            }
            res = sc.nextInt();
            if (res >= 1 && res <= max) {
                break;
            }
            MyLogger.jeu("nombre invalide, entrez un nombre entre 1 et " + max);
        }
        return res;
    }

    public static String getString(java.util.Scanner sc) {
        String res = "";
        while (true) {
            while (!sc.hasNext()) {
                MyLogger.jeu("Erreur, veuillez entrer une valeur valide");
                sc.nextLine(); //si c'est pas un String on va à la ligne d'après
            }
            res = sc.next();
            if (res != null && !res.equals("")) {
                break;
            }
            MyLogger.jeu("Veuillez entrer une valeur valide");
        }
        return res;
    }

}
