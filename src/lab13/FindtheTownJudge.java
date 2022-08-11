package lab13;


public class FindtheTownJudge {

    public int findJudge(int n, int[][] trust) {
        //creamos un array contador de tamaño n+1 para contalibizar la cantidad de confianza en otros nodos
        //el tamaño es de n+1 ya que la cantidad de personas va de 1 a n y se necesita sumar uno para que el array
        //contenga las posiciones de 0 a n, ya que si no solo contaria con las posiciones 0 a n-1
        int [] contador = new int[n+1];

        for(int i = 0 ;i < trust.length ; i++){

            /*durante este ciclo se por filas trust, cada vez que una persona confia en otra se accede a su
            posicion en el arreglo y se resta uno al que confia y se le suma uno en el que confia
             */
            contador[trust[i][0]-1]--;
            contador[trust[i][1]-1]++;

        }

        /*finalmente recorremos todo el arreglo contador y verificamos si hay alguna posicion que tenga
        un valor almacenado de n-1, esto ya que segun el enunciado para que una persona se considere juez
        no debe confiar en nadie y todos deben confiar en el, esto quiere decir que en ningun momento se le
        resto 1 y cada persona confia en el ya que no hay relaciones de confianza repetidas
        se busca que tenga un valor n-1 ya que  hay n ciudadanos y por restricciones del grafo el juez no puede
        confiar en si mismo por lo que deberia valer n-1

         */
        for(int i=1; i < n+1 ;i++){
                if(contador[i] == n-1) return i;
            }

        //si no se encuentra a nadie se retorna -1
        return -1;
        }
    }

