/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.practica6algoritmos;

import com.google.common.collect.Lists; //Biblioteca para pasar la lista de string a lista de int
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nunez
 */
public class Aplicacion {
    private Archivo archivo;
    private Random rnd;
    public Aplicacion() throws FileNotFoundException {
        this.archivo = new Archivo();
        this.rnd = new Random();
    }
    
    
    public void crearArchivosConCadenasDeNumeros() throws IOException
    {
        int[] tamanoArreglo= {100,500,1000,1500,2000,3000,4000,5000,7000,10000};
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        for(int i=0; i<tamanoArreglo.length; i++){
            nombreArchivo.append(i).append(".csv");
            if( !archivo.existeArchivo(nombreArchivo.toString()) ){
                
                List<String[]> numeros = new ArrayList<>();
                for (int j = 0; j <tamanoArreglo[i]; j++) 
                {
                    int numeroAleatoria =  rnd.nextInt(1,12000);
                    String[] numerosString = {""+numeroAleatoria}; 
                    numeros.add(numerosString);
                }
                archivo.escribirArchivoCSVSinCabecera(nombreArchivo.toString(), numeros);
            }
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
    }
    public double[] ProbarElTiempoDeQuickSortEnListaAleatoria() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            tiempoAIngresarAlArreglo = System.nanoTime();
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    
    
    public double[] ProbarElTiempoDeQuickSortEnListaOrdenada() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime();
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    public double[] ProbarElTiempoDeQuickSortEnListaOrdenadaAlReves() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            System.out.println("SI"+i);
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            Collections.reverse(Arrays.asList(vectorAOrdenar));
            tiempoAIngresarAlArreglo = System.nanoTime();
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
    }    

    public double[] ProbarElTiempoDeMergeSortEnListaAleatoria() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Mergesort.mergeSort(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    
    
    public double[] ProbarElTiempoDeMergeSorttEnListaOrdenada() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Mergesort.mergeSort(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    public double[] ProbarElTiempoDeMergeSortEnListaOrdenadaAlReves() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            Collections.reverse(Arrays.asList(vectorAOrdenar));
            tiempoAIngresarAlArreglo = System.nanoTime();
            Mergesort.mergeSort(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
    }
    public double[] ProbarElTiempoDeArraysSortEnListaAleatoria() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.sort(vectorAOrdenar); 
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    
    
    public double[] ProbarElTiempoDeArraysSortEnListaOrdenada() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.sort(vectorAOrdenar); 
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    public double[] ProbarElTiempoDeArraysSortEnListaOrdenadaAlReves() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            Collections.reverse(Arrays.asList(vectorAOrdenar));
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.sort(vectorAOrdenar); 
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
    }
    public double[] ProbarElTiempoDeArraysParallelSortEnListaAleatoria() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.parallelSort(vectorAOrdenar); 
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    
    
    public double[] ProbarElTiempoDeArraysParallelSortEnListaOrdenada() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.parallelSort(vectorAOrdenar);  
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
        
    }
    public double[] ProbarElTiempoDeArraysParallelSortEnListaOrdenadaAlReves() throws IOException 
    {
        List<String[]>   listaDeString;
        
        long tiempoAIngresarAlArreglo;
        double[] tiempo = new double[10];
        StringBuilder nombreArchivo =  new StringBuilder("C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\arreglo");
        //StringBuilder nombreArchivo =  new StringBuilder("C:/Users/nunez/Documents/Manuel/Practica6Algoritmos/src/main/java/com/company/practica6algoritmos/arreglo9");
        int contador=0;
        ArrayList<Integer> arregloParaOrdenar =  new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            nombreArchivo.append(i).append(".csv");
        listaDeString = archivo.leerArchivoCSV(nombreArchivo.toString());
            for (String[] cadena: listaDeString) {
                arregloParaOrdenar.add(Integer.parseInt(cadena[0]));
                //System.out.println(""+cadena[0]);
                contador = contador +1;
                
            }
            
            contador = 0;
            
            Integer[] vectorAOrdenar =arregloParaOrdenar.toArray(new Integer[0]);
            QuickSort.ordenar(vectorAOrdenar);
            Collections.reverse(Arrays.asList(vectorAOrdenar));
            tiempoAIngresarAlArreglo = System.nanoTime();
            Arrays.parallelSort(vectorAOrdenar);  
            tiempoAIngresarAlArreglo = System.nanoTime() - tiempoAIngresarAlArreglo;
            tiempo[i] = tiempoAIngresarAlArreglo;
            nombreArchivo.delete(nombreArchivo.length()-5, nombreArchivo.length());
        }
        return tiempo;
    }

}
