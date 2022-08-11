package lab14;

import java.util.*;

/*
    Diego Arteaga
    Samuel Perez
    Rodrigo Jara
    Jose Fuentes
    Sebastian Jouannet
    Leonardo Labrador
    Christian Diaz
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        //Codigo obtenido de https://www.youtube.com/watch?v=uvN4y7E3wZ8
        //fueron modificados algunos nomrbe de variables por comodidad

        //referencia a "-->" (Linea 37) https://stackoverflow.com/questions/29429605/what-does-mean-in-java

        //Explicación de BFS https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

        //List resp: Guarda todos los pesos de los recorridos
        List<List<Integer>> resp = new ArrayList();

        //NodoOrigen && NodoFinal corresponde al nodo inicial y al de llegada
        int NodoOrigen = 0;
        int NodoFinal = graph.length - 1;

        //DatosCola: cada elemento en esta cola representará una lista de enteros que significa una ruta
        Queue<List<Integer>> datosCola = new LinkedList<>();

        //Se agrega el nodo de origen a la Queue en formato lista
        datosCola.add(Arrays.asList(NodoOrigen));

        //Se itera meintras la Queue no este vacia

        //El codigo realiza un BFS o recorrido en anchura, de modo que parte en un nodo inicial, desde el cual vicita a todos los vecinos, luego realiza el mismo procedimiento vicitando los nodos vecinos de los vecinos, de esa         forma genera varios caminos simultaneamente.
        while (!datosCola.isEmpty()) {
            //se inicializa una variable int que equivale al tamaño de la cola
            int size = datosCola.size();
            //itera mientras size sea mayor a 0, cada vez que realiza una comparacion se disminuye en 1
            while (size --> 0) {
                //crea una lista en la cual se almacenara uno de los path posibles y se le asigna como primer valor el primer dato de la cola
                List<Integer> headList = datosCola.poll();

                //verifica si el ultimo nodo de la lista que representa uno de los path posibles es igual al nodo final del grafo, en caso de ser verdadero significa que el camino ya esta complento y el path se                     agrega a la respuesta
                if (headList.get(headList.size() - 1) == NodoFinal) {
                    resp.add(headList);
                }

                //guarda el ultimo nodo de la lista de los path
                int lastNode = headList.get(headList.size() - 1);
                //va a los nodos adyacentes de la ultima posicion y los recorre, validando todas las posibles conexiones
                for (int connection : graph[lastNode]) {
                    //copia la lista de adyacencia, se obtiene el head y se ingren todas las conexiones a esta copyList
                    List<Integer> copyList = new ArrayList<>(headList);
                    //se agregan los nodos adyacentes a la lista copiada y la lista copiada se agrega a la cola, de esta forma almacena la lista en la cola, la cual despues pasa a ser una lista de listas
                    copyList.add(connection);
                    datosCola.add(copyList);
                }
            }
        }

        return resp;
    }
}