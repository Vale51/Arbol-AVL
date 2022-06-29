/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolavl;

/**
 *
 * @author user
 */
public class Arbol {
    private Nodo raiz;
    
    //Constructor
    public Arbol(){
        raiz=null;
    }
    public Nodo obtenerRaiz(){
    return raiz;
    }
    //Método Buscar
    public Nodo busqueda(int d, Nodo r){
    if (raiz==null){
     return null;
    }else if(r.dato==d){
        return r;
    }else if(r.dato<d){
        return busqueda (d,r.hijoDcho);
    }else{
        return busqueda(d,r.hijoIzq);
    }
  }
    //Método para obtener factor de equilibrio
    public int ObtenerFE(Nodo x){
        if(x==null){
        return -1;
        }else{
        return x.fe;
        }
    }
    //Método Rotación Izquierda
    public Nodo RotacionIzq(Nodo c){
    Nodo aux=c.hijoIzq;
    c.hijoIzq=aux.hijoDcho;
    aux.hijoDcho=c;
    c.fe = Math.max(ObtenerFE(c.hijoIzq), ObtenerFE(c.hijoDcho)) + 1;
    aux.fe = Math.max(ObtenerFE(aux.hijoIzq), ObtenerFE(aux.hijoDcho)) + 1;
    return aux;
    }
    //Método Rotación Derecha
    public Nodo RotacionDcho(Nodo c){
    Nodo aux=c.hijoDcho;
    c.hijoDcho=aux.hijoIzq;
    aux.hijoIzq=c;
    c.fe = Math.max(ObtenerFE(c.hijoIzq), ObtenerFE(c.hijoDcho)) + 1;
    aux.fe = Math.max(ObtenerFE(aux.hijoIzq), ObtenerFE(aux.hijoDcho)) + 1;
    return aux;
    }
    //Método Rotación Doble Izquierda
    public Nodo RotacionDobleIzq(Nodo c){
    Nodo aux;
    c.hijoIzq = RotacionDcho(c.hijoDcho);
    aux = RotacionIzq(c);
    return aux;
    }
    //Método Rotación Doble Derecha
    public Nodo RotacionDobleDcho(Nodo c){
    Nodo aux;
    c.hijoDcho = RotacionIzq(c.hijoIzq);
    aux = RotacionDcho(c);
    return aux;
    }
    //Método Insertar Balanceado
    public Nodo insertar(Nodo nuevo, Nodo subarbol){
    Nodo nuevoPadre = subarbol;
    if(nuevo.dato<subarbol.dato){
        if(subarbol.hijoIzq==null){
        subarbol.hijoIzq=nuevo;
        }else{
        subarbol.hijoIzq=insertar(nuevo,subarbol.hijoIzq);
        if(ObtenerFE(subarbol.hijoIzq)-ObtenerFE(subarbol.hijoDcho)==2){
            if(nuevo.dato<subarbol.hijoIzq.dato){
            nuevoPadre=RotacionIzq(subarbol);
            }else{
            nuevoPadre=RotacionDobleIzq(subarbol);
            }
          }
        }
    }else if(nuevo.dato>subarbol.dato){
        if(subarbol.hijoDcho==null){
        subarbol.hijoDcho=nuevo;
        }else{
        subarbol.hijoDcho=insertar(nuevo,subarbol.hijoDcho);
        if(ObtenerFE(subarbol.hijoDcho)-ObtenerFE(subarbol.hijoIzq)==2){
            if(nuevo.dato<subarbol.hijoDcho.dato){
            nuevoPadre=RotacionDcho(subarbol);
            }else{
            nuevoPadre=RotacionDobleDcho(subarbol);
            }
        }
      }
    }else{
    System.out.println("El nodo ingresado esta duplicado");
    }
    //Actualizando altura del árbol
    if((subarbol.hijoIzq==null && subarbol.hijoDcho!=null)){
        subarbol.fe=subarbol.hijoDcho.fe+1;
    }else if(subarbol.hijoDcho==null && subarbol.hijoIzq!=null){
        subarbol.fe=subarbol.hijoIzq.fe+1;
    }else{
    subarbol.fe=Math.max(ObtenerFE(subarbol.hijoIzq), ObtenerFE(subarbol.hijoDcho))+1;
    }
    return nuevoPadre;
  }//Fin
    
    //Método Insertar
    public void insertarAvl(int d){
    Nodo nuevo = new Nodo(d);
        if(raiz==null){
        raiz=nuevo;
        }else{
        raiz=insertar(nuevo,raiz);
        }
    }
    public void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.getIzquierdo());
            preorden(r.getDerecho());
        }
    }

    // Recorrido de un árbol binario en inorden
    public void inorden(Nodo r) {
        if (r != null) {
            inorden(r.getIzquierdo());
            r.visitar();
            inorden(r.getDerecho());
        }
    }

    // Recorrido de un árbol binario en postorden
    public void postorden(Nodo r) {
        if (r != null) {
            postorden(r.getIzquierdo());
            postorden(r.getDerecho());
            r.visitar();
        }
    }
}
