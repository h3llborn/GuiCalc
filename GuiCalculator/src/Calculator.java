import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/**
*	Author: Christopher Niesel (0811944)
*	Program Name: Calculator.java
*	Date: Apr 3, 2017
*	Class: INFO3061
*	Purpose: A class to be used to create a Calculator object  
*/

public class Calculator {

	private String operand;
	private String operator;
	private boolean decimalPressed;
	private ArrayList<String> list;
	
	public Calculator(){
		this.operand = "0.0";
		this.operator = "";
		this.decimalPressed = false;
		this.list = new ArrayList<String>();
	}


	/*
	 * Method Name: clean()
	 * Purpose: re-set all fields to their default values 
	 * Accepts: nothing
	 * Returns: nothing
	 */
	public void clean(){
		this.operand = "0.0";
		this.operator = "";
		this.decimalPressed = false;
		this.list.clear();
	}
	/*
	 * Method Name: backspace(String value)
	 * Purpose: Return value with the last number or decimal removed
	 * Accepts: a string
	 * Returns: last number or decimal removed
	 */
	public String backspace(String value) {
		int length = value.length();
		int n = value.length() - 1; 
		if(length > 0){
			StringBuilder back = new StringBuilder(value); // easy way to deleting characters at a specific position
			if(back.charAt(n) == '.') // reset decimal
				this.decimalPressed = false;
			back.deleteCharAt(n);
			return back.toString();
		}
		else
			return "0.0"; // reset to 0.0 if we don't have anything left
		
	}
	/*
	 * Method Name: findPercentage(String value) throws EmptyOperandException
	 * Purpose: Return the current value as a percentage in decimal format 
	 * Accepts: a value to find the percentage of
	 * Returns: the value as a percentage in decimal format
	 */
	public String findPercentage(String value) throws EmptyOperandException{
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			double hold = Double.parseDouble(value) / 100;
			return Double.toString(hold);
		}
	
	}
	/*
	 * Method Name: togglePlusMinus(boolean flag)
	 * Purpose: Add “-“ to the beginning of operand or remove “-“ from the operand
	 * 			depending on the value of flag 
	 * Accepts: a boolean flag
	 * Returns: nothing.
	 */
	public void tooglePlusMinus(boolean flag) throws EmptyOperandException{
		if(operand.equals("")){
			throw new EmptyOperandException(operand);
		}
		else{
			double hold = Double.parseDouble(operand);
			if(flag){
				hold *=-1.0;
				}
			else
				hold *=-1.0;
			operand = Double.toString(hold);
		}
	
	}
	/*
	 * Method Name: findSquared(String value)throws EmptyOperandException
	 * Purpose: Return the square of the current value  
	 * Accepts: a value to be squared
	 * Returns: the squared value
	 */
	public String findSquared(String value)throws EmptyOperandException {
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			double hold = Double.parseDouble(value);
			hold *= hold;
			this.decimalPressed = true;
			return Double.toString(hold);
		}
		
	}
	/*
	 * Method Name: findSquareRoot(String value) throws EmptyOperandException
	 * Purpose: Return the square root of the current value  
	 * Accepts: a value to of which to be taken the square root
	 * Returns: the squareRoot of the value
	 */
	public String findSquareRoot(String value)throws EmptyOperandException {
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			double hold = Math.sqrt(Double.parseDouble(value));
			this.decimalPressed = true;
			return Double.toString(hold);
		}
	
	}
	/*
	 * Method Name: buildOperand(String value)throws LongOperandException, InvalidOperandException
	 * Purpose: Concatenate the current value to operand  
	 * Accepts: a string 
	 * Returns: nothing
	 */
	public void buildOperand(String value)throws LongOperandException{
		//System.out.println("buildOper:" + operand);
		if(value.length() > 150){
			throw new LongOperandException(value);
		}
		else
			operand =value;
	}
	/*
	 * Method Name: buildExpression(String value)throws EmptyOperandException, ArithmaticException
	 * Purpose: assign the value to operator and add both the operand and operator to the list
				and clear fields   
	 * Accepts: a string 
	 * Returns: nothing
	 */
	public void buildExpression(String value)throws EmptyOperandException, ArithmeticException {
		/* do some building */
		if(operand.equals(""))
			throw new EmptyOperandException(operand);
		else
			operator = value;
		if(operator.equals("/") || operator.equals("*") || operator.equals("+") || operator.equals("-")){
			list.add(operand);
			list.add(operator);		
			// clear string
			this.operand="0.0";
			this.operator="";
			this.decimalPressed = false;
			
		}
		else{
			
			throw new ArithmeticException(operator);
		}
		
	}
	/*
	 * Method Name: buildExpression(String value)  throws EmptyOperandException
	 * Purpose: add the current operand to the list 
				calculate the answer, using the values in the list applying the rules of BEDMAS 
				clear fields 
				return the answer to the expression
	 * Accepts: nothing
	 * Returns: calculated answer
	 */
	public double calculate()throws EmptyOperandException, ArithmeticException{
		// do bedmas
		if(operand.equals("")){
			throw new EmptyOperandException(operand);
		}else{
			this.list.add(operand); // add operand entered after operator
			//System.out.println(list.toString());
			double result=0;
			// do multiplication first
			while(this.list.contains("*")){
				int n = this.list.indexOf("*");// location of operator
				// find location of operands and multiply
				result = Double.parseDouble(this.list.get(n-1)) * Double.parseDouble(this.list.get(n+1)); 
				// set location of operator to answer
				//remove operators by taking into account shift in length of arraylist
				this.list.set(n, Double.toString(result));
				this.list.remove(n-1);
				this.list.remove(n);
			}
			// then if we have any division do that
			while(this.list.contains("/")){
				int n = this.list.indexOf("/");// location of operator
				// check for division by 0
				if(this.list.get(n+1).equals("0") || this.list.get(n+1).equals("0.0")){
					result = 0.0;
				}
				else{
					result = Double.parseDouble(this.list.get(n-1)) / Double.parseDouble(this.list.get(n+1)); // divide operands
				}
				this.list.set(n, Double.toString(result)); // set location of operator to answer
				this.list.remove(n-1); // remove operands 
				this.list.remove(n);// (adjust for shift) due to removal
			}
			
			// do adding then subtracting
			result = Double.parseDouble(this.list.get(0));
			for(int i = 1;i<this.list.size();i +=2){ // add by 2 to get the next operator
				String op = this.list.get(i);
				double val = Double.parseDouble(this.list.get(i+1)); // get number
				// switch first addition then subtraction
				switch(op){
				case "+" :
		            result += val;
		            break;
		        case "-" :
		            result -= val;
		            break;
				}
			}
			// reset variables
			this.operand = "0.0";
			this.operator = "";
			this.decimalPressed = false;
			this.list.clear();
			return result; // return result
		}

	}
	/*
	 * Method Name: convertHex(String value)
	 * Purpose: convert a value to Hexadecimal
	 * Accepts: a value
	 * Returns: hexadecimal answer
	 */
	public String convertHex(String value) throws EmptyOperandException{
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			// round
			int hold = (int)Math.round(Double.parseDouble(value));
			String digits = "0123456789ABCDEF"; // hex values
			if(hold == 0)
				return "0";
			String hexValue = "";
			while(hold > 0){ // if we have more than 0 numbers
				int digit = hold % 16; // get far right value
				hexValue = digits.charAt(digit) + hexValue; // add to hex string
				hold = hold / 16; // continue division
			}
			return hexValue;
		}

	}
	/*
	 * Method Name: convertDec(String value)
	 * Purpose: convert a value to decimal equivalent
	 * Accepts: a value
	 * Returns: decimal answer
	 */
