package lab13;

import java.util.LinkedList;
import java.util.Stack;


/*explicacion

    para efectos de probar el codigo se incluyo un metodo main y las funciones se definieron de tipo static
    lo primero que hace la solucion es transformar la matriz de aristas en una lista de adyacencia

    una vez que tenemos la lista de adyacencia se llama a el metodo dfs, el cual consiste en un recorrido en profundidad a traves del grafo representado por la lista de adyacencia
    el algoritmo dps consiste en:

    -una pila
    -un array llamado visited en el cual se va marcando los nodos ya visitados
    - para comenzar se agrega el nodo origen o source a la pila y se marca como visitado
    - se inicia un ciclo iterativo que acabara cuando la pila quede vacia
    - se crea una variable para almacenar el vertice actual en el que nos encontramos y se elimina de la pila
    - se verifica si el vertice actual es igual al objetivo o destination, esto quiere decir que existe un path entre source y destination
    -se inicia un ciclo iterativo que recorre todos los vertices adyacentes al vertice actual
    -si dicho nodo aun no ha sido visitado se almacena en la pila y luego se marca como visitado
    -si la pila esta vacia y se cierra el ciclo iterativo significa que no existe un path entre source y destination y retorna false

 */

public class FindIfPathExist {

    public static void main(String[] args) {

        //int [][] m = {{0,1},{1,2},{2,0}};
        int [][] m = {{0,1},{0,2},{3,5},{5,4},{4,3}};

        System.out.println(validPath(6,m,0,5));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        LinkedList<Integer> [] lista = listaAdyacencia(n,edges);

        return dfs(lista,source,destination);
    }

    private static boolean dfs(LinkedList<Integer>[] grafo, int origen, int objetivo){

        Stack<Integer> stack = new Stack<Integer>();
        boolean [] visited = new boolean[grafo.length];
        stack.push(origen);
        visited[origen] = true;
        while (!stack.isEmpty()){
            int nodoActual = stack.pop();
            if(nodoActual == objetivo){
                return true;
            }

            for (int w : grafo[nodoActual]){
                if(visited[w] != true){
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }

        return false;
    }

    private static LinkedList<Integer> [] listaAdyacencia(int n, int[][] edges){
        LinkedList<Integer> [] lista = new LinkedList[n];
        for (int i =0 ;  i < lista.length ; i++){
            lista[i] = new LinkedList<>();
        }

        for (int i =0 ; i < edges.length ; i++){
            lista[edges[i][0]].add(edges[i][1]);
            lista[edges[i][1]].add(edges[i][0]);
        }

        return lista;
    }
}
