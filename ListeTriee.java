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
	 * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
	 * @param chaine l'element a supprimer 
	 */
	public void suplisT(String chaine){
		boolean find = false;
		int p=liste.tete();
		while(!this.liste.finliste(p) && !find){
			if(this.liste.val(p).compareTo(chaine) == 0){
				this.liste.suplis(p);;
				find = true;
			}else{
				p = this.liste.suc(p);
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
			if(this.liste.val(p).compareTo(chaine) == 0){
				res = true;
			}else{
				p = this.liste.suc(p);
			}
		}
		return res;
	}

	public String toString(){
		String res = "";
		int p = this.liste.tete();
		while(!this.liste.finliste(p)){
			res += this.liste.val(p)+" ";
			p = this.liste.suc(p);
		}
		res = res.substring(0, res.length() - 1); // permet d'enlever le dernier espace de la chaine
		return res;
	}
}