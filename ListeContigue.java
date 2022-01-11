public class ListeContigue implements Liste{
    
    private String[] tab;
    int nbElements; 

    public ListeContigue(int tailleMax){
        this.tab = new String[tailleMax];
        
    }

    public void suplis(int place){
        for(int i = place; i<this.nbElements; i++){
            this.tab[i] = this.tab[i+1];
        }
        this.nbElements --;
    }

    public void adjtlis(String elem){
        if(this.nbElements == this.tab.length){
            String[] st = new String[this.tab.length+1];      
            for(int i = this.nbElements;i>0;i--){
                this.tab[i]=this.tab[i-1];
            }
            st[0] = elem;
            this.tab = st;
        }else{
            for(int i = this.nbElements;i>0;i--){
                this.tab[i]=this.tab[i-1];
            }
            this.tab[0]=elem;
            this.nbElements ++;
        }
    }

    public void adjlis(int place, String elem){
        if(this.nbElements == this.tab.length){
            String[] st = new String[this.tab.length+1];      
            int p = 0;
            while(p<=place && p<nbElements){
                st[p] = this.tab[p];
                p++;
            }
            st[p] = elem;
            while(p<this.nbElements){
                st[p+1] = this.tab[p];
                p++;
            }
            this.tab = st;
        }else{
            for(int i = this.nbElements;i>place;i--){
                this.tab[i]=this.tab[i-1];
            }
            this.tab[place+1]=elem;
        }
        this.nbElements += 1;
    }

    public boolean finliste(int place){
        return place == nbElements;
    }

    public int tete(){
        return 0;
    }

    public int suc(int place){
        return place+1;
    }

    public String val(int place){
        return this.tab[place];
    }
}
