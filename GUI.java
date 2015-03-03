package assignment2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements Runnable, ActionListener{
	private JFrame _frame;

//  JPanels
	public JPanel _mainPanel;
	private JPanel _decimalPanel;
	private JPanel _singlePanel;
	private JPanel _doublePanel;
	
//	Other components
	private JTextField _decimalInput;
	private JTextField _singleInput;
	private JTextField _doubleInput;
	
//  convertButtons
	private JButton _decimalConvertButton;
	private JButton _singleButton;
	private JButton _doubleButton;
	
	public GUI(){
	
	}
	
	public void run() {
		_frame = new JFrame("Decimal and IEEE-754 Binary Converter");
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new GridLayout(7,0));
		_frame.add(_mainPanel);

//	Row 1: program title	
		JLabel titleLabel = new JLabel("Decimal and IEEE-754 Binary Converter", JLabel.CENTER);
		_mainPanel.add(titleLabel);

//	Row 2: decimal Label, decimal convert button and decimal input field
		_decimalPanel = new JPanel();
		_decimalPanel.setLayout(new GridLayout(0,3));
		JLabel decimalLabel = new JLabel("Decimal Number:", JLabel.RIGHT);
		_decimalInput = new JTextField();
		_decimalConvertButton = new JButton("Convert");
		_decimalConvertButton.addActionListener(this);
		_mainPanel.add(_decimalPanel);
		_decimalPanel.add(decimalLabel);
		_decimalPanel.add(_decimalInput);
		_decimalPanel.add(_decimalConvertButton);
		
//	Row 3: Single Precision label and convert button
		_singlePanel = new JPanel();
		_singlePanel.setLayout(new GridLayout(0,3));
		JLabel singleLabel = new JLabel("IEEE-754 Single-Precision Floating-Point Binary Representation:", JLabel.CENTER);
		_singleButton = new JButton("Convert to Decimal");
		_singleButton.addActionListener(this);
		_singleInput = new JTextField();	
		_mainPanel.add(_singlePanel);	
		_singlePanel.add(singleLabel);
		_singlePanel.add(_singleInput);
		_singlePanel.add(_singleButton);
				
//  Row 4: double precision label and convert button
		_doublePanel = new JPanel();
		_doublePanel.setLayout(new GridLayout(0,3));
		_mainPanel.add(_doublePanel);
		_doubleInput = new JTextField();
		JLabel doubleLabel = new JLabel("IEEE-754 Double-Precision Floating-Point Binary Representation:", JLabel.CENTER);
		_doubleButton = new JButton("Convert to Decimal");
		_doubleButton.addActionListener(this);
		_doublePanel.add(doubleLabel);
		_doublePanel.add(_doubleInput);
		_doublePanel.add(_doubleButton);
		
//	Row 5: Footer
		JLabel footer = new JLabel("Dennis M. Weppner", JLabel.CENTER);
		_mainPanel.add(footer);

//	packs the frame for user
		_frame.pack();
	}
	
//	ActionListener for the convert Buttons	
	public void actionPerformed(ActionEvent e) {
		String tempDecString;
		if (e.getSource() == _decimalConvertButton){
			
//	Code executed when button pressed to convert from Decimal to single and double precision ieee-754 standard
			double conversionDecimal;
			tempDecString = _decimalInput.getText();
			String singleBitString;
			String doubleBitString;
			conversionDecimal = Double.parseDouble(tempDecString);
			int singleBitValue;
			float f = (float)conversionDecimal;
			singleBitValue = Float.floatToIntBits(f);
			singleBitString = Integer.toBinaryString(singleBitValue);
			while (singleBitString.length() < 32){
				singleBitString = "0"+singleBitString;
			}
			doubleBitString = Long.toString(Double.doubleToLongBits(conversionDecimal), 2);
			while (doubleBitString.length() < 64){
				doubleBitString = "0"+doubleBitString;
			}
			JFrame tempFrame = new JFrame();
			tempFrame.setVisible(true);
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tempFrame.getContentPane().setLayout(new BoxLayout(tempFrame.getContentPane(), BoxLayout.Y_AXIS));
			JPanel decPopupPanel = new JPanel();
			decPopupPanel.setLayout(new GridLayout(3,0));
			tempFrame.add(decPopupPanel);
			JLabel decPopupLineOne = new JLabel("The decimal number: "+_decimalInput.getText());
			decPopupPanel.add(decPopupLineOne);
			JLabel decPopupLineTwo = new JLabel("IEEE-754 Single-Precision Floating-Point Binary Representation: "+singleBitString);
			decPopupPanel.add(decPopupLineTwo);
			JLabel decPopupLineThree = new JLabel("IEEE-754 Double-Precision Floating-Point Binary Representation: "+doubleBitString);
			decPopupPanel.add(decPopupLineThree);
			tempFrame.pack();
			
		} else if (e.getSource() == _singleButton){
			
//	Code executed when button pressed to convert from Single precision to Decimal			
    		float deciFinal;
    		String ieee754 = "";
    		ieee754 = _singleInput.getText();
    		deciFinal = Float.intBitsToFloat(Integer.parseInt(ieee754, 2));
    		JFrame tempFrame = new JFrame();
			tempFrame.setVisible(true);
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tempFrame.getContentPane().setLayout(new BoxLayout(tempFrame.getContentPane(), BoxLayout.Y_AXIS));
			JPanel decPopupPanel = new JPanel();
			decPopupPanel.setLayout(new GridLayout(3,0));
			tempFrame.add(decPopupPanel);
			JLabel singlePopupLineOne = new JLabel("The Decimal number is: "+deciFinal);
			decPopupPanel.add(singlePopupLineOne);	
			tempFrame.pack();
			
		} else if (e.getSource() == _doubleButton){
			
//	Code executed when button pressed to convert from double precision to decimal
			double deciFinalD;
			String ieee754 = "";
			ieee754 = _doubleInput.getText();
			ieee754 = ieee754.trim();
			deciFinalD = Double.longBitsToDouble(Long.parseLong(ieee754,2));
			JFrame tempFrame = new JFrame();
			tempFrame.setVisible(true);
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tempFrame.getContentPane().setLayout(new BoxLayout(tempFrame.getContentPane(), BoxLayout.Y_AXIS));
			JPanel decPopupPanel = new JPanel();
			decPopupPanel.setLayout(new GridLayout(3,0));
			tempFrame.add(decPopupPanel);
			JLabel doublePopupLineOne = new JLabel("The Decimal number is: "+deciFinalD);
			decPopupPanel.add(doublePopupLineOne);		
			tempFrame.pack();
		}	
	}
}
