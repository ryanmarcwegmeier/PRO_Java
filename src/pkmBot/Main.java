package pkmBot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static Robot r;

	public static List<Integer> rat = Arrays.asList(-12238775, -12107190, -12041653, -12107190, -12172726, -12238519,
			-12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190, -1, -1, -3421237,
			-12238519, -12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190,
			-12041653, -12107190, -12172726, -12238519);

	public static List<Integer> rat2 = Arrays.asList(-12238775, -5724502, -12041653, -12107190, -12172726, -12238519,
			-12238775, -1, -1, -1, -4079167, -12238519, -12238775, -12107190, -9539986, -16777216, -6118750, -12238519,
			-12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190, -12041653,
			-12107190, -12172726, -12238519);

	public static List<Integer> ghost = Arrays.asList(-12238775, -12107190, -12041653, -12107190, -12172726, -12238519,
			-12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190, -1, -1, -3421237,
			-12238519, -12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190,
			-12041653, -12107190, -12172726, -12238519, -12238775, -12107190, -12041653, -12107190, -12172726,
			-12238519, -12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190, -1, -1,
			-3421237, -12238519, -12238775, -12107190, -12041653, -12107190, -12172726, -12238519, -12238775, -12107190,
			-12041653, -12107190, -12172726, -12238519);

	static String abbruch = "";

	public static void main(String[] args) throws Exception {
		r = new Robot();

		ArrayList<Strecke> liste = new ArrayList<>();
		liste.add(new Strecke(KeyEvent.VK_D, 0, 1, 0));
		liste.add(new Strecke(KeyEvent.VK_S, 3000, 0, 0));
		liste.add(new Strecke(KeyEvent.VK_W, 0, 1, 0));
		liste.add(new Strecke(KeyEvent.VK_D, 4000, 0, 3000));
		liste.add(new Strecke(KeyEvent.VK_D, 4000, 0, 0));
		liste.add(new Strecke(KeyEvent.VK_S, 3000, 0, 0));

		ArrayList<Strecke> liste2 = new ArrayList<>();
		liste2.add(new Strecke(KeyEvent.VK_A, 0, 3, 0));
		liste2.add(new Strecke(KeyEvent.VK_S, 0, 1, 0));
		liste2.add(new Strecke(KeyEvent.VK_A, 3000, 0, 0));
		liste2.add(new Strecke(KeyEvent.VK_S, 0, 1, 0));
		liste2.add(new Strecke(KeyEvent.VK_A, 0, 3, 0));
		liste2.add(new Strecke(KeyEvent.VK_W, 3000, 0, 3000));
		liste2.add(new Strecke(KeyEvent.VK_W, 5000, 0, 0));
		liste2.add(new Strecke(KeyEvent.VK_S, 0, 2, 0));
		liste2.add(new Strecke(KeyEvent.VK_D, 0, 6, 0));

		ArrayList<Strecke> liste3 = new ArrayList<>();
		liste3.add(new Strecke(KeyEvent.VK_S, 0, 1, 0));
		liste3.add(new Strecke(KeyEvent.VK_A, 4000, 0, 0));
		liste3.add(new Strecke(KeyEvent.VK_D, 0, 2, 0));
		liste3.add(new Strecke(KeyEvent.VK_W, 6000, 0, 0));
		liste3.add(new Strecke(KeyEvent.VK_A, 0, 4, 0));
		liste3.add(new Strecke(KeyEvent.VK_W, 9000, 0, 2000));
		liste3.add(new Strecke(KeyEvent.VK_W, 0, 1, 0));
		liste3.add(new Strecke(KeyEvent.VK_W, 4000, 0, 0));
		liste3.add(new Strecke(KeyEvent.VK_A, 0, 5, 0));
		liste3.add(new Strecke(KeyEvent.VK_W, 3000, 0, 3000));
		liste3.add(new Strecke(KeyEvent.VK_W, 3000, 0, 0));



		
		Ort ort = new Ort("2.Stadt", liste3);

		Thread.sleep(3000);

		long time = System.currentTimeMillis();
		long endtime = System.currentTimeMillis() + 1000 * 60 * 3;
		
		 System.out.println(r.getPixelColor(440, 120).getRGB());

		
		while (true) {
		 time = System.currentTimeMillis();
		 if (Login.trylogin())
		 Login.login();
		 if (Laufen.tryPkmCtr2()) {
		 Laufen.pkmCtr2();
		 Laufen.zumGras(ort.getWeg());
		 }
		 // Laufen.imGras();
		 Laufen.imGras();
		 }
//		for (int x = 610; x <= 810; x = x + 50) {
//			for (int y = 200; y <= 220; y = y + 4) {
//				System.out.print(r.getPixelColor(x, y).getRGB() + ",");
//			}
//		}
		 
		 

	}

}
