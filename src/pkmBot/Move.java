package pkmBot;

public class Move{
	int key;
	long start;
	long end;

	public long getDealy() {
		return end-start;
	}
	public Move(int key,long start) {
		this.key=key;
		this.start=start;
	}
	
	public String toString() {
		return "Key:"+key+" Delay:"+getDealy();
	}
}
