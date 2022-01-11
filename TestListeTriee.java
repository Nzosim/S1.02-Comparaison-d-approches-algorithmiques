import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe ListeTriee
 * fonctionne correctement
 */
public class TestListeTriee {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestListeTriee(), args);
	}
/** test du constructeur de liste triee
 */
	// public void test_01_constructeur(){

	// 	// creation d'une liste triee vide

	// 	ListeTriee lt = new ListeTriee(new ListeContigue(4));

	// 	//verification de la liste vide

	// 	int lt.liste.tete = lt.tete();
	// 	assertEquals("la liste devrait etre vide", true, lt.finliste(tete));
		
	// }


/** test de la methode adjlisT
 */	
	public void test_02_adjlisT(){
		
		// creation d'une liste triee
		ListeTriee lt = new ListeTriee(new ListeContigue(4));

		// verification 

		lt.adjlisT("eit");
		lt.adjlisT("d");
		lt.adjlisT("eia");
		lt.adjlisT("a");
		assertEquals("les elements doivent etre ajoutes et tries","a\nd\neia\neit", lt.toString());

	}

}
