package lab12;//==============================
//Cola Binomial 
//==============================

//integrantes : Christian Diaz y Jose Fuentes
/*
Hicimos dos soluciones, una llamada getSize y Size
Coste algorítmico de getSize : O(1)
Esta función tiene tiempo constante ya que utiliza un atributo de la clase lab12.ColaBinomial llamado size el cual almacena el tamaño del Binomial Heap, comienza en 0 y aumenta
en uno cada vez que se llama el metodo de inserción, por lo tanto al llamar la funcion getSize esta lo único que hace es retornar el valor del atributo size teniendo así
coste constante.

Coste algorítmico de size : O (log n)
Esta función tiene tiempo “log n” ya que obtiene el tamaño de cada binomial tree que pertenece al binomial heap, recorriendo solo la cabeza de cada uno de ellos y
los suma para obtener el total de nodos. Para obtener el tamaño de cada binomial tree es utilizada la propiedad de que el tamaño está dado por 2 elevado al grado del mismo.
En conclusion su tiempo es O(log n) ya que la función solo recorre una parte del árbol y no necesita recorrer la totalidad de n

 */
class ColaBinomial {
	NodoCB head; // Puntero al primer árbol binomial de la cola
	int size;
	ColaBinomial(){
		head=null;
		size = 0;
	} // Constructor

	//funcion size
	public int size(){
		if(head == null){
			return 0;
		}

		NodoCB pointer = head;
		int size =0 ;
		while (pointer != null){
			size += Math.pow(2, pointer.degree);
			pointer = pointer.sibling;
		}

		return size;

	}
	//funcion getSize
	public int getSize(){
		return size;
	}
	
	//==================================================
	//Inserción de un elemento en la cola binomial
	//==================================================
	void Insert(int a) { 
		ColaBinomial H1 = new ColaBinomial();
		H1.head = new NodoCB(null, null, null, a, (short)0);
		head = BinomialHeapUnion(H1);
		size++;
	}

	//============ Imprime cola binomial ===================================
	//La salida de la impresión es código fuente Latex la cual
	//se puede rediccionar a un archivo. Por ejemplo, java lp > micola.tex.
	//Luego el archivo micola.tex se compila con latex micola.tex.
	//=======================================================================
	void Print(){
		System.out.println("\\documentclass[10pt]{article}");
		System.out.println("\\usepackage{graphicx}");
		System.out.println("\\usepackage{pstricks,pst-node,pst-tree}");
		System.out.println("\\title{Cola Binomial}");
		System.out.println("\\begin{document}");
		System.out.println("\\maketitle");
		for(NodoCB l = head; l!=null; l = l.sibling) l.Print();
		System.out.println("\\end{document}");
	}

	//====================================================
	// Método privados 
	//====================================================

	//====================================================
	//Unión (fusión de dos colas binomiales)
	//==================================================== 
	private NodoCB BinomialHeapUnion(ColaBinomial H2){
		ColaBinomial H = BinomialHeapMerge(this, H2);
		if(H.head==null) return H.head;
		NodoCB prevx= null;
		NodoCB x = H.head;
		NodoCB nextx=x.sibling;
		while(nextx!=null) { 
			if ((x.degree != nextx.degree) ||  (nextx.sibling !=null && nextx.sibling.degree == x.degree)){ 
				prevx = x;
				x = nextx;
			}
			else if(x.key <= nextx.key) { 
				x.sibling= nextx.sibling;
				nextx.BinomialLink(x);
			}
			else { 
				if(prevx==null) H.head=nextx;
				else  prevx.sibling= nextx;
				x.BinomialLink(nextx);
				x = nextx;
			}
			nextx = x.sibling;
		}
		return H.head;
	}

	//===========================================================
	// Mezcla de dos colas Binomiales. A partir de dos colas 
	// se obtine una tercera que contiene los árboles binomiales
	// de las dos colas ordenados por k 
	//===========================================================  
	private  ColaBinomial BinomialHeapMerge(ColaBinomial H1, ColaBinomial H2) { 
		NodoCB h1 = H1.head;
		NodoCB h2 = H2.head;
		if (h1==null) return H2;
		if (h2==null) return H1;
		ColaBinomial H = new ColaBinomial();
		NodoCB ini = null;
		NodoCB fin= null;
		while(h1!=null && h2!=null) { 
			if(h1.degree <= h2.degree) { 
				if(ini == null) {ini = fin= h1;} 
				else {fin.sibling = h1; fin = h1;}
				h1 = h1.sibling;
			} 
			else  {
				if(ini == null) {ini = fin= h2;} 
				else {fin.sibling = h2; fin = h2;}
				h2 = h2.sibling; 
			}
		}
		if(h1==null) fin.sibling = h2;
		if(h2==null) fin.sibling = h1;
		H.head=ini;
		return  H;
	}
}
