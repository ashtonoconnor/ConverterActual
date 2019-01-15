
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SwingConverter implements ActionListener {

	private JPanel inputPanel = initInputPanel();
	private JTextField inputText;
	private JTextArea resultArea;
	private JButton enterButton;
	private JTextField inputnewText;
	private JButton calculateButton;
	
	

	public SwingConverter() { // constructor never has a return type (void, String, etc.)
		JFrame myWindow = new JFrame("Base Converter - Created by Ashton O'Connor");
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.add(inputPanel);
		myWindow.setSize(600, 500);
		myWindow.setVisible(true);

	}

	private JPanel initInputPanel() {

		JPanel panel = new JPanel();

		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		panel.setBackground(java.awt.Color.WHITE);
		panel.setLayout(null);

		JLabel label = new JLabel("Enter a base-10 number: ");
		label.setBounds(50, 50, 220, 30);
		panel.add(label);
		
		JLabel spherelabel = new JLabel("Enter radius: ");
		spherelabel.setBounds(50, 100, 220, 30);
		panel.add(spherelabel);
	

		JTextField text;
		text = inputText = new JTextField();
		text.setBounds(230, 50, 100, 30);
		panel.add(text);
		
		JTextField spheretext;
		spheretext = inputnewText = new JTextField();
		spheretext.setBounds(150, 100, 100, 30);
		panel.add(spheretext);

		
		
		
		
		
		
		
		JButton button = new JButton("Enter");
		button.setActionCommand("Enter");
		button.setBounds(340, 50, 80, 30);
		button.setBackground(java.awt.Color.PINK);
		button.addActionListener(this);
		panel.add(button);
		

		
		// save to the class variable, to be used in other methods
		enterButton = button; // assign it to a class var to be used in other methods
		

		button = new JButton("Reset");
		button.setActionCommand("Reset");
		button.setBounds(430, 50, 80, 30);
		button.setBackground(java.awt.Color.CYAN);
		button.addActionListener(this);
		panel.add(button);
		
		JButton spherebutton = new JButton("Calculate");
		spherebutton.setActionCommand("Calculate");
		spherebutton.setBounds(260, 100, 100, 30);
		spherebutton.setBackground(java.awt.Color.RED);
		spherebutton.addActionListener(this);
		panel.add(spherebutton);
		calculateButton = spherebutton;
		
		spherebutton = new JButton("Reset.");
		spherebutton.setActionCommand("Reset.");
		spherebutton.setBounds(370, 100, 80, 30);
		spherebutton.setBackground(java.awt.Color.BLUE);
		spherebutton.addActionListener(this);
		panel.add(spherebutton);
		
		
		
		
		
		
		
		
		
		
		resultArea = new JTextArea();
		resultArea.setBounds(50, 180, 500, 200);
		resultArea.setEditable(false);
		resultArea.setBackground(java.awt.Color.PINK);
		panel.add(resultArea);

		return panel;
	}

	public static void main(String[] args) throws Exception {
		// SwingConverter baseConverter = new SwingConverter();
		new SwingConverter();

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String command = ev.getActionCommand();
		if (command.equals("Enter")) {
			showResult();
		} else if (command.equals("Reset")) {
			reset();
		} else if (command.equals("Calculate")) {
			showSphereResult();
		}else if (command.equals("Reset.")) {
			sphereReset();
		}
		
	}
	
	private void showSphereResult() {
		inputnewText.setEnabled(false);
		calculateButton.setEnabled(false);
		
		Integer d = getSInputNumber();
		if (d == null) {
			resultArea.append("Invalid number !");
			return;
		}
		
		
		
		
		int radius = d.intValue();
		double b = (Math.PI*4.0)*(Math.pow(radius, 2));
		double c = (Math.PI*(Math.pow(radius, 3))*(4.0/3.0));
		
		resultArea.append("Radius = " + radius + "\n");
		resultArea.append("Surface Area = " + b + "\n");
		resultArea.append("Volume = " + c + "\n" );
	}
	
	private void showResult() {
		// System.out.println("showResult entered");

		String hexUpperCase;
		inputText.setEnabled(false);
		enterButton.setEnabled(false);

		Integer n = getInputNumber();
		if (n == null) {
			resultArea.append("Invalid number !");
			return;
		}

		int baseTenNumber = n.intValue();
		resultArea.append("base 10 = " + baseTenNumber + "\n");
		resultArea.append("binary = " + Integer.toString(baseTenNumber, 2) + "\n");
		resultArea.append("octal = " + Integer.toString(baseTenNumber, 8) + "\n");
		resultArea.append("hexadecimal = " + Integer.toString(baseTenNumber, 16) + "\n");

		hexUpperCase = Integer.toString(baseTenNumber, 16).toUpperCase();
		resultArea.append("hexadecimal = " + hexUpperCase + "\n");
	}

	private void reset() {
		// System.out.println("reset entered");
		inputText.setText("");
		resultArea.setText("");
		inputText.setEnabled(true);
		enterButton.setEnabled(true);
		inputText.requestFocus();
	}
	private void sphereReset() {
		inputnewText.setText("");
		resultArea.setText("");
		inputnewText.setEnabled(true);
		calculateButton.setEnabled(true);
		inputnewText.requestFocus();
	}

	private Integer getInputNumber() {
		
		try {
			Integer n = Integer.parseInt(inputText.getText());
			return n;
		
		} catch (Exception e) {
			//oops! problem with number entry, this traps that error, now tell user the error and let them try an entry again. return null is to prevent a total crash, but it really is not fixing the problem
			return null;
		}
	}
	private Integer getSInputNumber() {
		try {
			Integer n = Integer.parseInt(inputnewText.getText());
			return n;
		
		} catch (Exception e) {
			//oops! problem with number entry, this traps that error, now tell user the error and let them try an entry again. return null is to prevent a total crash, but it really is not fixing the problem
			return null;
	}
	}
}
