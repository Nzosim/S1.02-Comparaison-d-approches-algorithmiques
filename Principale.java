/**
 * Classe principale de la SAE 1.02
 * @author Etienne Andre
 * @since 2021-11-04
 *
 */


public class Principale{
	
	/**
	 * Exemple d'utilisation de LectureFichier et remplissage d'une liste
	 * @author Etienne Andre
	 */
	public static void remplir_liste(ListeTriee liste, String nom_fichier){
		LectureFichier lf = new LectureFichier(nom_fichier);
// 		
		String[] liste_noms = lf.lireFichier();
		for (String s : liste_noms) {
			liste.adjlisT(s);
		}
	}
	
	public static void main(String [] args){

		// lecture du fichier
		LectureFichier lf = new LectureFichier("noms10000.txt");	
		String[] liste_noms = lf.lireFichier();

		// creation d'une liste triee avec les 10000 noms
		Liste l = new ListeContigue(10000);
		// ListeTriee liste = new ListeTriee(l);
		// for (int i = 0 ; i < liste_noms.length ; i++){
		// 	liste.adjlisT(liste_noms[i]);
		// }



		// creation des elements 
		String[] elemDebut = {"A", "AA", "AAA", "AAAA", "AAAAA", "AAAAAA", "AAAAAAA", "AAAAAAAA", "AAAAAAAAA", "AAAAAAAAAA"};
		String[] elemFin = {"Z", "ZZ", "ZZZ", "ZZZZ", "ZZZZZ", "ZZZZZZ", "ZZZZZZZ", "ZZZZZZZZ", "ZZZZZZZZZ", "ZZZZZZZZZZ"};

		// initialisation des listes
		Liste listeContigueDebut = new ListeContigue(10010);
		Liste listeContigueFin = new ListeContigue(10010);
		Liste listeChaineeDebut = new ListeContigue(10010);
		Liste listeChaineeFin = new ListeContigue(10010);

		// initialisation des listes triee
		ListeTriee listeTrieeContigueDebut = new ListeTriee(listeContigueDebut);
		ListeTriee listeTrieeContigueFin = new ListeTriee(listeContigueFin);
		ListeTriee listeTrieeChaineeDebut = new ListeTriee(listeChaineeDebut);
		ListeTriee listeTrieeChaineeFin = new ListeTriee(listeChaineeFin);

		// ajout des 10000 noms dans les listes
		for (int i = 0 ; i < liste_noms.length ; i++){
			listeTrieeContigueDebut.adjlisT(liste_noms[i]);
			listeTrieeContigueFin.adjlisT(liste_noms[i]);
			listeTrieeChaineeDebut.adjlisT(liste_noms[i]);
			listeTrieeChaineeFin.adjlisT(liste_noms[i]);
		}

		// calcul du temps pour inserer 10 chaines de caracteres au debut d'une liste contigue de 10000 noms
		long date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeContigueDebut.adjlisT(elemDebut[i]);
		}
		long date_fin = System.nanoTime();
		long duree = date_fin-date_debut;
		System.out.println("Temps ajout 10 chaines de caracteres au debut avec une liste contigue : "+duree+" nanosecondes");

		// calcul du temps pour inserer 10 chaines de caracteres au debut d'une liste chainee de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeChaineeDebut.adjlisT(elemDebut[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps ajout 10 chaines de caracteres au debut avec une liste chainee : "+duree+" nanosecondes");

		// calcul du temps pour inserer 10 chaines de caracteres a la fin d'une liste contigue de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeContigueFin.adjlisT(elemFin[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps ajout 10 chaines de caracteres a la fin avec une liste contigue : "+duree+" nanosecondes");

		// calcul du temps pour inserer 10 chaines de caracteres a la fin d'une liste chainee de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeChaineeFin.adjlisT(elemFin[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps ajout 10 chaines de caracteres a la fin avec une liste chainee : "+duree+" nanosecondes");




		// calcul du temps pour supprimer 10 chaines de caracteres au debut d'une liste contigue de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeContigueDebut.suplisT(elemDebut[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps suppression 10 chaines de caracteres au debut avec une liste contigue : "+duree+" nanosecondes");

		// calcul du temps pour supprimer 10 chaines de caracteres au debut d'une liste chainee de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 0 ; i < 10 ; i++){
			listeTrieeChaineeDebut.suplisT(elemDebut[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps suppression 10 chaines de caracteres au debut avec une liste chainee : "+duree+" nanosecondes");

		// calcul du temps pour supprimer 10 chaines de caracteres a la fin d'une liste contigue de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 9 ; i >= 0 ; i--){
			listeTrieeContigueFin.suplisT(elemFin[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps suppression 10 chaines de caracteres au debut avec une liste contigue : "+duree+" nanosecondes");

		// calcul du temps pour supprimer 10 chaines de caracteres a la fin d'une liste chainee de 10000 noms
		date_debut = System.nanoTime();
		for (int i = 9 ; i >= 0 ; i--){
			listeTrieeChaineeFin.suplisT(elemFin[i]);
		}
		date_fin = System.nanoTime();
		duree = date_fin-date_debut;
		System.out.println("Temps suppression 10 chaines de caracteres au debut avec une liste chainee : "+duree+" nanosecondes");
	}
}
