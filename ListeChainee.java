public class ListeChainee implements Liste{
    
    private MaillonEntier[] tab;
    private int tete;

	/**
	 * constructeur de la classe ListeChainee
	 * @param p taille du tableau
	 */
    public ListeChainee(int p){
	   this.tete = -1;
       tab = new MaillonEntier[p];
	   for(int i = 0; i<this.tab.length; i++){
		   this.tab[i] = new MaillonEntier(null,-2);
	   }
    }

    /**
	 * permet de suprrimer un element d'une liste
	 * @param p place de l'element a supprimer 
	 */
	public void suplis(int p){
		this.libererPlace(p);
    }
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element  ajouter en tete
	 */
	public void adjtlis(String s){
        int sto = this.retournerPlaceLibre();
		this.tab[sto].setVal(s);
		this.tab[sto].setSuc(this.tete);
		this.tete = sto;
    }
	 
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element inserer
	 */
	public void adjlis(int p, String s){
		int sto = this.retournerPlaceLibre(), suc = this.tab[p].getSuc();
		this.tab[sto].setVal(s);
		this.tab[sto].setSuc(suc);
		this.tab[p].setSuc(sto);
    }
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p){
        return p == -1;
    }
	 
	/**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete(){
        return this.tete;
    }
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p){
		int res=-2;
		if(p != -1){
			res=this.tab[p].getSuc();
		}
        return res;
    }
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee  p
	 */
	public String val(int p){
        return this.tab[p].getVal();
    }

	public int retournerPlaceLibre(){	
		int res = 0;
		while(this.tab[res].getSuc() != -2){
			res ++;
		}
		return res;
	}
 
	public void libererPlace(int p){
		if(p == this.tete){
			this.tete = this.tab[p].getSuc();
		}else{
			int sto = 0;
			while(this.tab[sto].getSuc() != p){
				sto ++;
			}
			this.tab[sto].setSuc(this.tab[p].getSuc());
		}
		this.tab[p].setSuc(-2);	
	}
}