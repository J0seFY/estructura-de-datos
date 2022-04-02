import java.util.concurrent.ThreadLocalRandom;

public class TestLista {

    public static void main(String [] args) {
        Lista l = new Lista();
        Lista promedio = new Lista();


        int min = 1;
        int max = 10;
        for(int i=min ; i <= max ; i++){
            l.InsertaFinal(ThreadLocalRandom.current().nextInt(min,max) + min);
        }

        int prom = l.sum()/l.Size();

        for(int i=0 ; i < l.Size() ; i++){
            if(l.getNodo(i).elObjeto > prom){
                promedio.InsertaFinal(l.getNodo(i).elObjeto);
            }
        }

        l.Print();
        System.out.println();
        promedio.Print();
        //l.elementosMayoresAlPromedio();

    }
}
