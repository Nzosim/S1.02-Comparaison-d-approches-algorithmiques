import java.util.Random;

/**
 * classe NomAleatoire qui permet de créer une liste de nom aléatoire dans un fichier texte
 */
public class NomAleatoire{
    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();
        EcritureFichier ef = new EcritureFichier("nomsAleatoire.txt"); // fichier dans lequel écrire

        ef.ouvrirFichier(); // ouverture du fichier

        for(int i = 0; i< Integer.parseInt(args[0]); i++){
            int tailleNom = random.nextInt(15 + 1) + 1; // nombre aleatoire entre 1 et 15 permet de choisir une taille pour le nom
            String nom = "";
            for(int j = 0; j< tailleNom; j++){
                char lettre = alphabet.charAt(random.nextInt(25 + 0) + 0); // nombre aleatoire entre 0 et 25 permet de choisir une lettre dans le String alphabet
                nom+=lettre;
            }
            ef.ecrireFichier(nom); // permet d'écrire ce que contient la variable nom dans le fichier
        }

        ef.fermerFichier(); // fermeture et sauvegarde du fichier

    }
}