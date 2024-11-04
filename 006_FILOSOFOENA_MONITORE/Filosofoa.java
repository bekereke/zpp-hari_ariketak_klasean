package unieibar;
import java.util.Random;

public class Filosofoa extends Thread{
    protected Zotza ezkerz, eskuinz;
    protected int identitatea;
    static final protected int ATZERAPEN_MAX = 1000;

    public Filosofoa(int id){
        this.identitatea = id;
    }

    public void pentsatu(){
        try {
            Random ausaz = new Random();
            System.out.println(identitatea+" filosofoa pentsatzen ari da (HMMMMM)");
            Thread.sleep(ausaz.nextLong(ATZERAPEN_MAX)); //nextLong(MAX-LOW)+LOW
        } catch (InterruptedException ie) {
            System.exit(identitatea);
        }
    }

    public void jan(){
        try {
            Random ausaz = new Random();
            System.out.println(identitatea+" filosofoa jaten ari da (KRUNTX-KRUNTX)");
            Thread.sleep(ausaz.nextLong(ATZERAPEN_MAX)); //nextLong(MAX-LOW)+LOW
        } catch (Exception e) {
            System.exit(identitatea);
        }
    }

    // unieibar paketean edo eratorritako klaseetan erabilgai dauden metodoak:
    protected void jan_nahirik(){
        System.out.println(identitatea+" filosofoak jan nahi du");
        ezkerz.hartu();
        eskuinz.hartu();
    }

    protected void jateari_utzi(){
        ezkerz.utzi();
        eskuinz.utzi();
    }

    @Override
    public void run(){
        pentsatu();
        jan_nahirik();
        jan();
        jateari_utzi();
    }
}
