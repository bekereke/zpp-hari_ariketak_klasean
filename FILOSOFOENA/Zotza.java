package unieibar;

public class Zotza {
    private int zenb;
    private boolean hartuta;

    public Zotza(int id){
        this.zenb=id;
        this.hartuta=false;
    }

    public int getId(){
        return this.zenb;
    }

    // SINKRONIZATUTAKO METODOAK 
    // aldi berean hari bakarrak zeharkatuko ditu
    // eta baldintzen bidez hariak sinkronizatuko
    synchronized public void hartu(){
        while(hartuta){
            try {
                System.out.println(zenb+" zotzari zain...");
                wait();
            } catch (InterruptedException ie) {
                System.out.println(zenb+" zotzaren zaintza moztu da");
                System.exit(zenb);
            }
        }
        hartuta=true;
        System.out.println(zenb+" zotza hartu dute");
    }

    synchronized public void utzi(){
        hartuta=false;
        System.out.println(zenb+" zotza utzi dute");
        notify();
    }
}
