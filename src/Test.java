import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(solution("aaabbb"));
    }

    public static boolean solution(String cadena){
        Stack<Character> pila = new Stack<>();
        int a=0,b=0;

        for(int i=0 ; i < cadena.length();i++){
            pila.push(cadena.charAt(i));
        }

        while(!pila.isEmpty()){
            if(pila.pop()== 'a'){
                a++;
            }else{
                b++;
            }
        }

        return a==b;
    }
}
