/**
 * classe CalculTime qui permet de calculer les temps des opérations de la classe ListeTriee
 */
public class CalculTime {
    
    /**
     * attribut motdebut et motfin 
     * mot à ajouter dans les listes
     */
    String[] motdebut = new String[10];
    String[] motfin = {"Z","Z","Z","Z","Z","Z","Z","Z","Z","Z"};

    /**
     * constructeur vide de la classe CalculTime
     */
    public CalculTime(){}

    /**
     * methode calcul qui calcule le temps pour effectuer une opération dans une ListeTriee
     * @param l la liste sur laquel faire le calcul
     * @param elem tableau de String à utiliser
     * @param nb nombre d'itération pour la fonction
     * @param fonction fonction a utiliser "adj" pour adjlisT, "sup" pour suplisT, sinon memlisT
     * @param nbrCalcul nombre de fois a effectuer les tests pour calculer la moyenne
     * @return la moyenne de temps pour effectuer les tests
     */
    public long calcul(ListeTriee l, String[] elem, int nb, String fonction, int nbrCalcul){
        long moyenne = 0;

        for(int i = 0; i<nbrCalcul; i++){ // nombre de test pour la moyenne
            long date_debut = System.nanoTime();
            for (int j = 0 ; j < nb ; j++){ // ajout des nb valeurs de elem
                if(fonction == "adj"){
                    l.adjlisT(elem[j]);
                }else if(fonction == "sup"){
                    l.suplisT(elem[j]);
                }else{
                    l.memlisT(elem[j]);
                }
            }
		    long date_fin = System.nanoTime();  
            moyenne += date_fin-date_debut;    
            
            if(fonction == "adj"){
                for (int j = 0 ; j < nb ; j++){ // suppression des valeurs pour remettre la liste a sa taille initial
                    l.suplisT(elem[j]);
                }
            }else if(fonction == "sup"){
                if(elem == motdebut){
                    for (int j = 0 ; j < nb ; j++){
                        l.adjlisT(motdebut[j]);
                    }
                }else{
                    for (int j = 0 ; j < nb ; j++){
                        l.adjlisT(motfin[j]);
                    }
                }
            }
        }
    
		return moyenne / nbrCalcul;
    }

    /**
     * methode TempsAjout qui test l'ajout de valeur dans une liste contigue et chainee en debut et fin de liste
     * @param nbrValeur le nombre d'ajout à faire
     * @param lC la liste contigue dans laquel ajouter les valeurs
     * @param lh la liste chainee dans laquel ajouter les valeurs
     * @param elem tableau de String à ajouter
     * @param nb nombre de fois a effectuer les tests pour calculer la moyenne
     * @param taille la taille des listes 
     * @return le liste la plus rapide en fonction de la situation
     */
    public String TempsAjout(int nbrValeur, ListeTriee lC, ListeTriee lh, String[] elem, int nb, int taille){

        long dureeListeContigue = this.calcul(lC, elem, nbrValeur, "adj", nb);
        long dureeListeChainee = this.calcul(lh, elem, nbrValeur, "adj", nb);

        String inf = dureeListeContigue < dureeListeChainee ? "contigue" : "chainee";
        long temps = dureeListeContigue < dureeListeChainee ? dureeListeContigue : dureeListeChainee;
        String endroit = elem[0] == "A" ? "debut" : "fin";

        return "Pour "+nbrValeur+" ajout en "+endroit+" avec une liste de "+(taille-10)+" noms la liste la plus rapide est la liste "
            +inf+" avec un temps de : "+temps+" ns";
    }

    /**
     * methode TempsSuppr qui test la suppression de valeur dans une liste contigue et chainee en debut et fin de liste
     * @param nbrValeur le nombre de suppression à faire
     * @param lC la liste contigue dans laquel supprimer les valeurs
     * @param lh la liste chainee dans laquel supprimer les valeurs
     * @param debut boolean qui indique si il faut ajouter en debut ou en fin de liste
     * @param nb nombre de fois a effectuer les tests pour calculer la moyenne
     * @param taille la taille des listes
     * @return le liste la plus rapide en fonction de la situation
     */
    public String TempsSuppr(int nbrValeur, ListeTriee lC, ListeTriee lh, boolean debut, int nb, int taille){

        String[] utilise = debut ? motdebut : motfin;

        long dureeListeContigue = this.calcul(lC, utilise, nbrValeur, "sup", nb);
        long dureeListeChainee = this.calcul(lh, utilise, nbrValeur, "sup", nb);

        String inf = dureeListeContigue < dureeListeChainee ? "contigue" : "chainee";
        long temps = dureeListeContigue < dureeListeChainee ? dureeListeContigue : dureeListeChainee;
        String endroit = debut ? "debut" : "fin";

        return "Pour "+nbrValeur+" suppression en "+endroit+" avec une liste de "+(taille-10)+" noms la liste la plus rapide est la liste "
            +inf+" avec un temps de : "+temps+" ns";
    }

    /**
     * methode TempsMem qui test la présence de valeur dans une liste contigue et chainee en debut et fin de liste
     * @param nbrValeur le nombre de présence à tester
     * @param lC la liste contigue dans laquel tester la présence des valeurs
     * @param lh la liste chainee dans laquel tester la présence des valeurs
     * @param debut boolean qui indique si il faut tester la présence de noms en debut ou en fin de liste
     * @param nb nombre de fois a effectuer les tests pour calculer la moyenne
     * @param taille la taille des listes
     * @return le liste la plus rapide en fonction de la situation
     */
    public String TempsMem(int nbrValeur, ListeTriee lC, ListeTriee lh, boolean debut, int nb, int taille){
        
        String[] utilise = debut ? motdebut : motfin;

        long dureeListeContigue = this.calcul(lC, utilise, nbrValeur, "mem", nb);
        long dureeListeChainee = this.calcul(lh, utilise, nbrValeur, "mem", nb);

        String inf = dureeListeContigue < dureeListeChainee ? "contigue" : "chainee";
        long temps = dureeListeContigue < dureeListeChainee ? dureeListeContigue : dureeListeChainee;
        String endroit = debut ? " au debut" : " a la fin";

        return "Pour rechercher "+nbrValeur+" mots"+endroit+" avec une liste de "+(taille-10)+" noms la liste la plus rapide est la liste "
            +inf+" avec un temps de : "+temps+" ns";
    }

    /**
     * methode qui permet de trouver les 10 premiers mot de la liste en parametre pour les ajouter à l'attribut motdebut
     * @param l liste dans laquel chercher
     */
    public void TrouverMotDebut(ListeTriee l){
        String res="";
		String mot=l.toString(); // liste de mot
		int i = 0;
		for(int j = 0; j < 10; j++){
			while(mot.charAt(i) != ' '){
				res+= mot.charAt(i);
				i++;
			}
			i++;
			motdebut[j] = res;
			res = "";
		}
    }
}