import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JPanel panel_result;
	private JTextField txtResult;
	private String operator = "";
	private String op1 = "";
	private boolean setClear = false;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_result = new JPanel();
		panel_result.setBackground(Color.LIGHT_GRAY);
		panel_result.setBounds(10, 10, 416, 66);
		contentPane.add(panel_result);
		panel_result.setLayout(null);

		txtResult = new JTextField();
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setForeground(new Color(0, 0, 0));
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtResult.setBackground(new Color(255, 255, 255));
		txtResult.setBounds(10, 10, 396, 46);
		panel_result.add(txtResult);
		txtResult.setColumns(10);

		JPanel panel_btn = new JPanel();
		panel_btn.setBackground(Color.BLACK);
		panel_btn.setBounds(10, 96, 416, 307);
		contentPane.add(panel_btn);
		panel_btn.setLayout(new GridLayout(5, 4, 10, 10));

		JButton btn_clear = new JButton("AC");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText("");
				operator = "";
				op1 = "";
				setClear = false;
			}
		});
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_clear.setBackground(Color.LIGHT_GRAY);
		panel_btn.add(btn_clear);

		JButton btn_opposite = new JButton("+/-");
		btn_opposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigDecimal value = new BigDecimal(txtResult.getText());
					String temp = "-1";
					value = value.multiply(new BigDecimal(temp));
					txtResult.setText(value + "");
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		btn_opposite.setBackground(Color.LIGHT_GRAY);
		btn_opposite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_btn.add(btn_opposite);

		JButton btn_percent = new JButton("%");
		btn_percent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtResult.getText().equals("")) {
					return;
				}
				BigDecimal op1 = new BigDecimal(txtResult.getText());
				BigDecimal result = null;
				String temp = "100";
				try {
					setClear = true;
					result = op1.divide(new BigDecimal(temp));
					txtResult.setText(result + "");
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		btn_percent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_percent.setBackground(Color.LIGHT_GRAY);
		panel_btn.add(btn_percent);

		JButton btn_inverse = new JButton("1/x");
		btn_inverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtResult.getText().equals("")) {
					return;
				}

				try {
					String temp = txtResult.getText();
					double op = Double.parseDouble(temp);

					setClear = true;
					double result = 1 / op;
					txtResult.setText(result + "");

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		btn_inverse.setForeground(Color.WHITE);
		btn_inverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_inverse.setBackground(Color.ORANGE);
		panel_btn.add(btn_inverse);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn7.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn8.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn9.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn9);

		JButton btn_addition = new JButton("+");
		btn_addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOperatorActionPerformed(e);
			}
		});
		btn_addition.setForeground(Color.WHITE);
		btn_addition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_addition.setBackground(Color.ORANGE);
		panel_btn.add(btn_addition);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn4.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn5.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn6.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn6);

		JButton btn_subtract = new JButton("-");
		btn_subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOperatorActionPerformed(e);
			}
		});
		btn_subtract.setForeground(Color.WHITE);
		btn_subtract.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_subtract.setBackground(Color.ORANGE);
		panel_btn.add(btn_subtract);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});

		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn3);

		JButton btn_multiply = new JButton("*");
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOperatorActionPerformed(e);
			}
		});
		btn_multiply.setForeground(Color.WHITE);
		btn_multiply.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_multiply.setBackground(Color.ORANGE);
		panel_btn.add(btn_multiply);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressNumber(e);
			}
		});
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn0.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn0);

		JButton btn_comma = new JButton(".");
		btn_comma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(txtResult.getText() + ".");
			}
		});
		btn_comma.setForeground(Color.WHITE);
		btn_comma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_comma.setBackground(Color.DARK_GRAY);
		panel_btn.add(btn_comma);

		JButton btn_result = new JButton("=");
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtResult.getText().equals("") || op1.equals("")) {
					return;
				}

				try {
					BigDecimal operand1 = new BigDecimal(op1);
					BigDecimal operand2 = new BigDecimal(txtResult.getText());
					BigDecimal result = null;

					switch (operator) {
					case "+":
						result = operand1.add(operand2);
						break;
					case "-":
						result = operand1.subtract(operand2);
						break;
					case "*":
						result = operand1.multiply(operand2);
						break;
					case "/":
						result = operand1.divide(operand2);
						break;
					}

					txtResult.setText(result + "");
					setClear = true;

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		btn_result.setForeground(Color.WHITE);
		btn_result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_result.setBackground(Color.ORANGE);
		panel_btn.add(btn_result);

		JButton btn_divide = new JButton("/");
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOperatorActionPerformed(e);
			}
		});
		btn_divide.setForeground(Color.WHITE);
		btn_divide.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_divide.setBackground(Color.ORANGE);
		panel_btn.add(btn_divide);
	}

	private void btnOperatorActionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		operator = cmd;
		op1 = txtResult.getText();

		txtResult.setText("");
	}

	private void pressNumber(ActionEvent e) {
		if (setClear) {
			setClear = false;
			txtResult.setText("");
		}
		String cmd = e.getActionCommand();
		txtResult.setText(txtResult.getText() + cmd);
	}
}
