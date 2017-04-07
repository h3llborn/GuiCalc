/**
*	Author: Christopher Niesel (0811944)
*	Program Name: LongOperandException.java
*	Date: Apr 3, 2017
*	Class: INFO3061
*	Purpose: An exception class which will throw an exception if an operand is too long for the text field display area
*/

public class LongOperandException extends Exception{
	LongOperandException(String s){
		super("The operand you have entered" + s +" is too long.");
	}
}
