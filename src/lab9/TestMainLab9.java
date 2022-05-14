package lab9;

public class TestMainLab9 {

	public static void main(String[] args) {
		/*
		 * Escriba aqu� su c�digo
		 */

		AvlTreeLab9 avl = new AvlTreeLab9();
		BSTreeLab9 bst = new BSTreeLab9();

		System.out.println("Insercion de datos");
		System.out.println("---------------------------------------------------------------");

		long startTimeAvl = System.nanoTime();

		//el maximo de datos que se pueden usar antes de que ocurra un error de memoria con el bst es de 15000
		//generar datos al azar

		//prueba de insercion de datos
		for(int i = 0 ; i < 15000;i++){
			avl.insert(i);
		}
		System.out.println("AVL: " +((double) (System.nanoTime() - startTimeAvl)/0.0000000001));

		//generar datos al azar
		long startTimeBst = System.nanoTime();
		for(int i = 0 ; i < 15000;i++){
			bst.insert(i);
		}

		System.out.println("BST: " +((double) (System.nanoTime() - startTimeBst)/0.0000000001));

		//prueba de tiempo de busqueda de elementos que se encuentran insertados

		System.out.println("---------------------------------------------------------------");
		System.out.println("Busqueda de datos si ingresados");
		System.out.println("---------------------------------------------------------------");

		startTimeAvl = System.nanoTime();
		for (int i=0 ; i < 15000 ; i++){
			avl.search(i);
		}
		System.out.println("AVL: " + ((double) (System.nanoTime() - startTimeAvl)/0.0000000001));

		startTimeBst = System.nanoTime();
		for (int i=0 ; i < 15000 ; i++){
			avl.search(i);
		}
		System.out.println("BST: " + ((double) (System.nanoTime() - startTimeBst)/0.0000000001));


		//tiempo de busqueda de datos no ingresados
		System.out.println("---------------------------------------------------------------");
		System.out.println("Busqueda de datos no ingresados");
		System.out.println("---------------------------------------------------------------");

		startTimeAvl = System.nanoTime();
		for (int i=15000 ; i < 30000 ; i++){
			avl.search(i);
		}
		System.out.println("AVL: " + ((double) (System.nanoTime() - startTimeAvl)/0.0000000001));

		startTimeBst = System.nanoTime();
		for (int i=15000 ; i < 30000 ; i++){
			avl.search(i);
		}
		System.out.println("BST: " + ((double) (System.nanoTime() - startTimeBst)/0.0000000001));


		
	}

}
