import java.util.concurrent.ThreadLocalRandom;

public class TestLista {

    public static void main(String [] args) {
        Lista l = new Lista();


        int min = 1;
        int max = 10;
        for(int i=min ; i <= max ; i++){
            l.InsertaFinal(ThreadLocalRandom.current().nextInt(min,max) + min);
        }

        l.Print();
        System.out.println();
        l.elementosMayoresAlPromedio();
        l.Print();

        //l.elementosMayoresAlPromedio();

    }
}
