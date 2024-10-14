package unieibar;

import java.util.Random;

class Ikaslea extends Thread {
    private final String agurrak[] = {"kaixo!", "eup!", "zelan?", "eeeepa!", "egun on!"};
    private int zenbatAldiz = 5;
    private String izena = "";
    private volatile boolean geldituMarka = false;

    public Ikaslea(String izena){
        this.izena=izena;
    }

    @Override
    public void run() {
        // Auzazko kodea exekutatu "zenbatAldiz" aldiz
        // Pantailaratu honelako zerbait
        for (int i=0; i<zenbatAldiz; i++) {
            if (!(geldituMarka)) {
                Random ausaz = new Random();
                System.out.println("Nire izena " + izena + " da: " + agurrak[ausaz.nextInt(agurrak.length)]+"   "+(i+1)+". aldian");
            
                try{
                    long denb=(long) (1000*Math.random()*5);
                    Thread.sleep(denb);
                } catch (InterruptedException ie){
                    System.out.println(ie.getStackTrace());
                }
            }
        }  
        System.out.println("ISILDU da " + izena);
    }
    // getter eta setter medotoak "zenbatAldiz" eta "izena" barne aldagaientzako
    public void jarriIzena(String izena){
        this.izena=izena; 
    }
    public String itzuliIzena(){
        return this.izena;
    }
    public void jarriZenbatAldiz(int zenb) throws Exception {
        if ((10>=zenb)&&(5<zenb)){
            this.zenbatAldiz=zenb; 
        } else {
            throw new Exception ("Agur kopuru okerra"); 
        }
    }
    public int itzuliZenbatAldiz(){
        return this.zenbatAldiz;
    }
    public void gelditu(){
        this.geldituMarka = true;
    }
}