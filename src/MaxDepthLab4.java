import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthLab4 {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int  maxDepth(String s) {

        int izquierda =0;
        int profundidad =0;

        Stack<Character> pila = new Stack<>();

        for (int i=0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i)==')'){
                pila.push(s.charAt(i));
            }
        }

        int tamanio = pila.size();
        for(int i=0 ; i < tamanio ;i++){
            if(pila.peek() == '('){
                izquierda--;
            }else {
                izquierda++;
            }
            profundidad = Math.max(izquierda,profundidad);
            pila.pop();
        }

        return profundidad;

    }
}
