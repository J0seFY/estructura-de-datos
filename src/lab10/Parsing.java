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
                //Se crea una pila para realizar el recorrido
		Stack<Character> p = new Stack<>();
		String s  = "";
                //Se recorre el string del parametro, cuando corresponde a un numero se agrega a la variable s,si es un parwntesis se agrega a la pila
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

		return s;
	}
	//Verifica si el char es un numero entre 0-9
	private static boolean isANumber(char symbol) {
		return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || 
				symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || 
				symbol == '8' || symbol == '9';
	}
	//Retorna un grado de prioridad dependiendo del simbolo
	private static int prioridad(char symbol) {
		if(symbol == '(') return 0;
		if(symbol == '+' || symbol == '-') return 1;
		if(symbol == '*' || symbol == '/') return 2;
		return -1;
	}

	
	public static ArbolExpresion getArbol(String postfijo) {
	//Se crea una pila y se recorre cada elemento del string, cuando corresponde a un numero se crea un arbol con esa simbolo y se agrega a la pila, cuando no son un numero los primeross elementos de la pila se agregan como hijos del arbol recoen creado
        Stack<ArbolExpresion> p = new Stack<ArbolExpresion>();	
        for(int i=0;postfijo.length:i++){
          char s= postfijo.charAt(i);
          ArbolExpresion a = new ArbolExpresion(s);
          if(isANumber(s)){
            p.push(a);
          }else{
            a.left = p.pop();
            a.right = p.pop();
            p.push(a);
        }
//Finalmente se retorna la cabeza de la pila
       return p.pop();
      }
}

