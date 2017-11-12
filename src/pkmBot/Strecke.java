package pkmBot;


public class Strecke {
	private int richtung;
	private long delay;
	private int anzahl;
	private int warteZeit;
	
	
	
	public Strecke(int richtung, long delay, int anzahl, int warteZeit) {
		this.richtung = richtung;
		this.delay = delay;
		this.anzahl = anzahl;
		this.warteZeit = warteZeit;
	}







	public int getWarteZeit() {
		return warteZeit;
	}








	



	public int getRichtung() {
		return richtung;
	}



	public long getDelay() {
		return delay;
	}



	public int getAnzahl() {
		return anzahl;
	}
	
	
}