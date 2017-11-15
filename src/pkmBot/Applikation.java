package pkmBot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Applikation {

	static Thread process = new Thread(new Runnable() {

		@Override
		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted())
					;
			} catch (Exception e) {
				Thread.currentThread().interrupt();
				System.out.println("Stopp");
			}
		}
	});

	static int start_stopp = 0;

	private JFrame frame;
	private JTextField txtPkmname;

	public static ArrayList<JRadioButton> ortclicker = new ArrayList<JRadioButton>();
	public static ArrayList<JRadioButton> recclicker = new ArrayList<JRadioButton>();
	public static ArrayList<JRadioButton> ourlclicker = new ArrayList<JRadioButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Applikation window = new Applikation();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Applikation() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(287, 187, 151, 86);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnStart = new JButton("Start");

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_stopp++;
				System.out.println(start_stopp);
				if (start_stopp == 1)
					process.start();

			}
		});
		btnStart.setBounds(22, 12, 117, 25);
		panel.add(btnStart);

		JButton btnStopp = new JButton("Stopp");
		btnStopp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_stopp = 0;
				process.interrupt();

				process = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							while (!Thread.currentThread().isInterrupted())
								if (start_stopp == 1)
									Main.start();
						} catch (Exception e) {
							Thread.currentThread().interrupt();
							System.out.println("Stopp");
						}
					}
				});

			}
		});
		btnStopp.setBounds(22, 49, 117, 25);
		panel.add(btnStopp);

		txtPkmname = new JTextField();
		txtPkmname.setBounds(112, 12, 114, 19);
		frame.getContentPane().add(txtPkmname);
		txtPkmname.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 14, 70, 15);
		frame.getContentPane().add(lblName);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(329, 21, 109, 138);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "EV", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JRadioButton rdbtnSpezatk = new JRadioButton("SpezAtk");
		rdbtnSpezatk.setBounds(8, 36, 93, 23);
		panel_2.add(rdbtnSpezatk);

		JRadioButton rdbtnAtj = new JRadioButton("ATK");
		rdbtnAtj.setBounds(8, 84, 93, 23);
		panel_2.add(rdbtnAtj);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 43, 151, 210);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Orte", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JRadioButton rdbtnOrt = new JRadioButton("Ort1");
		rdbtnOrt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check(ortclicker, rdbtnOrt);
			}
		});

		rdbtnOrt.setBounds(8, 42, 102, 23);
		panel_1.add(rdbtnOrt);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Rec", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(185, 43, 70, 91);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JRadioButton rdbtnAn = new JRadioButton("an");
		rdbtnAn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check(recclicker, rdbtnAn);
			}
		});
		rdbtnAn.setBounds(8, 20, 49, 23);
		panel_3.add(rdbtnAn);

		JRadioButton rdbtnAus = new JRadioButton("aus");
		rdbtnAus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check(recclicker, rdbtnAus);
			}
		});
		rdbtnAus.setBounds(8, 47, 54, 23);
		panel_3.add(rdbtnAus);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "rl-ou", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(179, 157, 76, 95);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JRadioButton rdbtnOu = new JRadioButton("ou");
		rdbtnOu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check(ourlclicker, rdbtnOu);
			}
		});
		rdbtnOu.setBounds(8, 26, 54, 23);
		panel_4.add(rdbtnOu);

		JRadioButton rdbtnLr = new JRadioButton("lr");
		rdbtnLr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				check(ourlclicker, rdbtnLr);
			}
		});
		rdbtnLr.setBounds(8, 53, 60, 23);
		panel_4.add(rdbtnLr);

		frame.addKeyListener(new MoveRecorder());
		frame.setFocusable(true);

		ortclicker.add(rdbtnOrt);
		recclicker.add(rdbtnAn);
		recclicker.add(rdbtnAus);
		ourlclicker.add(rdbtnOu);
		ourlclicker.add(rdbtnLr);

	}

	public static void check(ArrayList<JRadioButton> list, JRadioButton btn) {
		for (JRadioButton btnother : list) {
			if (btn != btnother) {
				btnother.setSelected(false);
			}
		}
	}
}
