package unieibar;

public class Kola {
	private int zenbakia;
	private boolean eskuragarri = false; // Hasiera batetan kola hutsik dago
	
	public int get()
	{
		if(this.eskuragarri)		// zenbaki bat dago kolan
		{
			this.eskuragarri = false;	// kola hustu egiten da
			return this.zenbakia;		// zenbakia itzultzen da
		}
		return -1;	// kola ez dago eskuragarri 
	}
	
	public void put(int balioa)
	{
		this.zenbakia = balioa;			// balioa kolan jartzen da
		this.eskuragarri = true;		// kontsumitzeko prest uzten da. Kola beteta dago.
	}
}
