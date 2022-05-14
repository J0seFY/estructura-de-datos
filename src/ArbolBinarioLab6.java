import java.util.LinkedList;

public class ArbolBinarioLab6 {

    /*
    integrantes:  Diego Vásquez
                  José Fuentes
     */
    int dato;
    ArbolBinarioLab6 iz;
    ArbolBinarioLab6 der;
    LinkedList<ArbolBinarioLab6> listaDeNodos = new LinkedList<>();


    public ArbolBinarioLab6(int dato){
        this.dato=dato;
        iz=null;
        der=null;
    }

    public ArbolBinarioLab6(int dato, ArbolBinarioLab6 iz, ArbolBinarioLab6 der){
        this.dato=dato;
        this.iz=iz;
        this.der=der;
    }
    public void preOrden(){
        System.out.print(this.dato+" ");
        if(iz!=null) iz.preOrden();
        if(der!=null) der.preOrden();
    }

    public void inOrden(){
        if(iz!=null) iz.preOrden();
        System.out.print(this.dato+" ");
        if(der!=null) der.preOrden();
    }

    public void posOrden(){
        if(iz!=null) iz.preOrden();
        if(der!=null) der.preOrden();
        System.out.print(this.dato+" ");
    }

    //cantidad de nodos-1 del camino más largo de la raiz a sus hojas
    public int altura(){
        return altura(this);
    }

    private int altura(ArbolBinarioLab6 raiz){
        if(raiz==null){
            return -1;
        }
        return 1 + Math.max(altura(raiz.iz),altura(raiz.der));

    }



    //size: cantidad de nodos del árbol
    public int size(){
        return size(this);
    }

    private int size(ArbolBinarioLab6 raiz){
        if (raiz==null){
            return 0;
        }
        return 1 + size(raiz.iz) + size(raiz.der);
    }

    public void tree(){
        tree(this, "");
    }

    public LinkedList<ArbolBinarioLab6> nodosAltura(int h){

        /*usando una linkedList creada como atributo se realiza un recorrido en preorden
            para cada nodo se verifica usando la funcion auxilar altura si la altura de dicho nodo es igual a h
            en caso de serlo de agrega a la linkedList
        */

        if( this == null){
            return new LinkedList<>();
        }


        if(altura(this) == h){
            listaDeNodos.addLast(this);
        }

        if(iz != null){
            iz.listaDeNodos = this.listaDeNodos;
            iz.nodosAltura(h);
        }
        if(der != null){
            der.listaDeNodos = this.listaDeNodos;
            der.nodosAltura(h);
        }


        return listaDeNodos;
    }

    private void tree(ArbolBinarioLab6 raiz, String tab) {
        if(raiz!=null){
            System.out.println(tab+"->"+raiz.dato);
            tree(raiz.iz, tab+"  |");
            tree(raiz.der, tab+"  ");
        }
    }


    }

