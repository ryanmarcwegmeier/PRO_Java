package pkmBot;

import java.util.ArrayList;

public class Ort {
	
	
	
	
	private String name;
	private ArrayList<Strecke>weg;
	public String getName() {
		return name;
	}
	public ArrayList<Strecke> getWeg() {
		return weg;
	}
	public Ort(String name, ArrayList<Strecke> weg) {
		super();
		this.name = name;
		this.weg = weg;
	}
}
