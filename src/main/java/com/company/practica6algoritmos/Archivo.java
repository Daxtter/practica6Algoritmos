/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.practica6algoritmos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *  Esta clase esta para facilitar el uso del archivo, el cual servira para hacer un banco de palabras
 * @author nunez
 */
public class Archivo {
    String archivo;
    CSVReader reader;
    String si = "\"";
    //String archCSV;
    
    public Archivo() throws FileNotFoundException
    {
        archivo = System.getProperty("user.dir") + "\\src\\main\\java\\com\\mycompany\\practica5algoritmos\\Data.csv";
        //archCSV = "C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\SuperDatos.csv";
    } 
    
    
  
    public List<String[]> leerArchivoCSV(String ruta) throws IOException
    {
        List<String[]>bancoDePalabras = new ArrayList<>();
        if(existeArchivo(ruta)){
            //System.out.println("Si existe");
        try {
           // System.out.println("Se leyo");
         CSVReader lector = new CSVReader(new FileReader(ruta));
         bancoDePalabras = lector.readAll();
         
      } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Error al leer ");
         
      } finally {
         if (null != reader) {
            reader.close();
         } 
      }
        }
        return bancoDePalabras;
    }
    
   
    
    
    public boolean existeArchivo(String ruta)
    {
        File archivo =  new File(ruta);
        return archivo.exists();
    
    
    }
    public void escribirArchivoCSV(String archCSV, List<String[]> valores, String[] cabecera) throws IOException
    {
        
        CSVWriter escribir = new CSVWriter(new FileWriter(archCSV));  
        escribir.writeNext(cabecera);
        escribir.writeAll(valores);
        escribir.close();
        //write all para esribir todo, write next pata arreglos
    
    }
    public void escribirArchivoCSVSinCabecera(String archCSV, List<String[]> valores) throws IOException
    {
        
        CSVWriter escribir = new CSVWriter(new FileWriter(archCSV));  
        //escribir.writeNext(cabecera);
        escribir.writeAll(valores);
        escribir.close();
        //write all para esribir todo, write next pata arreglos
    }
  
}

