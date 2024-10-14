package unieibar;
import java.util.ArrayList;

public class KalkulatzaileaJaurti {

	public static void main(String[] args) throws InterruptedException {
		Runnable hariBek[]=new Kalkulatzailea[5];
		ArrayList<Thread> semeHariak = new ArrayList<Thread>();
                for (int i=0; i<hariBek.length;i++){
                        hariBek[i]=new Kalkulatzailea();
                        Thread haria=new Thread(hariBek[i]);
                        haria.setName(i+"_haria");      //haria izendatzea
                        haria.setPriority(i+5);		//hariaren lehentasuna ezartzea. //5 direla dakigulako eta 10eko lehentasun mugatik ez garela igaroko!
                        semeHariak.add(haria);       
                }
        
                for (int i=0; i<semeHariak.size(); i++)
                {
                        semeHariak.get(i).start();
                        //semeHariak.get(i).setPriority(i+5);
                }
                System.out.println("KalkulatzaileaJaurti BUKATUTA.");
	}

}
