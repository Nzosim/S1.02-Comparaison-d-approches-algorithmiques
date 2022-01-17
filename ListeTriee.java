/**
 * classe ListeTriee qui trie des liste chainee ou contigue
 */
public class ListeTriee{

	/**
	 * attribut liste de type Liste de la classe ListeTriee
	 */
	private Liste liste;
	
	/**
	 * constructeur de la classe ListeTriee
	 * affeecte une liste libre a l'attribut liste
	 * @param listevide une liste vide
	 */
	public ListeTriee(Liste listevide){
		liste = listevide;
	}
	
	/**
	 * ajoute un element en parametre au bon endroit dans la liste triee
	 * @param chaine element a inserer
	 */
	public void adjlisT(String chaine){	
		boolean find = false;
		int p=liste.tete(), prec = p;
		while(!this.liste.finliste(p) && !find){
			if(this.liste.val(p).compareTo(chaine) > 0){
				find = true;
			}else{
				prec = p;
				p = this.liste.suc(p);
			}
		}
		if(p == this.liste.tete()){
			this.liste.adjtlis(chaine);
		}else{
			this.liste.adjlis(prec, chaine);
		}
	}
	
	/**
	 * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ou ne fait rien si "chaine" n'appartient pas a la liste.
	 * @param chaine l'element a supprimer 
	 */
	public void suplisT(String chaine){
		boolean find = false;
		int p = liste.tete();
		while(!this.liste.finliste(p) && !find){
			if(this.liste.val(p).equals(chaine)){
				this.liste.suplis(p);
				find = true;
			}else{
				p = this.liste.suc(p);
			}
		}
	}

	/**
	 * methode memlisT qui cherche si au moins un element de la liste a une valeur egale a "chaine"
	 * @param chaine l'element que l'on recherche
	 * @return booléen qui indique si oui ou non "chaine" est présent
	 */
	public boolean memlisT(String chaine){
		boolean res = false;
		int p=liste.tete();
		while(!this.liste.finliste(p) && !res){
			if(this.liste.val(p).compareTo(chaine) == 0){
				res = true;
			}else{
				p = this.liste.suc(p);
			}
		}
		return res;
	}

	/**
	 * methode toString de la classe ListeTriee permet d'afficher la liste
	 * @return la liste
	 */
	public String toString(){
		String res = "";
		int p = this.liste.tete();
		while(!this.liste.finliste(p)){
			res += this.liste.val(p)+" ";
			p = this.liste.suc(p);
		}
		if(this.liste.val(this.liste.tete()) != null){
			res = res.substring(0, res.length() - 1); // permet d'enlever le dernier espace de la chaine
		}
		return res;
	}
}