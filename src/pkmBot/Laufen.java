package pkmBot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Laufen {
	static int kampfcounter = 0;

	static Robot r = Main.r;

	public static boolean tryPkmCtr() throws InterruptedException {
		if (r.getPixelColor(300, 280).getRGB() == -5016800)
			return true;
		return false;
	}

	public static boolean tryPkmCtr2() throws InterruptedException {
		if (r.getPixelColor(440, 120).getRGB() == -5497344)
			return true;
		return false;
	}

	public static void pkmCtr() throws InterruptedException {
		r.keyPress(KeyEvent.VK_D);
		Thread.sleep(200);
		r.keyRelease(KeyEvent.VK_D);
		Thread.sleep(250);
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(200);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250);
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(200);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250 + 3000);
	}

	public static void pkmCtr2() throws InterruptedException {
		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(250);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250);

		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(250);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250);

		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(250);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250);

		r.keyPress(KeyEvent.VK_S);
		Thread.sleep(250);
		r.keyRelease(KeyEvent.VK_S);
		Thread.sleep(250 + 3000);
	}

	public static void zumGras(ArrayList<Strecke> ort) throws InterruptedException {
		for (Strecke o : ort) {
			if (o.getAnzahl() == 0) {
				r.keyPress(o.getRichtung());
				Thread.sleep(200);
				r.delay((int) o.getDelay());
				r.keyRelease(o.getRichtung());
				Thread.sleep(350 + o.getWarteZeit());
			} else {
				for (int i = 0; i < o.getAnzahl(); i++) {
					r.keyPress(o.getRichtung());
					r.delay(0);
					r.keyRelease(o.getRichtung());
					Thread.sleep(450 + o.getWarteZeit());
				}
			}
		}
	}

	private static void linksrechts() {
		r.keyPress(KeyEvent.VK_A);
		r.delay(1300);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.delay(1300);
		r.keyRelease(KeyEvent.VK_D);
	}

	private static void obenunten() {
		r.keyPress(KeyEvent.VK_W);
		r.delay(500);
		r.keyRelease(KeyEvent.VK_W);
		r.keyPress(KeyEvent.VK_S);
		r.delay(500);
		r.keyRelease(KeyEvent.VK_S);
	}

	public static void imGras() throws Exception {
		long time = System.currentTimeMillis();
		long timeend = System.currentTimeMillis() + 1000 * 301;

		while (r.getPixelColor(325, 210).getRGB() != -144826) {
			System.out.println(timeend);
			System.out.println(timeend - time);
			System.out.println();
			System.out.println();
			time = System.currentTimeMillis();
			linksrechts();
			if (time > timeend) {
				Thread.sleep(5000);
				throw new Exception();
			}
		}
		if (kampfcounter <= 5) {
			kampf();
		} else {
			Login.relog();
		}

	}

	public static void fluchtlauf() throws Exception {
		linksrechts();

		if (r.getPixelColor(325, 210).getRGB() == -144826) {
			Thread.sleep(3000);
			ArrayList<Integer> pkm = new ArrayList<Integer>();
			r.mouseMove(810, 210);

			for (int x = 610; x <= 810; x = x + 50) {
				for (int y = 200; y <= 220; y = y + 4) {
					pkm.add(r.getPixelColor(x, y).getRGB());
					System.out.print(r.getPixelColor(x, y).getRGB() + ",");
				}
			}
			// int dif=0;
			// System.out.println(Main.rat.size());
			// System.out.println(pkm.size());
			// System.out.println();
			// for(int i=0;i<Main.rat.size();i++) {
			// dif=dif+Main.rat.get(i)-pkm.get(i);
			// System.out.println(dif);
			// }
			if (!Main.rat.equals(pkm) && !Main.rat2.equals(pkm)) {

				throw new Exception("funktioniert");

			}

			r.keyPress(KeyEvent.VK_1);
			r.delay(10);
			r.keyRelease(KeyEvent.VK_1);
			Thread.sleep(2000);
		}

	}

	public static void kampf() throws InterruptedException {
		long time = System.currentTimeMillis();
		long timeend = System.currentTimeMillis() * 1000 * 60;
		while (r.getPixelColor(325, 210).getRGB() == -144826) {
			time = System.currentTimeMillis();
			r.keyPress(KeyEvent.VK_1);
			r.delay(10);
			r.keyRelease(KeyEvent.VK_1);
			if (time > timeend)
				Login.logout();
		}
		Thread.sleep(3500);
		kampfcounter++;
	}

}
