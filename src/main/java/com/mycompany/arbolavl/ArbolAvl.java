/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.arbolavl;
import java.util.Scanner;

public class ArbolAvl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int respuesta, respuesta_arbol;
        Arbol arbol = new Arbol();
        arbol.insertarAvl(5);
        arbol.insertarAvl(6);
        arbol.insertarAvl(3);
        arbol.insertarAvl(1);
        arbol.insertarAvl(4);
        arbol.insertarAvl(10);
            //Menú
            System.out.println("¡Bienvenido al menú para crear un Árbol Avl!");
        do{
            System.out.println("\nIngrese 1 para insertar un nodo");
            System.out.println("Ingrese 2 para recorrer el árbol");
            System.out.println("Ingrese 3 para salir");
            respuesta=sc.nextInt();
            sc.nextLine();
                while(respuesta<1 || respuesta>3){
                System.out.println("Error: La opcion ingresa no es válida");
                System.out.println("Ingrese 1 para insertar un nodo");
                System.out.println("Ingrese 2 para recorrer el árbol");
                System.out.println("Ingrese 3 para salir");
                respuesta=sc.nextInt();
                sc.nextLine();
                }
            switch(respuesta){
               case 1:
                System.out.println("¡Los nodos fueron insertados de manera correcta!");
                    break;
                case 2:
                   System.out.println("¿Como desea recorrer el árbol?");
                   System.out.println("1. Recorrido Inorden");
                   System.out.println("2. Recorrido Preorden");
                   System.out.println("3. Recorrido Postorden");
                   respuesta_arbol=sc.nextInt();
                   sc.nextLine();
                    switch(respuesta_arbol){
                        case 1:
                    System.out.println("Recorrido en Inorden:");
                    arbol.preorden(arbol.obtenerRaiz());
                    break;
                        case 2:
                    System.out.println("Recorrido en Preorden:");
                    arbol.preorden(arbol.obtenerRaiz());
                     break;
                        case 3:
                     System.out.println("Recorrido en Postorden:");
                     arbol.postorden(arbol.obtenerRaiz());
                     break;
                    }
                    break;
                }    
        }while(respuesta<3);
    }
}
