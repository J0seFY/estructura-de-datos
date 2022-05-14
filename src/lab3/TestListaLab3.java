package lab3;

import java.util.concurrent.ThreadLocalRandom;

public class TestListaLab3 {

    public static void main(String [] args) {
        ListaLab3 l = new ListaLab3();


        int min = 1;
        int max = 10;
        for(int i=min ; i <= max ; i++){
            l.InsertaFinal(ThreadLocalRandom.current().nextInt(min,max) + min);
        }

        l.Print();
        System.out.println();
        System.out.println("promedio: " + l.promedio());
        System.out.println();
        l.sort();
        l.elementosMayoresAlPromedio();
        l.Print();


    }
}
