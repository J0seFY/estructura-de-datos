package lab4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthLab4 {

    //ejercicio 1614 leetcode

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int  maxDepth(String s) {

        int izquierda =0;
        int profundidad =0;

        Stack<Character> pila = new Stack<>();
        // se almacenan todos los parentesis en una pila
        for (int i=0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' || s.charAt(i)==')'){
                pila.push(s.charAt(i));
            }
        }

        int tamanio = pila.size();
        // se recorre la pila verificando si es un ( , cuando lo es se disminuye el indicador de izquierda y si no aumentando
        // finalmente se estable la profundidad como el numero mayor entre izquierda o el valor actual de profundidad y se sigue iterando hasta recorrer toda la pila
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
