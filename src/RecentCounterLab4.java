import java.util.LinkedList;
import java.util.Queue;

class RecentCounterLab4 {

    Queue<Integer> fila;
    public RecentCounterLab4() {
        fila = new LinkedList<>();
    }

    public int ping(int t) {

        fila.add(t);

        int[] rango = {t-3000,t};

        while(fila.peek() != null && fila.peek() < rango[0] ){
            fila.poll();
        }

        return fila.size();
    }
}

