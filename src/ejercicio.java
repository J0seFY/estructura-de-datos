import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class ejercicio {



    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Hashtable<String,Hashtable<String,Double>> list = new Hashtable<String,Hashtable<String,Double>>();



        for(int i = 0 ; i < equations.size() ; i++){

            String nodo1= equations.get(i).get(0);
            String nodo2 = equations.get(i).get(1);

            Double valor1 = values[i];
            Double valor2 = 1/valor1;

            if(!list.contains(nodo1)){
                list.put(nodo1,new Hashtable<String,Double>());
            }

            list.get(nodo1).put(nodo2,valor1);

            if(!list.contains(nodo2)){
                list.put(nodo2,new Hashtable<String,Double>());
            }

            list.get(nodo2).put(nodo1,valor2);

        }

        double [] output = new double[queries.size()];

        for(int i= 0 ; i < output.length ; i++){
            output[i] = getValor(list,queries.get(i).get(0),queries.get(i).get(0));
        }


        return output;

    }


    private double getValor( Hashtable<String,Hashtable<String,Double>> list ,String source,String destination){

        if(source.equals(destination)){
            if(list.containsKey(source)){
                return 1;
            }else{
                return -1;
            }
        }

        Hashtable<String, Double> acumulado = new Hashtable<String, Double>();

        Stack<String> pila = new Stack<String>();
        pila.push(source);
        acumulado.put(source,1.0);

        while(!pila.isEmpty()){

            String nodoActual = pila.pop();
            double acum = acumulado.get(nodoActual);

            if(acumulado.containsKey(nodoActual)){

                Hashtable<String,Double> vecinos = list.get(nodoActual);

                Enumeration<String> e = vecinos.keys();


                while (e.hasMoreElements()) {
                    String key = e.nextElement();
                    double acumVec  = vecinos.get(key)*acum;

                    if(!acumulado.containsKey(key)){

                        if(key.equals(destination)){return acumVec;}

                        pila.push(key);
                        acumulado.put(key,acumVec);

                    }

                }



            }


        }
        return -1;
    }
}