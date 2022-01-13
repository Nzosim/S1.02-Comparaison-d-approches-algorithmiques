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

	/** 
	 * test de la methode adjlisT avec une liste contigue et une liste chainee
	 */	
	public void test_01_adjlisT(){

		// creation des liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeContigue(4));

		// ajout des valeurs
		lco.adjlisT("eit");
		lco.adjlisT("d");
		lco.adjlisT("eia");
		lco.adjlisT("a");

		lch.adjlisT("eit");
		lch.adjlisT("d");
		lch.adjlisT("eia");
		lch.adjlisT("a");

		// vérifications
		String attendu = "a d eia eit";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lch.toString()));
	}

	/** 
	 * test de la methode adjlisT avec une liste contigue et une liste chainee
	 */	
	public void test_02_suplisT(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeContigue(4));

		// ajout des valeurs
		lco.adjlisT("eit");
		lco.adjlisT("d");
		lco.adjlisT("eia");
		lco.adjlisT("a");

		lch.adjlisT("eit");
		lch.adjlisT("d");
		lch.adjlisT("eia");
		lch.adjlisT("a");

		// vérifications
		lco.suplisT("eit");
		lch.suplisT("eit");
		String attendu = "a d eit";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
	}
}
