//debido a la estructura en estrela del grafo los nodos solo estan conectados con el central
//solo basta con verificar dos aristas y encontrar el vertice repetido en ambas
//los dos vertices de las primeras aristas se almacenan en j e i , luego se comparan con la siguiente arista y se retorna el que se repite

class FindCenterOfStarGraph{
    public int findCenter(int[][] edges) {
        
        int j =  edges[0][0];
        int i = edges[0][1];
        
        if( j == edges[1][0] || j == edges[1][1]){
            return j;
        }
        
        return i;
        
    }
}
