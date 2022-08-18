package lab16;

public class Hashing {

	/*respuestas
	a) la insercion, eliminicacion y busqueda se tardan mas al aumenta el factor de carga, ya que al aumentar significa que el el arreglo esta cada vez mas lleno
	y por tanto cada vez hay menos espacios disponibles para almacenar elementos, esto hace que se necesita hacer mas calculos de la funcion hash para encontrar un slot vacio
	de la misma forma con la busqueda se hace mas probable que sean necesarias mayor cantidad de iteraciones para encontrar el elemento y algo similar sucede con la
	eliminacion ya que el paso previo efectuar la eliminacion es buscar el nodo en el arreglo.

	b)se crea un nuevo arreglo con el length de 2n respecto al arreglo actual, se insertan todos los elementos del arreglo actual en el nuevo y posteriormente, se elimina
	el arreglo viejo y se define al nuevo como el arreglo del hashing, se tiene en cuenta el factor de carga ya que el duplicado de tamaño solo se hace cuando el factor de carga
	supera el valor de 0.75 para asi mantener la eficiencia en la insercion,busqueda y eliminacion
	 */
	
	class Nodo{
		int key;
		public Nodo(int k) {
			key = k;
		}
	}

	Nodo [] T;
	int size; //cantidad de key insertadas en la tabla
	
	public Hashing(int m) {
		T = new Nodo[m];
		for(int i = 0; i < m; i++) T[i] = null;
		int size = 0;
	}
	
	// Implementar
	// return true si fue posible insertar
	// false en otro caso

	/*en esta implementacion se utiliza hashing doble, lo que quiere decir que la funcion hash usa dos funciones auxiliares
	para solucionar las coliciones
	en la insercion se inicializa la variable i, la cual nos ayuda en la busqueda de nuevos espacios para almacenar la key
	en caso de que la posicion inicial se encuentre ocupada
	 */
	public boolean insertar(int key) {

		int i = 0 ;

		//este ciclo se repite mientras i < T.length ya que de ser mayor significa que todo el arreglo esta lleno
		while( i < T.length){
			int j = h(key,i);
			//verifica si la posicion j esta vacia para guardar ahi la key, en caso de no estar llena se incrementa en 1 en valor de i y se vulve a repetir
			if(T[j] == null){
				T[j] = new Nodo(key);
				size++;
				return true;
			}else{
				i++;
			}
		}

		return false;
	}
	
	// Implementar
	// Si la clave no existe, return null

	//el algoritmo es muy similar a la insercion en su forma de recorrer el arreglo
	public Nodo buscar(int key) {
		int i = 0 ;

		while( i < T.length){
			int j = h(key,i);

			/*si la posicion es null significa que no existe la key ya que no se pudo haber agregado el las posiciones posteriores generadas por h sin antes haberse agregado a la
			primera
			 */
			if (T[j] == null) {
				return null;
			}else if(T[j].key == key ){
				return T[j];
			}else {
				i++;
			}
		}

		return null;
	}

	private int buscarPos(int key) {
		int i = 0 ;

		while( i < T.length){
			int j = h(key,i);

			if (T[j] == null) {
				return -1;
			}else if(T[j].key == key ){
				return j;
			}else {
				i++;
			}
		}

		return -1;
	}
	
	// Implementar
	// return true si fue posible eliminar
	// false en otro caso
	public boolean eliminar(int key) {
		/*buscarPos es una funcion privada igual al buscar, con la diferencia que este en vez de retornar el nodo en donde esta almacenado el key
		retorna la posicion del nodo con la key, si no la encuentra retorna -1
		 */
		int j = buscarPos(key);
		//verifica exista el nodo con ese key y luego deja como null esa posicion, eliminando de esa forma el nodo del array
		if(j != -1){
			T[j] = null;
			return true;
		}

		return false;


	}

	/*usando el atributo size el cual aumenta en cada insercion, la divide en e length del arreglo , dando asi un numero >= 0 y <=1
	de esta forma se puede saber que tan cargado esta la tabla
	 */

	public double getFactorDeCarga(){
		return size/ T.length;
	}

	public void printHash(){

		for (Nodo n :
				T) {
			System.out.print(n.key + " | ");
		}
	}
	
	
	int h(int k, int i) {
		return (h1(k) + (i * h2(k))) % T.length;
	}
	
	int h1(int k) {
		return k % T.length;
	}
	
	int h2(int k) {
		return 1 + (k % (T.length-1));
	}
	
}
