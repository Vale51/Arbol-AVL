/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolavl;

/**
 *
 * @author user
 */
public class Nodo {
    int dato;
    int fe; //Factor de equilibrio
    Nodo hijoIzq, hijoDcho;
    
    //Constructor
    public Nodo (int d){
        this.dato = d;
        this.fe = 0;
        this.hijoIzq=null;
        this.hijoDcho=null;
    }
   public Nodo getIzquierdo() {
        return this.hijoIzq;
    }

    public void setIzquierdo(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getDerecho() {
        return this.hijoDcho;
    }

    public void setDerecho(Nodo hijoDcho) {
        this.hijoDcho = hijoDcho;
    }
    
    void visitar()
    {
    System.out.print(dato + " ");
    }
}
