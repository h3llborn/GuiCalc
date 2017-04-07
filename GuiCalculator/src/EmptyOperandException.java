/**
*	Author: Christopher Niesel (0811944)
*	Program Name: EmptyOperandException.java
*	Date: Apr 3, 2017
*	Class: INFO3061
*	Purpose: An exception class which will throw an exception if no operand has
*			 been entered before an operation is entered
*/

public class EmptyOperandException  extends Exception{
	
	EmptyOperandException(String op){
		super("You have not entered an operand. Operand was: " + op + "\n Please press a button between 0-9.");
	}

}
