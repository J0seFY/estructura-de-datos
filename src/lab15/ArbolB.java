package lab15;

/*ademas de utilizacion() y size() en esta clase se añadio el atributo size y las funciones y metodos int cantidadNodos(NodoArbolB actual) y int getCantidadNodos() para
desarrollar la solucion del problema
 */


public class ArbolB{
  NodoArbolB root;
  int t ; // grado mínimo
  int size;// tamaño arbol


  //Constructor--CREATE()
  public ArbolB(int gradoMinimo) {
   t= gradoMinimo;
   root = new NodoArbolB(t);
   // ALLOCATE-NODE()
  // DISK-WRITE(root);
 } 



 private double utilizacion(){
      int totalNodos  =getCantidadNodos();//obtiene la cantidad total de nodos del arbol b
      int totalClaves = size();//obtiene la cantidad de claves que tiene el arbol b
      int MaximoClaves = root.key.length * totalNodos; //calcula la cantidad total de espacios disponibles para almacenar claves
     // para el calculo se multiplica el tamaño del array de claves de la raiz(para todos los nodos es el mismo valor) por el total de nodos del arbol


     //finalmente utilizando la regla de 3 se obtiene el porcentaje y se hace un casteo a double ya que todos los valores son int para asi evitar errores
     return (double) (totalClaves * 100)/MaximoClaves;
 }


//metodo usado en utilizacion, este metodo se encarga de recorrer todos los nodos del arbol para asi obtener su total
 private int cantidadNodos(NodoArbolB actual){

      //caso base en el que el nodo actual es nulo
      if(actual == null){
          return 0;
      }

      //variable que se utiliza para almacenar recursivamente la cantidad de nodos
      int acum = 0;
      //se recorre todo el array c que almacena los hijos del nodo actual y se van sumando en acum la cantidad de hijos
     for (NodoArbolB n :
             actual.c) {
         acum +=cantidadNodos(n);
     }

     //al llegar al final se retorna el valor acumulado de su cantidad de hijos mas si mismo, asi de manera recursiva se obtiene el total de nodos
     return 1 + acum;


 }

//metodo que simplemente retorna la cantidad de nodos
 public int getCantidadNodos(){

      return cantidadNodos(root);
 }

 /*usando un atributo size el cual se aumenta en 1 cada vez que se realiza una insercion el metodo size() simplemente se encarga de retornar el atributo
teniendo asi un coste O(1)
 */
 public int size(){
        return size;
    }


// ---------
// Busqueda
result  Search(int k){
 return search(root, k);
}

//-----------------------
//Inserción de una clave
public void Insert(int k){
 NodoArbolB r = root;
 if(r.n==2*t-1){
    NodoArbolB s = new NodoArbolB(t);
    root = s;
    s.leaf=false;
    s.n=0;
    s.c[0]=r;
    splitChild(s,0,r);
    insertnotFull(s,k) ;
 }
 else insertnotFull(r,k);

 size++;
    System.out.println(utilizacion()+"% ocupado");
}

//-------------------------
// Eliminación de una clave 
// Suponemos que la clave existe en el arbol B 
public void Delete(int k) { 
      root = delete(root, k); 
 }

public void Imprimir() {
  if(root==null) System.out.println("Arbol Vacio");
   else imprimir(" ", root);
   }

public int Minimo(){ 
  if(root == null) return -1 ; // Suponemos las claves positivas 
  else return minimo(root);
 } 
//---- metodos privados-------------
//-----------------------------------
private int minimo(NodoArbolB n) { 
if(n.c[0]==null) return n.key[0];
  else return minimo(n.c[0]);
}
private result search(NodoArbolB x, int k){
 int i = 0;
 while(i < x.n && k > x.key[i]) i++;
 if(i <= x.n && k== x.key[i]) return new result(x,i);
 if(x.leaf) return new result(null,-1);
  else { 
    //DISK-READ(x.c[i])
    return search(x.c[i], k);
  } 
}

 void insertnotFull(NodoArbolB x, int k){ 
  int i=x.n-1;
  if(x.leaf){ 
   while(i>=0 && k < x.key[i]) {
     x.key[i+1] = x.key[i];
     i--;
   }
   x.key[i+1]= k;
   x.n++;
   //DISK-WRITE(x)
 }
 else  {
   while(i>=0 && k < x.key[i]) i--;
   i++;
   //DISK-READ(x.c[i])
   if(x.c[i].n == 2*t-1) {
     splitChild(x,i,x.c[i]);
     if(k> x.key[i]) i++;
   } 
   insertnotFull(x.c[i],k);
  }
 }
//---SPLIT de  un nodo
private void splitChild(NodoArbolB x, int i, NodoArbolB y){
 NodoArbolB z = new NodoArbolB(t);
 z.leaf = y.leaf;
 z.n = t-1;
 for(int j=0; j < t-1; j++) z.key[j]=y.key[j+t];
 if(!y.leaf) for(int j=0; j < t; j++) z.c[j]=y.c[j+t];
 y.n = t-1;
 for(int j=x.n; j==i+1; j--) x.c[j+1]=x.c[j];
 x.c[i+1]=z;
 for(int j=x.n-1; j==i; j--) x.key[j+1]=x.key[j];
 x.key[i]=y.key[t-1];
 x.n++;
 //DISK-WRITE(y)
 //DISK-WRITE(X)
 //DISK-WRITE(Y)
}
private void imprimir(String d, NodoArbolB p) {
   if(p!=null) {
     int i;
     p.Imprimir(d);
     System.out.println();
     for(i=0; i<=p.n; i++)imprimir(" "+ d, p.c[i]);
    }
  }
 

private NodoArbolB delete(NodoArbolB x, int k) { 
 int i = 0;
 while(i < x.n && k > x.key[i]) i++;
 if(i <= x.n && k== x.key[i]) { 
  if(x.leaf) {
    System.out.println("Hoja");
    for(int j=i; j  < x.n-1; j++) x.key[j] = x.key[j+1];
    x.n--;
   return x;
   }
   else 
    return x;
  }
 return x;
}

}//end clase ArbolB

 
