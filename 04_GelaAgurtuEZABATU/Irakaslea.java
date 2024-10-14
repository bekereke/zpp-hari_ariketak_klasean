package unieibar;

public class Irakaslea extends Thread {
	private String agurra = "KAIXO DENOI!!!";
	private String izena = "";
	
	public Irakaslea()
	{
		//bestela JVMk sortuko du berariaz
	}
	
	public Irakaslea (String agurra, String izena)
	{
		this.agurra = agurra;
		this.izena = izena;
	}

	public String getAgurra() {
		return agurra;
	}

	public void setAgurra(String agurra) {
		this.agurra = agurra;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	@Override
	public void run()
	{
		System.out.println("Nire izena " + this.izena + " IRAKASLEA da: " + this.agurra + " <------------------");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.izena + " IRAKASLEA: BUKATU DUT KLASEA AGURTZEN. Lanera! <------------------");
	}

}
