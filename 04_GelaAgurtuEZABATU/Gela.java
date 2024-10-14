package unieibar;

import java.util.ArrayList;

public class Gela {

	public static void main(String[] args) {
		String ikasleIzenak[] = {"Jon", "Asier", "Jorge", "Aritz", "Hegoi", 
								"Mikel", "Pablo", "Alvaro", "Joseba", "Anatoli"};
		int agurrak[] = {5, 4, 7 ,8 ,9 ,6 ,5 ,3 ,7, 6};
		ArrayList<Ikaslea> ikasleHariak = new ArrayList<Ikaslea>();
        for (int i=0; i<ikasleIzenak.length;i++){
                Ikaslea ik = new Ikaslea();
                ik.setIzena(ikasleIzenak[i]);
                ik.setZenbatAldiz(agurrak[i]);
                ik.setBanderita(1); // 1 = MARTXAN
                ik.start();  
                
                ikasleHariak.add(ik);
        }
        
       
        Irakaslea mikel = new Irakaslea();
        mikel.setIzena("Mikel");
        mikel.setAgurra("KAIXO DENOI");
        mikel.start();
        
        try {
			mikel.join();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        
        // Hari nagusia 3 segunduz geratu
        /*
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
        
        System.out.println("GELA hari nagusia IKASLEEI BUKATZEKO ESKATZEN... <------------------");

        // Ikasle guztiei egiten daudena egiteari uzteko ESKATZEN DIEGU			
		for (int i=0; i<ikasleHariak.size(); i++)
		{
			if (ikasleHariak.get(i).isAlive())
			{
				ikasleHariak.get(i).setBanderita(0); // 0 = GELDITU!!!
			}
		}
		
		// Ikasle guztiak bukatu dutela ziurtatu
		for (int i=0; i<ikasleHariak.size(); i++)
		{
			if (ikasleHariak.get(i).isAlive())
			{
				try {
					ikasleHariak.get(i).join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
        System.out.println("GELA hari nagusia BUKATU DA. <------------------");

	}

}
