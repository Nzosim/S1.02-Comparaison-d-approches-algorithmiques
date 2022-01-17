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
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

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
	 * test de la methode suplisT avec une liste contigue et une liste chainee
	 */	
	public void test_02_suplisT(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

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
		String attendu = "a d eia";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
	}

	/** 
	 * test de la methode suplisT avec une liste contigue et une liste chainee et un mot inexistant
	 */	
	public void test_03_suplisT_motNonExistant(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

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
		lco.suplisT("eiesqft");
		lch.suplisT("eisefgt");
		String attendu = "a d eia eit";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
	}

	/** 
	 * test de la methode suplisT avec une liste contigue et une liste chainee vide
	 */	
	public void test_04_suplisT_listeVide(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

		// vérifications
		lco.suplisT("a");
		lch.suplisT("a");
		String attendu = "";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
	}

	/** 
	 * test de la methode memlisT avec une liste contigue et une liste chainee
	 */	
	public void test_05_memlisT(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

		// ajout des valeurs
		lco.adjlisT("eit");
		lch.adjlisT("eit");

		// vérifications	
		assertEquals("devrait rendre true", true, lco.memlisT("eit"));
		assertEquals("devrait rendre true", true, lch.memlisT("eit"));
		assertEquals("devrait rendre true", false, lco.memlisT("e"));
		assertEquals("devrait rendre true", false, lch.memlisT("e"));
	}

	/** 
	 * test de la methode memlisT avec une liste contigue et une liste chainee vide
	 */	
	public void test_05_memlisT_listeVide(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));

		// vérifications	
		assertEquals("devrait rendre true", false, lco.memlisT("e"));
		assertEquals("devrait rendre true", false, lch.memlisT("e"));
	}

	/** 
	 * test de la methode toString avec une liste contigue et une liste chainee et avec des listes vide
	 */	
	public void test_06_toString(){

		// creation d'une liste triee
		ListeTriee lco = new ListeTriee(new ListeContigue(4));
		ListeTriee lch = new ListeTriee(new ListeChainee(4));
		ListeTriee lcoVide = new ListeTriee(new ListeContigue(4));
		ListeTriee lchVide = new ListeTriee(new ListeChainee(4));

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
		String attenduListeVide = "";
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attendu.equals(lco.toString()));
		assertEquals("devrait rendre true", true, attenduListeVide.equals(lcoVide.toString()));
		assertEquals("devrait rendre true", true, attenduListeVide.equals(lchVide.toString()));
	}
}
