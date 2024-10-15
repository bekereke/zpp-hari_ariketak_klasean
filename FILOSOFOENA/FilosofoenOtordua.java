package unieibar;

public class FilosofoenOtordua {
    
    public static MahaiBiribila mahaia;

    public static void main(String[] args) throws InterruptedException {
        int filosofo_kop = Integer.parseInt(args[0]);
        mahaia = new MahaiBiribila(filosofo_kop);
        System.out.println("Mahaian "+filosofo_kop+" filosofo eseri dira");

        for (int i = 0; i <  filosofo_kop; i++) {
            Filosofoa f = new Filosofoa(i);
            f.ezkerz=mahaia.ezkerreko_zotza(i);
            f.eskuinz=mahaia.eskuineko_zotza(i);
            f.start();
        }
    }
}
