package lab11.jueves;

import java.util.Arrays;

public class MaxHeap {

    private int length = 10;
    private int size = 0;
    private int [] items = new int[length];

    public MaxHeap() {

    }

    public MaxHeap(int [] A) {
        // Build heap
        items = A;
        size = A.length;
        length = A.length;
        buildHeap();

        duplicateCapacity();
    }

    public void printHeap() {
        for(int i = 0; i< size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void insert(int item) {
        // insert a new element
        duplicateCapacity();
        items[size] = item;
        size++;
        heapifyUp(size-1);
    }

    public int top() {
        // get items[0]
        if(size > 0)	return items[0];
        else return -1;
    }

    public int delete() {
        // get items[0] and delete it
        if(size > 0) {
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapify(0);
            return item;
        }
        return -1;
    }

    private void duplicateCapacity(){
        // duplicate the capacity of the array
        if(size == length) {
            items = Arrays.copyOf(items, length*2);
            length *= 2;
        }
    }

    private void heapifyUp(int i) {
        // Adjust element i to the correspond pos
        // Implementar esta función
        int p = parent(i);
        if(p >=0) {
            if (items[i] > items[p]) {
                swap(p, i);
                heapifyUp(p);
            }
        }
    }

    private void heapify(int i) {
        // Adjust element i to the correspond pos
        // Sección implementada por sección del miércoles.
        //Almacena las posiciones de los hijos izquierdo y derecho
        int l = leftChild(i);
        int r = rightChild(i);
        int tam = size-1;
        // pos de elemento mayor
        //Verifica que l y r no sean mayores al tamaño del heap
        if(l <= tam) {
            int k;
 
            if(r <= tam) {
                k = items[r] >= items[l] ? r : l;
            }else{
                k = l;
            }
            //Almacena en k la posicion del numero mayor entre l y r
            //si la clave almacenada en la posicion k es mayor a su padre intercambia el padre por k, posteriormente llama recuesivamente a heapify en k para verificar que no se rompa la condicion del hep, casa llamada recursiva hace que se vaya descendiendo a traves del heap. 
            if (items[k] > items[i]) {
                swap(i, k);
                heapify(k);
            }
        }
    }

    private void buildHeap() {
        // Given an array, get the heap
        for(int i = size/2; i >= 0; i--) {
            heapify(i);
        }
    }

    private int parent(int i) {
        return (i-1)/2;
    }
    private int leftChild(int i) {
        return 2*i+1;
    }
    private int rightChild(int i) {
        return 2*i+2;
    }
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
