package pkmBot;

import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon {
	String name;
	ArrayList<String>Ev;
	ArrayList<Integer>pixel;
	public String getName() {
		return name;
	}
	public ArrayList<String> getEv() {
		return Ev;
	}
	public ArrayList<Integer> getPixel() {
		return pixel;
	}
	public Pokemon(String line) {
		String[] array = line.split(";");
		this.name=array[0];
		this.Ev=(ArrayList<String>) Arrays.asList(array[1]);
		String[] pixels = array[2].split(",");
		for(String s:pixels) {
			this.pixel.add(Integer.parseInt(s));
		}
	}

}
