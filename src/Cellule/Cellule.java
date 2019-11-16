package Cellule;

public class Cellule {
    protected int state;
    protected int m;
    protected int n;
    protected int init;
    Cellule[] voisins;

    public Cellule(int state, int n, int m,int init) {
        this.voisins = new Cellule[8];
        this.state = state;
        this.init=state;
        this.n = n;
        this.m = m;
    }

    public int getM() {
        return m;
    }

    public int getState() {
        return state;
    }

    public int getN() {
        return n;
    }
    public static int mod (int a, int b) {
        int res = a % b;
        if (res<0 && b>0) {
            res += b;
        }
        return res;
    }

    public void ajouter_voisins(Cellule[][] tab) {
        voisins[0] = tab[mod(n-1,5)][mod(m - 1 , 5)];
        voisins[1] = tab[mod(n - 1 , 5)][mod(m ,5)];
        voisins[2] = tab[mod(n - 1 , 5)][mod((m + 1) , 5)];
        voisins[3] = tab[mod(n , 5)][mod(m - 1 , 5)];
        voisins[4] = tab[mod(n , 5)][mod(m + 1 , 5)];
        voisins[5] = tab[mod(n + 1 , 5)][mod(m - 1 , 5)];
        voisins[6] = tab[mod(n + 1 , 5)][mod(m , 5)];
        voisins[7] = tab[mod(n + 1 , 5)][mod(m + 1 , 5)];
    }

    public  void reInit(){
        this.state=init;
    }

    public int nb_voisins_vivant() {
        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            if (voisins[i].state == 1) {
                tmp++;
            }
        }
        return tmp;
    }

    public  void set_state(){
        if (state == 1){
            if (nb_voisins_vivant()!=2 && nb_voisins_vivant() !=3){
                state = 0;
            }
        }
        if (state==0){
            if (nb_voisins_vivant() ==3){
                state = 1;
            }
        }
    }

    public void init_state(int state){
        this.state=state;
        this.init=state;
    }


}




