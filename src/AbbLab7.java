/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;

/**
 *
 * @author Carola
 */
public class AbbLab7 {
	class NodoAbb {
		int elemento;
		NodoAbb lchild;
		NodoAbb rchild;

		NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
			this.elemento = elemento;
			this.lchild = lchild;
			this.rchild = rchild;
		}

		void Print() {
			System.out.println(elemento);
		}
	}

	private NodoAbb laRaiz;
	private LinkedList<NodoAbb> recorrido ;

	public AbbLab7() {
		laRaiz = null;
		recorrido = new LinkedList<>();
	}

	/* Verifica si existen dos enteros a, b en el ABB tal que a+b =0.
	 */
	public boolean Complemento() {

		recorrido.clear();
		preOrder(laRaiz);

		for (NodoAbb c: recorrido) {
			if(buscar(laRaiz,c.elemento*-1)){
				return true;
			}
		}

		return false;

	}


	public boolean buscar(NodoAbb nodo, int x){

		if(nodo == null){
			return false;
		}

		if(nodo.elemento == x){
			return true;
		}

		if(x < nodo.elemento){
			return buscar(nodo.lchild,x);
		}else{
			return buscar(nodo.rchild,x);
		}


	}

	private void preOrder(NodoAbb nodo){

		if(nodo != null){
			recorrido.add(nodo);
		}

		if(nodo.lchild != null){
			preOrder(nodo.lchild);
		}
		if(nodo.rchild != null){
			preOrder(nodo.rchild);
		}
	}


	private boolean comple(NodoAbb n) {

		return false;
	}

	//--- Supone que no existe un nodo con valor = elemento----//
	public void Insertar(int elemento) {
		laRaiz = InsertaenAbb(laRaiz, elemento);
	}

	private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
		if (nodo == null)
			return new NodoAbb(elemento, null, null);
		else if (elemento < nodo.elemento)
			nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
		return nodo;
	}

	// -- Supone que el elemento esta en el arbol----//
	public void Eliminar(int elemento) {
		laRaiz = EliminaenAbb(laRaiz, elemento);
	}

	private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
		if (nodo.elemento == elemento) {
			if (nodo.lchild == null && nodo.rchild == null)
				return null;
			else if (nodo.lchild == null)
				return nodo.rchild;
			else if (nodo.rchild == null)
				return nodo.lchild;
			else {
				nodo.elemento = MayorElemento(nodo.lchild);
				nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
			}
		} else if (nodo.elemento > elemento)
			nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
		return nodo;
	}

	private int MayorElemento(NodoAbb nodo) {
		if (nodo.rchild == null)
			return nodo.elemento;
		else
			return MayorElemento(nodo.rchild);
	}

	public void Imprimir() {
		ImprimeAbb(laRaiz, " ");
	}

	private void ImprimeAbb(NodoAbb n, String tab) {
		if (n != null) {
			System.out.println(tab + n.elemento);
			ImprimeAbb(n.lchild, tab + "  ");
			ImprimeAbb(n.rchild, tab + "  ");
		}
	}







}
