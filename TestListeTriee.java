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
	public void test_01_constructeur(){

		/** creation d'une liste triee vide
		 */
		ListeTriee lt = new ListeTriee();

		/**verification de la liste vide
		 */
		 int tete = lc.tete();
		assertEquals("la liste devrait etre vide", true, lc.finliste(tete));
		
		)
	}

}
