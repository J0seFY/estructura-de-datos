package lab4;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounterLab4 {
    //ejercicio 933 de leetcode

    Queue<Integer> fila;
    public RecentCounterLab4() {
        fila = new LinkedList<>();
    }

    public int ping(int t) {
        //t reprsenta al tiempo el cual se agrega a la Fila anteriormente definida

        fila.add(t);
        //el rango del solicitudes es el del tiempo actual y de los ultimos 3000 milisengudos
        int[] rango = {t-3000,t};
        // el ciclo comienza a eliminar todas las peticiones que salgan del rango [t-300,t]
        while(fila.peek() != null && fila.peek() < rango[0] ){
            fila.poll();
        }

        return fila.size();
    }
}

