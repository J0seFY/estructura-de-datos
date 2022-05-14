import java.util.LinkedList;

public class TestArbolBinarioLab6 {

    public static void main(String[] args) {
	// write your code here

        /*
    integrantes:  Diego Vásquez
                  José Fuentes
     */
        ArbolBinarioLab6 raiz = new ArbolBinarioLab6(15);
        ArbolBinarioLab6 seis = new ArbolBinarioLab6(6);
        ArbolBinarioLab6 veinte = new ArbolBinarioLab6(20);
        ArbolBinarioLab6 tres = new ArbolBinarioLab6(3);
        ArbolBinarioLab6 nueve = new ArbolBinarioLab6(9);
        ArbolBinarioLab6 dieciocho = new ArbolBinarioLab6(18);
        ArbolBinarioLab6 veinticuatro = new ArbolBinarioLab6(24);
        ArbolBinarioLab6 uno = new ArbolBinarioLab6(1);
        ArbolBinarioLab6 cuatro = new ArbolBinarioLab6(4);
        ArbolBinarioLab6 siete = new ArbolBinarioLab6(7);
        ArbolBinarioLab6 doce = new ArbolBinarioLab6(12);
        ArbolBinarioLab6 diecisiete = new ArbolBinarioLab6(17);
        raiz.iz = seis;
        raiz.der = veinte;
        seis.iz = tres;
        seis.der = nueve;
        tres.iz = uno;
        tres.der = cuatro;
        nueve.iz = siete;
        nueve.der = doce;
        veinte.iz = dieciocho;
        veinte.der = veinticuatro;
        dieciocho.iz = diecisiete;
        ArbolBinarioLab6 nulo = null;


        LinkedList<ArbolBinarioLab6> lista = raiz.nodosAltura(1);

        for(ArbolBinarioLab6 c : lista){
            System.out.println(c.dato);
        }




    }

    public static ArbolBinarioLab6 generaBinario(ArbolBinarioLab6[] nodos, int i, int j){
        if(i>j){
            //caso base
            return null;
        }
        int mitad=(i+j)/2;
        nodos[mitad].iz=generaBinario(nodos, i,mitad-1);
        nodos[mitad].der=generaBinario(nodos,mitad+1,j);
        return nodos[mitad];
    }
}
