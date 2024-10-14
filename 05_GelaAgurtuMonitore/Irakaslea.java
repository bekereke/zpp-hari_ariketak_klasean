package unieibar;

public class Irakaslea extends Thread {
    private static final String agurra = "KAIXO DENOI";
    private String izena = "";
    private Object monitorea = null;

    public Irakaslea (Object monitorea){
        this.monitorea = monitorea;
    }

    @Override
    public void run(){
        synchronized(monitorea) {
            try {
                monitorea.wait();
                System.out.println(agurra);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ISILDU da " + izena+" irakaslea ere eta LANEAN jarri ditu ikasleak.");
        }
    }
    public void jarriIzena(String izena){
        this.izena=izena; 
    }
    public String itzuliIzena(){
        return this.izena;
    }
}
