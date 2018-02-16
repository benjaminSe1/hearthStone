package util;

public class MyScanner {

    public static int getInt(Scanner sc, int limit) {
        MyLogger.game("Entrez un nombre entre 1 et " + limit);
        int result;
        while (true) {
            while (!sc.hasNextInt()) {
                MyLogger.game("Erreur, veuillez entrer un nombre entre 1 et " + limit);
                sc.nextLine(); //si c'est pas un int on va à la ligne l'après
            }
            result = sc.nextInt();
            //Si le résultat convient on break et on return result
            if (result >= 1 && result <= limit) {
                break;
            }
            MyLogger.game("nombre invalide, entrez un nombre entre 1 et " + limit);
        }
        return result;
    }

    public static String getString(java.util.Scanner sc) {
        String result;
        while (true) {
            while (!sc.hasNext()) {
                MyLogger.game("Erreur, veuillez entrer une valeur valide");
                sc.nextLine(); //si c'est pas un String on va à la ligne d'après
            }
            result = sc.next();
            //Si le résultat convient on break et on return result
            if (result != null && !result.equals("")) {
                break;
            }
            MyLogger.game("Veuillez entrer une valeur valide");
        }
        return result;
    }

}
