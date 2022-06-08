package lab10;

import java.util.Stack;

/**
 * 
 * @author Martita
 * 
 * Para más info, visitar https://es.stackoverflow.com/questions/26907/infijo-a-posfijo-en-java
 * Y http://informatica.uv.es/iiguia/AED/laboratorio/P6/pr_06_2005.html
 *
 */

public class Parsing {
	
	public static String fromInfijoToPostfijo(String infijo) {

		Stack<Character> p = new Stack<>();
		String s  = "";
		for(int i = 0 ;  i < infijo.length() ; i++){
			char c = infijo.charAt(i);
			if(isANumber(c)){
				s = s + c;
			}else if(c == '('){
				p.push(c);
			}else if(c==')'){
				p.push(c);
			}
		}

		return null;
	}
	
	private static boolean isANumber(char symbol) {
		return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || 
				symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || 
				symbol == '8' || symbol == '9';
	}
	
	private static int prioridad(char symbol) {
		if(symbol == '(') return 0;
		if(symbol == '+' || symbol == '-') return 1;
		if(symbol == '*' || symbol == '/') return 2;
		return -1;
	}

	
	public static ArbolExpresion getArbol(String postfijo) {
		return null;
	}
}
