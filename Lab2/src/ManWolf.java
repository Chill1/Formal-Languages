/*
  * file: ManWolf.java
  * author: Charlie Hill
  * course: CMPT 440
  * assignment: Lab 2
  * due date: February 15, 2016
  * version: 1.0
  * 
  * This file contains the ManWolf program itself
  */
public class ManWolf {
	private static final int q0 = 0;
	private static final int q1 = 1;
	private static final int q2 = 2;	
	private static final int q3 = 3;	
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;	
	private static final int q7 = 7;	
	private static final int q8 = 8;	
	private static final int q9 = 9;
	private static final int q10 = 10; //error state
	
	private static int state = q0;
	
	static private int [][] delta =
		{			
			/* q0 */ {q1, q10, q10, q10},
			/* q1 */ {q0, q10, q10, q2},
			/* q2 */ {q10, q3, q4, q1},
			/* q3 */ {q5, q2, q10, q10},
			/* q4 */ {q6, q10, q2, q10},
			/* q5 */ {q3, q10, q7, q10},
			/* q6 */ {q4, q7, q10, q10},
			/* q7 */ {q10, q5, q10, q8},
			/* q8 */ {q9, q10, q10, q7},
			/* q9 */ {q8, q10, q10, q10},
			/* q10 */ {q10, q10, q10, q10}, //error state
			
		};
	
/*
* process
* 
* This function evaluates the string that the user inputs and routes it according to the matrix.
*   
* @param 
* 		s: this is the string that the user input  
* 
* @return
* 		A string: sends back whether or not what the user entered was a solution
*/		
	public static String process (String in){
		for (int i = 0; i < in.length(); i++) {
			char curr = in.charAt(i);
			if (curr == 'g') {
				state = delta[state][0];
			}
			else if (curr == 'w') {
			    state = delta[state][1];
			}
			else if (curr == 'c') {
				state = delta[state][2];
			}
			else if (curr == 'n') {
			    state = delta[state][3];
			}
		}
		if (state == 9){
			return "This is a solution.";
		}
		else {
			return "That is not a solution.";
		}	  
	}

}


