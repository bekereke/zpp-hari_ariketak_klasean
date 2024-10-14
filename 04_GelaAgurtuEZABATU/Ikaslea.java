package unieibar;

public class Ikaslea extends Thread{
	private String agurrak[] = {"kaixo!", "eup!", "zelan?", "eeeepa!", "ñooooo!"};
    private int zenbatAldiz = 5;
    private String izena = "";
    private int banderita = 1; // 0 = GERATU DENA, 1 = LANEAN JARRAITU
    
    public Ikaslea()
    {
    	
    }
    
    public Ikaslea(String izena, int zenbatAldiz)
    {
    	this.izena = izena;
    	this.zenbatAldiz = zenbatAldiz;
    }
    @Override
    public void run() {
        // Auzazko kodea exekutatu "zenbatAldiz" aldiz
        // Pantailaratu honelako zerbait
    	for (int k=0; k<this.zenbatAldiz; k++)
    	{
    		// banderita-ren balioa egiaztatzen dugu
    		if (banderita == 1)
    		{
    		
	    		int aldia = k+1;
	    		System.out.println(izena + " IKASLEA: kaixo! " + " (" + aldia + " aldia)");
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	//	    	int i = 0 + (int)(Math.random() * 4); 
	//	        System.out.println(izena.toUpperCase() + ": " + agurrak[i] + " (" + aldia + " aldia)");
	//	       
	//	        // Auzazko denbora bat itxaron
	//	        long tiempo=(long) (1000*Math.random()*5);
	//	        try {
	//				Thread.sleep(tiempo);
	//			} catch (InterruptedException e) {
	//				e.printStackTrace();
	//			}
	    		
    		}
    		else
    		{
    			System.out.println(izena.toUpperCase() + ": BUKATZERA BEHARTU NAUTE");
    			return;
    		}
    	}
    	
    	System.out.println(izena.toUpperCase() + ": BUKATU DUT LANA");
    }
	
    public int getZenbatAldiz() {
		return zenbatAldiz;
	}
	public void setZenbatAldiz(int zenbatAldiz) {
		this.zenbatAldiz = zenbatAldiz;
	}
	
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getBanderita() {
		return banderita;
	}

	public void setBanderita(int banderita) {
		this.banderita = banderita;
	}
    
}
