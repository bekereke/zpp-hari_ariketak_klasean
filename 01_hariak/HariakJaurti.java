package unieibar;
public class HariakJaurti {
	public static void main(String[] args) {
                int HARI_KOP=10;
                Runnable zeregina;
                for (int i=0; i<HARI_KOP; i++)
                {
                        zeregina = new ZereginZailak((i+1)+"_zeregina");
                        Thread haria = new Thread(zeregina);
                        haria.start();
                }
	}
}
