package unieibar;

public class MahaiBiribila {
    private Zotza zotzak[];
    private int filosofo_kop;

    public MahaiBiribila(int pertsonak){
        this.filosofo_kop=pertsonak;
        zotzak = new Zotza[pertsonak];

        for (int i=0; i < pertsonak; i++){
            zotzak[i] = new Zotza(i);
        }     
    }

    public Zotza eskuineko_zotza (int i){
        // mahaia zirkularra da! Zenbakiak une batean 
        // berrabiarazten dira guztizkoaren arabera
        return zotzak[(i+1)%filosofo_kop]; 
        //return zotzak[i+1];
    }

    public Zotza ezkerreko_zotza (int i){
        return zotzak[i];
    }
}