//	public String convertDec(String value) throws EmptyOperandException{
//		
//	}
	/*
	 * Method Name: convertOct(String value)
	 * Purpose: Return value converted to its octal equivalent 
	 * Accepts: a value
	 * Returns: octal answer
	 */
	public String convertOct(String value)throws EmptyOperandException{
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			int rem; // remainder
			int hold = (int)Math.round(Double.parseDouble(value)); // round
			String string = "";
			char digits[] = {'0','1','2','3','4','5','6','7','8'};
			if(hold == 0)
					return "0";
			while(hold >0){ // get remainder for var divided by 8
				 rem=hold%8; 
			       string=digits[rem]+string;  // add to string
			       hold=hold/8; // continue division by 8
			}
			return string;
		}

	}
	/*
	 * Method Name: convertBin(String value)  
	 * Purpose: Return value converted to its binary equivalent 
	 * Accepts: a value
	 * Returns: binary answer
	 */
	public String convertBin(String value)throws EmptyOperandException{
		/*NumberFormat nf = NumberFormat.getInstance(Locale.CANADA); 
		Number n;*/
		if(value.equals("")){
			throw new EmptyOperandException(value);
		}
		else{
			double d = Double.parseDouble(value);
			// round number
			int hold = (int)Math.round(d);
			System.out.println("rounded number in bin" + hold);
			String temp = ""; // output string
		    while (hold > 0)
		    {
		        temp =  ( (hold % 2 ) == 0 ? "0" : "1") +temp; // check if current value is even, if so add a 0
		        hold = hold / 2; // divide total by two get the next number
		    }
		    // pad string
		    StringBuilder bn = new StringBuilder(temp);
		    System.out.println("string length:" + bn.length());
		    if(bn.length()<12){
		    	bn.insert(0,'0');
		    }
		    
		    temp = bn.toString();
		    return temp.replaceAll("(.{4})(?!$)", "$1 "); // proper format
		}
	
	}
	// Getters and Setters for all fields, excluding list.
	/*
	 * Method Name: getOperand()  
	 * Purpose: return value of current operand
	 * Accepts: a value
	 * Returns: a string with the operand
	 */
	public String getOperand() {
		return operand;
	}

	/*
	 * Method Name: setOperand(String operand)  
	 * Purpose: set current operand
	 * Accepts: a value
	 * Returns:nothing
	 */
	public void setOperand(String operand) {
		this.operand = operand;
	}

	/*
	 * Method Name: getOperator()  
	 * Purpose: return value of current operator
	 * Accepts:nothing
	 * Returns: a string with the operator
	 */
	public String getOperator() {
		return operator;
	}
	/*
	 * Method Name: setOperator(String operator)  
	 * Purpose: set current operator
	 * Accepts: a value
	 * Returns:nothing
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/*
	 * Method Name: isDecimalPressed()  
	 * Purpose: determine if decimal has been presssed
	 * Accepts:nothing
	 * Returns: true if pressed
	 */
	public boolean isDecimalPressed() {
		return decimalPressed;
	}

	/*
	 * Method Name: setDecimalPressed(boolean decimalPressed)  
	 * Purpose: set value of decimal pressed
	 * Accepts: boolean
	 * Returns: nothing
	 */
	public void setDecimalPressed(boolean decimalPressed) {
		this.decimalPressed = decimalPressed;
	}
}
