package projetCalculette;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import java.awt.Font;
import javax.swing.UIManager;

public class Calculette {

	/*********************************************************************************************************************************
	 * Variables.
	 *********************************************************************************************************************************/

	private JFrame frame;
	private JLabel labelScreen;
	private boolean switchOn = false;
	private boolean point = false;
	private boolean ce;
	private char operator = '=';
	private double bufferMemory = 0;
	private double bufferMemoryTwo = 0;
	private double result = 0;
	private String percentageResult;
	private double signResult = 0;
	private double rootResult = 0;
	private boolean newNumber = true;

	/*********************************************************************************************************************************
	 * Launch the application.
	 *********************************************************************************************************************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculette window = new Calculette();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**********************************************************************************************************************************
	 * Create the application.
	 *********************************************************************************************************************************/
	public Calculette() {
		initialize();
	}

	/**********************************************************************************************************************************
	 * Initialize the contents of the frame.
	 *********************************************************************************************************************************/
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);

		JPanel screen = new JPanel();
		screen.setToolTipText("");
		screen.setBackground(Color.DARK_GRAY);
		screen.setBounds(24, 47, 438, 104);
		frame.getContentPane().add(screen);
		screen.setLayout(null);

		labelScreen = new JLabel("");
		labelScreen.setBackground(Color.WHITE);
		labelScreen.setBounds(0, 0, 428, 104);
		labelScreen.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.add(labelScreen);

		/*****************************************************************************************************************************
		 * ON-CE button.
		 *****************************************************************************************************************************/
		JButton btn_on = new JButton("ON-C");
		btn_on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (switchOn == false) {
					switchOn = true;
					labelScreen.setText("");
					screen.setBackground(Color.CYAN);
				} else {
					labelScreen.setText("");
					bufferMemory = 0;
				}
			}
		});
		btn_on.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_on.setForeground(Color.WHITE);
		btn_on.setBackground(Color.RED);
		btn_on.setBounds(392, 210, 70, 66);
		frame.getContentPane().add(btn_on);

		/*****************************************************************************************************************************
		 * CE button.
		 *****************************************************************************************************************************/
		JButton btn_ce = new JButton("CE");
		btn_ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ce == false) {
					ce = true;
					labelScreen.setText("");
				}
			}
		});
		btn_ce.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_ce.setBackground(Color.LIGHT_GRAY);
		btn_ce.setBounds(300, 210, 70, 66);
		frame.getContentPane().add(btn_ce);

		/*****************************************************************************************************************************
		 * MRC button.
		 *****************************************************************************************************************************/
		JButton btn_mrc = new JButton("MRC");
		btn_mrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mrcFunction();
			}
		});
		btn_mrc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_mrc.setBackground(Color.LIGHT_GRAY);
		btn_mrc.setForeground(Color.BLACK);
		btn_mrc.setBounds(24, 211, 70, 65);
		frame.getContentPane().add(btn_mrc);

		/*****************************************************************************************************************************
		 * M+ button.
		 *****************************************************************************************************************************/
		JButton btn_m1 = new JButton("M+");
		btn_m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				m1Function();
			}
		});
		btn_m1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_m1.setBackground(Color.LIGHT_GRAY);
		btn_m1.setBounds(119, 211, 70, 65);
		frame.getContentPane().add(btn_m1);

		/*****************************************************************************************************************************
		 * M- button.
		 *****************************************************************************************************************************/
		JButton btn_m2 = new JButton("M-");
		btn_m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				m2Function();
			}
		});
		btn_m2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_m2.setBackground(Color.LIGHT_GRAY);
		btn_m2.setBounds(211, 210, 70, 66);
		frame.getContentPane().add(btn_m2);

		/*****************************************************************************************************************************
		 * Number buttons.
		 *****************************************************************************************************************************/
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(0);
				newNumber = false;
			}
		});
		btn_0.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_0.setBackground(Color.LIGHT_GRAY);
		btn_0.setBounds(24, 538, 70, 65);
		frame.getContentPane().add(btn_0);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(1);
				newNumber = false;
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_1.setBackground(Color.LIGHT_GRAY);
		btn_1.setBounds(24, 462, 70, 65);
		frame.getContentPane().add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(2);
				newNumber = false;
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_2.setBackground(Color.LIGHT_GRAY);
		btn_2.setBounds(118, 463, 70, 65);
		frame.getContentPane().add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(3);
				newNumber = false;
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_3.setBackground(Color.LIGHT_GRAY);
		btn_3.setBounds(211, 463, 70, 65);
		frame.getContentPane().add(btn_3);

		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(4);
				newNumber = false;
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_4.setBackground(Color.LIGHT_GRAY);
		btn_4.setBounds(24, 386, 70, 65);
		frame.getContentPane().add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(5);
				newNumber = false;
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_5.setBackground(Color.LIGHT_GRAY);
		btn_5.setBounds(118, 387, 70, 65);
		frame.getContentPane().add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(6);
				newNumber = false;
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_6.setBackground(Color.LIGHT_GRAY);
		btn_6.setBounds(211, 387, 70, 65);
		frame.getContentPane().add(btn_6);

		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(7);
				newNumber = false;
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_7.setBackground(Color.LIGHT_GRAY);
		btn_7.setBounds(25, 310, 70, 65);
		frame.getContentPane().add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(8);
				newNumber = false;
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_8.setBackground(Color.LIGHT_GRAY);
		btn_8.setBounds(119, 311, 70, 65);
		frame.getContentPane().add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				numberButton(9);
				newNumber = false;
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_9.setBackground(Color.LIGHT_GRAY);
		btn_9.setBounds(211, 311, 70, 65);
		frame.getContentPane().add(btn_9);

		/*****************************************************************************************************************************
		 * Point button.
		 *****************************************************************************************************************************/
		JButton btn_point = new JButton(".");
		btn_point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (point == false) {
					point = true;
					String value = labelScreen.getText() + btn_point.getText();
					labelScreen.setText(value);
					point = false;
				}
			}
		});
		btn_point.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_point.setBackground(Color.LIGHT_GRAY);
		btn_point.setBounds(118, 539, 70, 65);
		frame.getContentPane().add(btn_point);

		/*****************************************************************************************************************************
		 * Square root button.
		 *****************************************************************************************************************************/
		JButton btn_racine = new JButton("\u221A");
		btn_racine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				squareRootFunction();
			}
		});
		btn_racine.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_racine.setBackground(Color.LIGHT_GRAY);
		btn_racine.setBounds(389, 310, 70, 66);
		frame.getContentPane().add(btn_racine);

		/*****************************************************************************************************************************
		 * Percentage button.
		 *****************************************************************************************************************************/
		JButton btn_pourcent = new JButton("%");
		btn_pourcent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				percentageFunction();
			}
		});
		btn_pourcent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_pourcent.setBackground(Color.LIGHT_GRAY);
		btn_pourcent.setBounds(300, 310, 70, 67);
		frame.getContentPane().add(btn_pourcent);

		/*****************************************************************************************************************************
		 * -/+ button.
		 *****************************************************************************************************************************/
		JButton btn_sign = new JButton("+ / -");
		btn_sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (switchOn == true) {
					if (!labelScreen.getText().equals("0")) {
						signResult = Double.valueOf(labelScreen.getText()) * (-1);
					}
				}

				round(signResult);
			}
		});
		btn_sign.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_sign.setBackground(Color.LIGHT_GRAY);
		btn_sign.setBounds(211, 539, 70, 65);
		frame.getContentPane().add(btn_sign);

		/*****************************************************************************************************************************
		 * Operand buttons.
		 *****************************************************************************************************************************/
		JButton btnNewBbtn_soustract = new JButton("-");
		btnNewBbtn_soustract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				subtraction();
				newNumber = true;
			}
		});
		btnNewBbtn_soustract.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewBbtn_soustract.setBackground(Color.LIGHT_GRAY);
		btnNewBbtn_soustract.setBounds(389, 462, 70, 65);
		frame.getContentPane().add(btnNewBbtn_soustract);

		JButton btn_addition = new JButton("+");
		btn_addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addition();
				newNumber = true;
			}
		});
		btn_addition.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_addition.setBackground(Color.LIGHT_GRAY);
		btn_addition.setBounds(300, 462, 70, 141);
		frame.getContentPane().add(btn_addition);
		frame.setBounds(100, 100, 500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn_multipli = new JButton("*");
		btn_multipli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				multiplication();
				newNumber = true;
			}
		});
		btn_multipli.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_multipli.setBackground(Color.LIGHT_GRAY);
		btn_multipli.setBounds(300, 388, 70, 64);
		frame.getContentPane().add(btn_multipli);

		JButton btn_div = new JButton("\u00F7");
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				division();
				newNumber = true;
			}
		});
		btn_div.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_div.setBackground(Color.LIGHT_GRAY);
		btn_div.setBounds(389, 387, 70, 65);
		frame.getContentPane().add(btn_div);

		/*****************************************************************************************************************************
		 * Result button.
		 *****************************************************************************************************************************/
		JButton btn_egal = new JButton("=");
		btn_egal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				resultFunction();
			}
		});
		btn_egal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_egal.setBackground(Color.LIGHT_GRAY);
		btn_egal.setBounds(389, 538, 70, 65);
		frame.getContentPane().add(btn_egal);
	}

	/*********************************************************************************************************************************
	 * Operand functions.
	 *********************************************************************************************************************************/
	public void addition() {

		calculation();

		this.operator = '+';
	}

	public void subtraction() {

		calculation();

		this.operator = '-';
	}

	public void multiplication() {

		calculation();

		this.operator = '*';
	}

	public void division() {

		calculation();

		this.operator = '\u00F7';
	}

	public void resultFunction() {
		System.out.println(this.bufferMemory);
		System.out.println(this.operator);
		System.out.println(labelScreen.getText());

		calculation();

		this.operator = '=';

		round(result);
	}

	/*********************************************************************************************************************************
	 * Percentage function.
	 *********************************************************************************************************************************/
	public void percentageFunction() {

		if (switchOn == true) {
			Double a = Double.parseDouble(labelScreen.getText()) / 100;
			percentageResult = "" + a;
			labelScreen.setText(percentageResult);
			labelScreen.setText("" + a);
		}
	}

	/*********************************************************************************************************************************
	 * Square root function.
	 *********************************************************************************************************************************/
	public void squareRootFunction() {

		if (!labelScreen.getText().isEmpty()) {
			rootResult = Math.sqrt(Double.parseDouble(labelScreen.getText()));
		}

		round(rootResult);
	}

	/*********************************************************************************************************************************
	 * MRC, M+, M- functions.
	 *********************************************************************************************************************************/
	public void mrcFunction() {

		if (switchOn) {
			round(bufferMemoryTwo);
			System.out.println("memory : " + bufferMemoryTwo);
		}
	}

	public void m1Function() {

		if (switchOn) {
			bufferMemoryTwo += Double.parseDouble(labelScreen.getText());
			System.out.println("memory : " + bufferMemoryTwo);
		}
	}

	public void m2Function() {

		if (switchOn) {
			bufferMemoryTwo -= Double.parseDouble(labelScreen.getText());
			System.out.println("memory : " + bufferMemoryTwo);
		}
	}

	/*********************************************************************************************************************************
	 * Calculation function.
	 *********************************************************************************************************************************/
	public void calculation() {

		if (this.operator == '+') {
			this.bufferMemory = this.bufferMemory + Double.parseDouble(labelScreen.getText());

		} else if (this.operator == '-') {
			this.bufferMemory = this.bufferMemory - Double.parseDouble(labelScreen.getText());

		} else if (this.operator == '*') {
			this.bufferMemory = this.bufferMemory * Double.parseDouble(labelScreen.getText());

		} else if (this.operator == '\u00F7') {
			this.bufferMemory = this.bufferMemory / Double.parseDouble(labelScreen.getText());

		}

		else if (this.operator == '=') {
			this.bufferMemory = Double.parseDouble(labelScreen.getText());
		}

		result = this.bufferMemory;

		round(bufferMemory);
	}

	/*********************************************************************************************************************************
	 * Round function.
	 *********************************************************************************************************************************/
	public void round(double result) {
		DecimalFormat round = new DecimalFormat("#.###");
		labelScreen.setText(round.format(result));
	}

	/*********************************************************************************************************************************
	 * NumberButton function.
	 *********************************************************************************************************************************/
	public void numberButton(int digit) {
		if (switchOn == true) {
			if (newNumber == true) {
				labelScreen.setText(digit + "");
			} else {
				labelScreen.setText(labelScreen.getText() + digit);

			}
		}
	}
}