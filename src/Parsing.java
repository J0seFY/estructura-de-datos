import java.util.Stack;

public class Parsing {

    public static String fromInfijoToPostfijo(String infijo) {
        String s = "";

        Stack<Character> p =  new Stack<>();

        for(int i = 0 ; i < infijo.length() ; i++){
            char c  =infijo.charAt(i);

            if(isANumber(c)){
                s=  s + c;
            }else if(c == '('){
                p.push(c);
            }else if(c== ')'){
                while(p.peek() == '('){
                    s= s + p.pop();
                }
            }else if(!isANumber(c)){
                if(p.empty()){
                    p.push(c);
                }else{
                    if(prioridad(c) > prioridad(p.peek())){
                        p.push(c);
                    }else{
                        s= s + p.pop();
                        p.push(c);
                    }
                }
            }
        }
        while(!p.empty()){
            s = s + p.pop();
        }

        return s;
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

        Stack<ArbolExpresion> p = new Stack<>();
        for (int i=0 ; i < postfijo.length() ; i++){
            char c = postfijo.charAt(i);
            ArbolExpresion a = new ArbolExpresion(c);
            if(isANumber(c)){
                p.push(a);
            }else{
                a.left = p.pop();
                a.right = p.pop();
                p.push(a);
            }
        }

        return p.pop();
    }

}
