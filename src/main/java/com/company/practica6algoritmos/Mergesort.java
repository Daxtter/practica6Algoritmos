/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.practica6algoritmos;

/**
 *
 * @author nunez
 */
public class Mergesort {

    public Mergesort() {

    }

    private static void seleccion(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int menor = a[i];
            int k = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < menor) {
                    menor = a[j];
                    k = j;
                }
            }

            int temp = a[i];
            a[i] = menor;
            a[k] = temp;
        }
    }

    private static void insercion(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int aux = a[i];
            int k = i - 1;

            while (k >= 0 && aux < a[k]) {
                a[k + 1] = a[k];
                k--;
            }

            a[k + 1] = aux;
        }
    }

    private static void Shell(int[] a, int n) {
        int intervalo = n + 1;

        while (intervalo > 1) {
            intervalo = intervalo / 2;
            boolean bandera = true;

            while (bandera) {
                bandera = false;
                int i = 1;

                while ((i + intervalo) < n) {
                    if (a[i] > a[i + intervalo]) {
                        int aux = a[i];
                        a[i] = a[i + intervalo];
                        a[i + intervalo] = aux;
                        bandera = true;
                    }
                    i++;
                }
            }
        }
    }
    public static void mergeSort(Integer[] Arreglo) {
        int longitudArreglo= Arreglo.length;
        
        if (longitudArreglo< 2) {
          return;
        }
        
        int mitadArreglo = longitudArreglo / 2;
        Integer[] mitadIzquierda = new Integer[mitadArreglo];
        Integer[] mitadDerecha = new Integer[longitudArreglo - mitadArreglo];
        
        for (int i = 0; i < mitadArreglo ; i++) {
          mitadIzquierda[i] = Arreglo[i];
        }
        for (int i = mitadArreglo ; i < longitudArreglo; i++) {
          mitadDerecha[i - mitadArreglo ] = Arreglo[i];
        }
        
        mergeSort(mitadIzquierda);
        mergeSort(mitadDerecha);
        
        merge(Arreglo, mitadIzquierda, mitadDerecha);
      }
    
      private static void merge (Integer[] Arreglo, Integer[] mitadIzquierda, Integer[] mitadDerecha) {
        
        int mitadIzquierda_tamano = mitadIzquierda.length;
        int mitadDerecha_tamano = mitadDerecha.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < mitadIzquierda_tamano && j < mitadDerecha_tamano) {
          if (mitadIzquierda[i] <= mitadDerecha[j]) {
            Arreglo[k] = mitadIzquierda[i];
            i++;
          }
          else {
            Arreglo[k] = mitadDerecha[j];
            j++;
          }
          k++;
        }
        
        while (i < mitadIzquierda_tamano) {
          Arreglo[k] = mitadIzquierda[i];
          i++;
          k++;
        }
        
        while (j < mitadDerecha_tamano) {
          Arreglo[k] = mitadDerecha[j];
          j++;
          k++;
        }
        
      }
      
}

