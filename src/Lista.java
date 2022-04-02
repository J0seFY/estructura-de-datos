public class Lista {

    private Nodo laCabeza;

    Lista() {
        laCabeza = null;
    }

    //---Inserta un objeto(int) al comienzo de la lista
    public void InsertaInicio(int o) {
        if (EstaVacia()) laCabeza = new Nodo(o, null);
        else laCabeza = new Nodo(o, laCabeza);
    }

    //---- Inserta al final ----
    public void InsertaFinal(int o) {
        if (EstaVacia()) laCabeza = new Nodo(o, null);
        else {
            Nodo t;
            for (t = laCabeza; t.next != null; t = t.next) ;
            ;
            t.next = new Nodo(o, null);
        }
    }

    // ---cuenta la cantidad de nodos de la lista (Size)
    public int Size() {
        int tnodos = 0;
        for (Nodo t = laCabeza; t != null; t = t.next) tnodos++;
        return tnodos;
    }

    //eliminar un nodo de la lista
// Elimina el primer nodo n tal que o.elObjeto==o
    public void Eliminar(int o) {
        if (!EstaVacia()) {
            if (laCabeza.elObjeto == o) laCabeza = laCabeza.next;
            else {
                Nodo p = laCabeza;
                Nodo t = laCabeza.next;
                while (t != null && t.elObjeto != o) {
                    p = t;
                    t = t.next;
                }
                if (t.elObjeto == o) p.next = t.next;
            }
        }
    }

    // Verifica si la lista está vacias;
    public boolean EstaVacia() {
        return laCabeza == null;
    }

    //-----Imprime la lista-----
    public void Print() {
        if (laCabeza != null) Imprimir(laCabeza);
        else System.out.println("Lista Vacia");
    }

    void Imprimir(Nodo m) {
        if (m != null) {
            m.Print();
            Imprimir(m.next);
        }
    }

    //-----Clase Nodo---------
    class Nodo {
        public int elObjeto;
        public Nodo next;

        public Nodo(int nuevoObjeto, Nodo next) {
            this.elObjeto = nuevoObjeto;
            this.next = next;
        }

        void Print() {
            System.out.print("- " + elObjeto);
        }
    }

    public Nodo getNodo(int pos){

        Nodo pointer = laCabeza;
        int aux = 0;
        while (pointer != null && aux != pos ){
            aux++;
            pointer = pointer.next;

        }
        return pointer;
    }

    public int sum(){
        int sum=0;
        Nodo pointer = laCabeza;
        while (pointer != null) {
            sum += pointer.elObjeto;
            pointer = pointer.next;
        }
        return sum;
    }


    public  void elementosMayoresAlPromedio() {

        /*primero se crea un algoritmo para calcular el promedio de todos
        los elementos de la lista
         */

        int size = 0;
        int sum = 0;
        Nodo pointer = laCabeza;
        while (pointer != null) {
            sum += pointer.elObjeto;
            pointer = pointer.next;
        }

        int promedio = sum / Size();

        System.out.println("size: " + Size() + " sum: " + sum + " promedio: " + promedio);

        /*el siguiente ciclo se utiliza para obtener la nueva
        cabeza
         */
        while (promedio >= laCabeza.elObjeto) {
            laCabeza = laCabeza.next;
        }

        /*se crea un pointer para ir moviendonos a traves de la lista enlazada
        y otro Node llamado newList en el cual iremos enlazando la nueva lista
         */
        pointer = laCabeza;
        Nodo newList = laCabeza;

        /*en vista que ya hicimos un proceso para que asegurarnos que la cabecera
        es superior al promedio las comparaciones las hacemos a partir del nodo siguiente
         */
        while (pointer.next != null){
            if(pointer.next.elObjeto > promedio ){

                newList.next = pointer.next;
                newList = newList.next;
            }

            pointer = pointer.next;
        }



    }
}

