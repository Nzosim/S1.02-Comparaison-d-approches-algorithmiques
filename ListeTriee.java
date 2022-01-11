public class ListeTriee{

	// Attribut de liste sous-jacente
	private Liste liste;
	
	public ListeTriee(Liste listevide){
		// Affectation de la liste vide a l'attribut prive
		liste = listevide;
	}
	
	/**
	 * ajoute un element au bon endroit dans la liste triee
	 * @param chaine element a inserer
	 */
	public void adjlisT(String chaine){	
		boolean find = false;
		int p=liste.tete(), prec = p;
		while(!this.liste.finliste(p) && !find){
			if(this.liste.val(p).compareToIgnoreCase(chaine) <0){
				this.liste.adjlis(prec, chaine);
				find = true;
			}else{
				prec = p;
				p = liste.suc(p);
			}
		}
	}
	
	/**
	 * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
	 * @param chaine l'element a supprimer 
	 */
	public void suplisT(String chaine){
		boolean find = false;
		int p=liste.tete();
		while(!this.liste.finliste(p) && !find){
			if(this.liste.val(p).compareToIgnoreCase(chaine) == 0){
				this.liste.suplis(p);;
				find = true;
			}else{
				p = liste.suc(p);
			}
		}
	}
	
	/**
	 * Retourne vrai si au moins un element de la liste a une valeur egale a "chaine", et retourne faux sinon.
	 * @param chaine l'element que l'on recherche
	 */
	public boolean memlisT(String chaine){
		boolean res = false;
		int p=liste.tete();
		while(!this.liste.finliste(p) && !res){
			if(this.liste.val(p).compareToIgnoreCase(chaine) == 0){
				res = true;
			}else{
				p = liste.suc(p);
			}
		}
		return res;
	}

	public String toString(){
		// TODO (utiliser les fonctions deja ecrites dans les listes !)
		throw (new Error("not implemented"));
	}
}
