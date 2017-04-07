import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

/**
 *	Author: Christopher Niesel (0811944)
*	Program Name: GUICalculator.java
*	Date: Apr 3, 2017
*	Class: INFO3061
*	Purpose: A GUI class which instantiates a Calculator object and performs calculator operations on that object 
*/

public class GUICalculator extends JFrame {
	// function button
	JButton addBtn,subtractBtn, multiplyBtn, divideBtn, modBtn, clearBtn, backSpcBtn,
			prctBtn,tglBtn,sqrtBtn,sqrBtn,emptyBtn1,emptyBtn2,calcBtn,decBtn;
	// number button
	JButton oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,sevenBtn,eightBtn,nineBtn,zeroBtn;
	// output textfield
	JTextField calcText;
	// menubar and items
	JMenuBar menuBar = new JMenuBar();
	ButtonGroup group = new ButtonGroup();
	JMenu menuFile = new JMenu("File");
	JMenu menuConvert = new JMenu("Convert");
	JMenu menuHelp = new JMenu("Help");
	JMenuItem itExit = new JMenuItem("Exit");
	JMenuItem  itHex = new JMenuItem ("Hex");
	//JMenuItem  itDec = new JMenuItem ("Dec");
	JMenuItem  itOct = new JMenuItem ("Oct");
	JMenuItem  itBin = new JMenuItem ("Bin");
	JMenuItem itHowToUse = new JMenuItem("How To Use");
	JMenuItem itAbout = new JMenuItem("About");
	Calculator calc;
	JFrame dialog = new JFrame();
	//constructor
	public GUICalculator(){
		// set up layout
		super("Calculator");
		this.setSize(300,365);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		// initalize calculator
		calc = new Calculator();
		// create button listener
		ButtonNanny bn = new ButtonNanny();
		// set up font
		Font font = new Font("SansSerif",Font.PLAIN,22);
		// setup Menus
		menuFile.add(itExit);
		itExit.addActionListener(bn);
		//convert menu
		menuConvert.add(itHex);
		itHex.addActionListener(bn);
		//menuConvert.add(itDec);
		//itDec.addActionListener(bn);
		menuConvert.add(itOct);
		itOct.addActionListener(bn);
		menuConvert.add(itBin);
		itBin.addActionListener(bn);
		// help menu
		menuHelp.add(itHowToUse);
		itHowToUse.addActionListener(bn);
		menuHelp.add(itAbout);
		itAbout.addActionListener(bn);
		
		menuBar.add(menuFile);
		menuBar.add(menuConvert);
		menuBar.add(menuHelp);
		this.setJMenuBar(menuBar);

		// set up buttons (function)
		addBtn = new JButton("+");
		addBtn.setFont(font);
		addBtn.setBackground(Color.WHITE);
		addBtn.addActionListener(bn);
		subtractBtn = new JButton("-");
		subtractBtn.setFont(font);
		subtractBtn.setBackground(Color.WHITE);
		subtractBtn.addActionListener(bn);
		multiplyBtn = new JButton("X");
		multiplyBtn.setFont(font);
		multiplyBtn.setBackground(Color.WHITE);
		multiplyBtn.addActionListener(bn);
		divideBtn = new JButton("/");
		divideBtn.setFont(font);
		divideBtn.setBackground(Color.WHITE);
		divideBtn.addActionListener(bn);
		clearBtn = new JButton("C");
		clearBtn.setFont(font);
		clearBtn.setBackground(Color.WHITE);
		clearBtn.addActionListener(bn);
		backSpcBtn = new JButton("\u2190");
		backSpcBtn.setFont(font);
		backSpcBtn.setBackground(Color.WHITE);
		backSpcBtn.addActionListener(bn);
		prctBtn = new JButton("%");
		prctBtn.setFont(font);
		prctBtn.setBackground(Color.WHITE);
		prctBtn.addActionListener(bn);
		tglBtn = new JButton("\u00B1");
		tglBtn.setFont(font);
		tglBtn.setBackground(Color.WHITE);
		tglBtn.addActionListener(bn);
		sqrtBtn = new JButton("sqrt");
		sqrtBtn.setFont(font);
		sqrtBtn.setBackground(Color.WHITE);
		sqrtBtn.addActionListener(bn);
		sqrBtn = new JButton("x^2");
		sqrBtn.setFont(font);
		sqrBtn.setBackground(Color.WHITE);
		sqrBtn.addActionListener(bn);
		emptyBtn1 = new JButton();
		emptyBtn1.setFont(font);
		emptyBtn1.setBackground(Color.WHITE);
		emptyBtn2 = new JButton();
		emptyBtn2.setFont(font);
		emptyBtn2.setBackground(Color.WHITE);
		calcBtn = new JButton("=");
		calcBtn.setFont(font);
		calcBtn.setBackground(Color.WHITE);
		calcBtn.addActionListener(bn);
		decBtn = new JButton(".");
		decBtn.setFont(font);
		decBtn.setBackground(Color.WHITE);
		decBtn.addActionListener(bn);
		// set up buttons (numbers)
		oneBtn = new JButton("1");
		oneBtn.setFont(font);
		oneBtn.setBackground(Color.WHITE);
		oneBtn.addActionListener(bn);
		twoBtn = new JButton("2");
		twoBtn.setFont(font);
		twoBtn.setBackground(Color.WHITE);
		twoBtn.addActionListener(bn);
		threeBtn= new JButton("3");
		threeBtn.setFont(font);
		threeBtn.setBackground(Color.WHITE);
		threeBtn.addActionListener(bn);
		fourBtn = new JButton("4");
		fourBtn.setFont(font);
		fourBtn.setBackground(Color.WHITE);
		fourBtn.addActionListener(bn);
		fiveBtn = new JButton("5");
		fiveBtn.setFont(font);
		fiveBtn.setBackground(Color.WHITE);
		fiveBtn.addActionListener(bn);
		sixBtn = new JButton("6");
		sixBtn.setFont(font);
		sixBtn.setBackground(Color.WHITE);
		sixBtn.addActionListener(bn);
		sevenBtn = new JButton("7");
		sevenBtn.setFont(font);
		sevenBtn.setBackground(Color.WHITE);
		sevenBtn.addActionListener(bn);
		eightBtn = new JButton("8");
		eightBtn.setFont(font);
		eightBtn.setBackground(Color.WHITE);
		eightBtn.addActionListener(bn);
		nineBtn = new JButton("9");
		nineBtn.setFont(font);
		nineBtn.setBackground(Color.WHITE);
		nineBtn.addActionListener(bn);
		zeroBtn = new JButton("0");
		zeroBtn.setFont(font);
		zeroBtn.setBackground(Color.WHITE);
		zeroBtn.addActionListener(bn);
		
		
		// add calculator text output
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		calcText = new JTextField("0.0",15);
		calcText.setEditable(false);
		calcText.setBackground(Color.WHITE);
		calcText.setFont(font);
		calcText.setHorizontalAlignment(JTextField.RIGHT);
		topPanel.add(calcText);
		this.add(topPanel,BorderLayout.NORTH);
		// set up calculator button panel
		JPanel funcPanel = new JPanel();
		//funcPanel.setBackground(Color.WHITE);
		funcPanel.setLayout(new GridLayout(6,4,4,4));
		funcPanel.add(clearBtn);
		funcPanel.add(backSpcBtn);
		funcPanel.add(prctBtn);
		funcPanel.add(tglBtn);
		funcPanel.add(sqrBtn);
		funcPanel.add(sqrtBtn);
		funcPanel.add(emptyBtn1);
		funcPanel.add(divideBtn);
		funcPanel.add(sevenBtn);
		funcPanel.add(eightBtn);
		funcPanel.add(nineBtn);
		funcPanel.add(multiplyBtn);
		funcPanel.add(fourBtn);
		funcPanel.add(fiveBtn);
		funcPanel.add(sixBtn);
		funcPanel.add(subtractBtn);
		funcPanel.add(oneBtn);
		funcPanel.add(twoBtn);
		funcPanel.add(threeBtn);
		funcPanel.add(addBtn);
		funcPanel.add(emptyBtn2);
		funcPanel.add(zeroBtn);
		funcPanel.add(decBtn);
		funcPanel.add(calcBtn);
		
		//add buttons
		this.add(funcPanel);
		
		// add 
		this.setVisible(true);
		
		
	
	}//end constructor
	// inner class
	private class ButtonNanny implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			// These are the number buttons 0-9
			// each time they are called they will check if we are at zero or not
			// if we are not we will add to it and update the textbox
			if(ev.getSource().equals(oneBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 1; // add one
				calcText.setText(hold); // update text
			}
			else if(ev.getSource().equals(twoBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 2; // add two
				calcText.setText(hold); // update text
			}
			else if(ev.getSource().equals(threeBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 3;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(fourBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 4;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(fiveBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 5;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(sixBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 6;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(sevenBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 7;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(eightBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 8;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(nineBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 9;
				calcText.setText(hold);
			}
			else if(ev.getSource().equals(zeroBtn)){
				String hold = calcText.getText();
				if(hold.equals("0.0"))
					hold = "";
				hold += 0;
				calcText.setText(hold);
			}
			// backspace button
			else if(ev.getSource().equals(backSpcBtn)){
				if(!calcText.getText().equals("0.0")){ // if we aren't at starting point
					// delete characters and update text box
					calcText.setText(calc.backspace(calcText.getText()));
				}
			}
			// reset calculator
			else if(ev.getSource().equals(clearBtn)){
				calcText.setText("0.0");
				calc.clean();
			}
			// check if we have decimal inserted or not,
			else if(ev.getSource().equals(decBtn)){
				if(!calcText.getText().equals("0.0") && !calc.isDecimalPressed()){
					// if we haven't add decimal and set it so in the calculator class
					String hold = calcText.getText();
					hold += ".";
					calcText.setText(hold);
					calc.setDecimalPressed(true);
				}
			}
			// plus minus toggle button
			else if(ev.getSource().equals(tglBtn)){
				if(!calcText.getText().equals("0.0")){
					String hold = calcText.getText();
					// using a stringbuilder to append or remove the negative
					StringBuilder n = new StringBuilder(hold);
					if(n.charAt(0) != '-'){
						n.insert(0, '-');
						calcText.setText(n.toString()); // update box
					}
					else if(n.charAt(0) == '-'){
						n.deleteCharAt(0);
						calcText.setText(n.toString()); // update box
					}
					
				}
			}
			// find percentage as decimal point
			else if(ev.getSource().equals(prctBtn)){
				if(!calcText.getText().equals("0.0")){
					try {
						// call calculator method
						calcText.setText(calc.findPercentage(calcText.getText()));
					} catch (EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			// square inputed value
			else if(ev.getSource().equals(sqrBtn)){
				try {
					// call square method
					calcText.setText(calc.findSquared(calcText.getText()));
				} catch (EmptyOperandException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage()); // update
				}
			}
			// square root method
			else if(ev.getSource().equals(sqrtBtn)){
				try {
					// get square root
					calcText.setText(calc.findSquareRoot(calcText.getText()));
				} catch (EmptyOperandException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			// addition button
			else if(ev.getSource().equals(addBtn)){
				if(!calcText.getText().equals("0.0")){ // check if are not at reset
					//System.out.println("add: "+calcText.getText());
					try {
						calc.buildOperand(calcText.getText()); // build operand
					} catch (LongOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					try {
						calc.buildExpression("+"); // call expression builder
					} catch (ArithmeticException | EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					calcText.setText("0.0"); // reset to 0.0 so that next number can be inputted
				}
			}
			// divide button
			else if(ev.getSource().equals(divideBtn)){
				if(!calcText.getText().equals("0.0")){
					try {
						calc.buildOperand(calcText.getText()); // build operand
					} catch (LongOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					try {
						calc.buildExpression("/"); // add expression
					} catch (ArithmeticException | EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					calcText.setText("0.0"); // reset
				}
			}
			// multiply
			else if(ev.getSource().equals(multiplyBtn)){
				if(!calcText.getText().equals("0.0")){
					try {
						calc.buildOperand(calcText.getText()); // build operand
					} catch (LongOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					try {
						calc.buildExpression("*"); // add math expression
					} catch (ArithmeticException | EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					calcText.setText("0.0"); // reset
				}
			}
			// subtract
			else if(ev.getSource().equals(subtractBtn)){
				if(!calcText.getText().equals("0.0")){
					try {
						calc.buildOperand(calcText.getText()); // get numbers
					} catch (LongOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					try {
						calc.buildExpression("-"); // add math operator
					} catch (ArithmeticException | EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					calcText.setText("0.0"); // reset
				}
			}
			// calculate button
			else if(ev.getSource().equals(calcBtn)){
				if(!calcText.getText().equals("0.0")){ // ensure we are not at reset
					calc.setOperand(calcText.getText()); // get last inputted operand and set it in calc class
					try {
						double answer = calc.calculate(); // calculate answer
						calcText.setText(Double.toString(answer)); // output answer
						calc.setDecimalPressed(true); // since its a double we have a decimal
					} catch (ArithmeticException | EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
			}
			// menu buttons
			else if(ev.getSource().equals(itAbout)){
				// about dialog
				JOptionPane.showMessageDialog(dialog, "Created by Chris Niesel","About",JOptionPane.INFORMATION_MESSAGE);
			}
			// exit program
			else if(ev.getSource().equals(itExit)){
				System.exit(0);
			}
			// how to use dialog
			else if(ev.getSource().equals(itHowToUse)){
				JOptionPane.showMessageDialog(dialog, "This app behaves like any other calculater\n"
						+ "Enter a number and either press +,-,*,/ and then another number;\n"
						+ "or you can use the function buttons on whatever number you have entered.","How To Use",JOptionPane.INFORMATION_MESSAGE);
			}
			// conversion menu
			// convert to binary
			else if(ev.getSource().equals(itBin)){
				if(!calcText.getText().equals("0.0")){
					try {
						calcText.setText(calc.convertBin(calcText.getText())); // get conversion and update
					} catch (EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			// convert to octal
			else if(ev.getSource().equals(itOct)){
				if(!calcText.getText().equals("0.0")){
					try {
						calcText.setText(calc.convertOct(calcText.getText())); // get conversion and update
					} catch (EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			// convert to hex
			else if(ev.getSource().equals(itHex)){
				if(!calcText.getText().equals("0.0")){
					try {
						calcText.setText(calc.convertHex(calcText.getText())); // get conversion and update
					} catch (EmptyOperandException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			
		}// action performed end
		
	}//end inner class
	
	public static void main(String[]args){
		new GUICalculator(); // anonymous object declaration
	}
	
}
