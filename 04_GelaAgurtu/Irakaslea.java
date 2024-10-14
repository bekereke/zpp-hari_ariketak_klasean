package unieibar;

public class Irakaslea extends Thread {
    private static String agurra = "KAIXO DENOI";
    private String izena = "";

    //eraikitzailea JVMk sortu dezala

    @Override
    public void run(){
        System.out.println(agurra);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("ISILDU da " + izena+" irakaslea ere eta LANEAN jarri ditu ikasleak.");
    }
    public void jarriIzena(String izena){
        this.izena=izena; 
    }
    public String itzuliIzena(){
        return this.izena;
    }
}
