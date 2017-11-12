package pkmBot;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public abstract class Login {
	
	static Robot r=Main.r;
	
	public static boolean trylogin() {
		int x=r.getPixelColor(350, 583).getRGB();
		int y=r.getPixelColor(350, 590).getRGB();
		if(x==-6169 && y==-10855069){return true;
		
		}else return false;
		
	}// (350, 583) -6169  ,  (350, 590) -10855069
	
	public static void login() throws InterruptedException {
		Thread.sleep(4000);
		r.mouseMove(750, 510);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(6000);
		Laufen.kampfcounter=0;

	}

	public static void relog() throws InterruptedException {
		logout();
		login();
		
	}

	public static void logout() throws InterruptedException {
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.delay(50);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		r.mouseMove(700, 460);
		Thread.sleep(3000);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.delay(50);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(5000);
		
	}
	

}
