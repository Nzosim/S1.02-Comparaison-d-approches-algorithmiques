/**
 * classe Principale 
 */
public class Principale{
	public static void main(String [] args){

		LectureFichier lf = new LectureFichier("noms10000.txt"); // fichier à lire
		String[] liste_noms = lf.lireFichier();

		int taille = (args.length!=0 ? Integer.parseInt(args[0]) : 10000) + 10; // taille de la liste en fonction de args[0]

		/**
		 * creation d'une liste triee avec une chaine contigue et d'une liste triee avec une liste chainee
		 * de la taile "taille"
		 * */ 
		Liste lCo = new ListeContigue(taille);
		Liste lCh = new ListeContigue(taille);
		ListeTriee listeContigue = new ListeTriee(lCo);
		ListeTriee listeChainee = new ListeTriee(lCh);
		for (int i = 0 ; i < Integer.parseInt(args[0]) ; i++){
			listeContigue.adjlisT(liste_noms[i]);
			listeChainee.adjlisT(liste_noms[i]);
		}
		
		/**
		 * element à ajouter en debut ou fin de liste
		 */
		String[] elemDebut = {"A", "AA", "AAA", "AAAA", "AAAAA", "AAAAAA", "AAAAAAA", "AAAAAAAA", "AAAAAAAAA", "AAAAAAAAAA"};
		String[] elemFin = {"Z", "ZZ", "ZZZ", "ZZZZ", "ZZZZZ", "ZZZZZZ", "ZZZZZZZ", "ZZZZZZZZ", "ZZZZZZZZZ", "ZZZZZZZZZZ"};

		CalculTime cT = new CalculTime(); // creation de la classe calcul

		int nbrTest = args.length<2?100:Integer.parseInt(args[1]); // nombre de test pour calculer la moyenne

		/**
		 * test ajout de 10 noms en debut et fin de liste pour une liste contigue et une liste chainee 
		 */
		System.out.println("\n"+cT.TempsAjout(10, listeContigue, listeChainee, elemDebut, nbrTest, taille));
		System.out.println(cT.TempsAjout(10, listeContigue, listeChainee, elemFin, nbrTest, taille));

		/**
		 * test suppression de 10 noms en debut et fin de liste pour une liste contigue et une liste chainee 
		 */
		System.out.println("\n"+cT.TempsSuppr(10, listeContigue, listeChainee, true, nbrTest, taille));
		System.out.println(cT.TempsSuppr(10, listeContigue, listeChainee, false, nbrTest, taille));

		/**
		 * test présence de 10 noms en debut et fin de liste pour une liste contigue et une liste chainee 
		 */
		System.out.println("\n"+cT.TempsMem(10, listeContigue, listeChainee, true, nbrTest, taille));
		System.out.println(cT.TempsMem(10, listeContigue, listeChainee, false, nbrTest, taille)+"\n");

	}
}