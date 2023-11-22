/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.company.practica6algoritmos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author nunez
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Archivo archivo;
    int contador;
    Aplicacion api;
    XYSeriesCollection datosTotales;
    double [] numeros;
    String direcionDelProjecto;
    Color[] colores; //Estos colores se usaran para graficar
    int contadorParaSaberSiSeDebeVolverAGraficar;
    public Interfaz() throws FileNotFoundException {
        archivo =  new Archivo();
        contadorParaSaberSiSeDebeVolverAGraficar = 0;
        initComponents();
        datosTotales = new XYSeriesCollection();
        colores = new Color[12];
        api =  new Aplicacion();
        numeros = new double[10];
        ingresarColores();
        contador = 0;
        inicializarNumeros();
        direcionDelProjecto = "C:\\Users\\nunez\\Documents\\Manuel\\Practica6Algoritmos\\src\\main\\java\\com\\company\\practica6algoritmos\\";
    }
    private void inicializarNumeros()
    {
        
        numeros[0] =100;
        numeros[1] = 500;
        numeros[2] = 1000;
        numeros[3] = 1500;
        numeros[4] = 2000;
        numeros[5] = 3000;
        numeros[6] = 4000;
        numeros[7] = 5000;
        numeros[8] = 7000;
        numeros[9] = 10000;
    }
    private void ingresarColores()
    {
        colores[0] = Color.RED;
        colores[1] = Color.BLUE;
        colores[2] = Color.CYAN;
        colores[3] = Color.PINK;
        colores[4] = Color.ORANGE;
        colores[5] = Color.magenta;
        colores[6] = new Color(138, 61, 82);
        colores[7] = new Color(120, 0, 91);
        colores[8] = new Color(75, 122, 164 );
        colores[9] = new Color(0, 182, 116 );
        colores[10] = new Color(64, 202, 101 );
        colores[11] = new Color(158, 215, 58 );
    }
    private void crearArchivoCSV(double[] tiempo, String tipoDeOrdenacion) throws IOException
    {
        List<String[]> valoresAIngresar = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
         String[] cadena = {""+i,""+numeros[i],""+tiempo[i]};
         valoresAIngresar.add(cadena);
        }
        String[] cabecera =  {"nCorrida","dimesionArreglo","tiempo"};
        archivo.escribirArchivoCSV(tipoDeOrdenacion, valoresAIngresar, cabecera);
    }
    private void calcularTiempoQuickSort() throws IOException{
        double[] tiempo =  new double[10];
        if(QSArregloDesordenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeQuickSortEnListaAleatoria();
            XYSeries serieAIngresar =  new XYSeries("QuickSort con arreglo desordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "QuickSort(caso1).csv");
        }
        
        if(QSArregloOrdenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeQuickSortEnListaOrdenada();
            XYSeries serieAIngresar2 =  new XYSeries("QuickSort con arreglo ordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar2.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar2);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "QuickSort(caso2).csv");
        }
        if(QSArregloOrdenadoAlReves.isSelected())
        {
            tiempo = api.ProbarElTiempoDeQuickSortEnListaOrdenadaAlReves();
            XYSeries serieAIngresar3 =  new XYSeries("QuickSort con arreglo ordenado al reves");
            for(int i=0; i<10; i++)
            {
                serieAIngresar3.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar3);
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "QuickSort(caso3).csv");
        }
    }
    
    private void calcularTiempoSort() throws IOException{
        double[] tiempo =  new double[10];
        if(SortArregloDesordenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysSortEnListaAleatoria();
            XYSeries serieAIngresar =  new XYSeries("Sort con arreglo desordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "Sort(caso1).csv");
        }
        
        if(SortArregloOrdenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysSortEnListaOrdenada();
            XYSeries serieAIngresar2 =  new XYSeries("Sort con arreglo ordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar2.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar2);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "Sort(caso2).csv");
        }
        if(SortArregloOrdenadoAlreves.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysSortEnListaOrdenadaAlReves();
            XYSeries serieAIngresar3 =  new XYSeries("Sort con arreglo ordenado al reves");
            for(int i=0; i<10; i++)
            {
                serieAIngresar3.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar3);
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "Sort(caso3).csv");
        }
    }
    
    private void calcularTiempoParallelSort() throws IOException{
        double[] tiempo =  new double[10];
        if(PSArregloDesordenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysParallelSortEnListaAleatoria();
            XYSeries serieAIngresar =  new XYSeries("ParallelSort con arreglo desordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "ParallelSort(caso1).csv");
        }
        
        if(PSArregloOrdenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysParallelSortEnListaOrdenada();
            XYSeries serieAIngresar2 =  new XYSeries("ParallelSort con arreglo ordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar2.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar2);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "ParallelSort(caso2).csv");
        }
        if(PSArregloOrdenadoAlreves.isSelected())
        {
            tiempo = api.ProbarElTiempoDeArraysParallelSortEnListaOrdenadaAlReves();
            XYSeries serieAIngresar3 =  new XYSeries("ParallelSort con arreglo ordenado al reves");
            for(int i=0; i<10; i++)
            {
                serieAIngresar3.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar3);
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "ParallelSort(caso3).csv");
        }
    }
    
    private void calcularTiempoMergeSort() throws IOException{
        double[] tiempo =  new double[10];
        if(MSArregloDesordenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeMergeSortEnListaAleatoria();
            XYSeries serieAIngresar =  new XYSeries("MergeSort con arreglo desordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "MergeSort(caso1).csv");
        }
        
        if(MSArregloOrdenado.isSelected())
        {
            tiempo = api.ProbarElTiempoDeMergeSorttEnListaOrdenada();
            XYSeries serieAIngresar2 =  new XYSeries("MergeSort con arreglo ordenado");
            for(int i=0; i<10; i++)
            {
                serieAIngresar2.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar2);   
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "MergeSort(caso2).csv");
        }
        if(MSArregloOrdenadoAlreves.isSelected())
        {
            tiempo = api.ProbarElTiempoDeMergeSortEnListaOrdenadaAlReves();
            XYSeries serieAIngresar3 =  new XYSeries("MergeSort con arreglo ordenado al reves");
            for(int i=0; i<10; i++)
            {
                serieAIngresar3.add(numeros[i],tiempo[i]);
            }
            datosTotales.addSeries(serieAIngresar3);
            contador= contador +1;
            crearArchivoCSV(tiempo, direcionDelProjecto+ "MergeSort(caso3).csv");
        }
    }

    private void borrarTodoParaVolverAGraficar()
    {
        contador = 0;
        datosTotales.removeAllSeries();
        jPanelParaGraficar.removeAll();
        pack();
        revalidate();
        repaint();
        jPanelParaGraficar.revalidate();
        jPanelParaGraficar.repaint();
    
    }
    private void ingresarValoresEnLagrafica() throws IOException
    {
        calcularTiempoMergeSort();
        calcularTiempoParallelSort();
        calcularTiempoQuickSort();
        calcularTiempoSort();
    }
    private void cambiarLetraDeLosLabelACargando()
    {
        labelDeStatus.setText("Cargando ...");
        labelDeStatus.setForeground(Color.gray);
    }
    private void cambiarLetraDelLableAListo()
    {
        labelDeStatus.setText("Listo Para graficar");
        labelDeStatus.setForeground(Color.GREEN);
    }
    private void graficar()
    {
        JFreeChart grafico =  ChartFactory.createXYLineChart("Gráfica comparativa", "Número (N)", "Tiempo(nano segundos)", datosTotales, PlotOrientation.VERTICAL, true, true, true);
         
         
        XYPlot plot = grafico.getXYPlot();
        
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        for (int i = 0; i <contador; i++) {
        render.setSeriesPaint(i, colores[i]);
        }
        
        
        plot.setRenderer(render);
        ChartPanel panelDeGrafico = new ChartPanel(grafico);
        panelDeGrafico.setMouseZoomable(true);
        panelDeGrafico.setPreferredSize(new Dimension(600,400)); //tamano
        
        jPanelParaGraficar.setLayout(new BorderLayout());
        jPanelParaGraficar.add(panelDeGrafico,BorderLayout.NORTH);
        pack();
        revalidate();
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QSArregloDesordenado = new javax.swing.JCheckBox();
        QSArregloOrdenado = new javax.swing.JCheckBox();
        QSArregloOrdenadoAlReves = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MSArregloOrdenadoAlreves = new javax.swing.JCheckBox();
        MSArregloDesordenado = new javax.swing.JCheckBox();
        MSArregloOrdenado = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        SortArregloDesordenado = new javax.swing.JCheckBox();
        SortArregloOrdenadoAlreves = new javax.swing.JCheckBox();
        SortArregloOrdenado = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        PSArregloOrdenadoAlreves = new javax.swing.JCheckBox();
        PSArregloDesordenado = new javax.swing.JCheckBox();
        PSArregloOrdenado = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanelParaGraficar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        labelDeStatus = new javax.swing.JLabel();
        seleccionTodo = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QSArregloDesordenado.setText("Arreglo desordenado");
        QSArregloDesordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QSArregloDesordenadoActionPerformed(evt);
            }
        });

        QSArregloOrdenado.setText("Arreglo ordenado");
        QSArregloOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QSArregloOrdenadoActionPerformed(evt);
            }
        });

        QSArregloOrdenadoAlReves.setText("Arreglo ordenado descendente(al reves)");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QuickSort");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mergesort");

        MSArregloOrdenadoAlreves.setText("Arreglo ordenado descendente(al reves)");

        MSArregloDesordenado.setText("Arreglo desordenado");
        MSArregloDesordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSArregloDesordenadoActionPerformed(evt);
            }
        });

        MSArregloOrdenado.setText("Arreglo ordenado");
        MSArregloOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSArregloOrdenadoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sort");

        SortArregloDesordenado.setText("Arreglo desordenado");
        SortArregloDesordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortArregloDesordenadoActionPerformed(evt);
            }
        });

        SortArregloOrdenadoAlreves.setText("Arreglo ordenado descendente(al reves)");

        SortArregloOrdenado.setText("Arreglo ordenado");
        SortArregloOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortArregloOrdenadoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Parallel sort");

        PSArregloOrdenadoAlreves.setText("Arreglo ordenado descendente(al reves)");

        PSArregloDesordenado.setText("Arreglo desordenado");
        PSArregloDesordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSArregloDesordenadoActionPerformed(evt);
            }
        });

        PSArregloOrdenado.setText("Arreglo ordenado");
        PSArregloOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSArregloOrdenadoActionPerformed(evt);
            }
        });

        jLabel6.setText("<html>Nota: Sort y Parallel sort son metodos <br> de ordenamiento de la clase Arrays<html>");

        javax.swing.GroupLayout jPanelParaGraficarLayout = new javax.swing.GroupLayout(jPanelParaGraficar);
        jPanelParaGraficar.setLayout(jPanelParaGraficarLayout);
        jPanelParaGraficarLayout.setHorizontalGroup(
            jPanelParaGraficarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        jPanelParaGraficarLayout.setVerticalGroup(
            jPanelParaGraficarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        jButton1.setText("Graficar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelDeStatus.setText("Esperando");

        seleccionTodo.setText("Seleccionar todo");
        seleccionTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionTodoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Grafica de los diferentes métodos de ordenamiento");

        jLabel1.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(seleccionTodo)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDeStatus))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanelParaGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSArregloOrdenado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SortArregloOrdenado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(QSArregloOrdenadoAlReves))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(MSArregloDesordenado)
                                                .addGap(18, 18, 18)
                                                .addComponent(MSArregloOrdenado))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(SortArregloDesordenado)
                                            .addComponent(PSArregloDesordenado)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(SortArregloOrdenadoAlreves))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(PSArregloOrdenadoAlreves))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(MSArregloOrdenadoAlreves)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(QSArregloDesordenado)
                                            .addGap(18, 18, 18)
                                            .addComponent(QSArregloOrdenado))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QSArregloDesordenado)
                            .addComponent(QSArregloOrdenado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QSArregloOrdenadoAlReves)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MSArregloDesordenado)
                            .addComponent(MSArregloOrdenado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MSArregloOrdenadoAlreves)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SortArregloDesordenado)
                            .addComponent(SortArregloOrdenado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SortArregloOrdenadoAlreves)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PSArregloDesordenado)
                            .addComponent(PSArregloOrdenado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PSArregloOrdenadoAlreves)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jPanelParaGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(labelDeStatus)
                            .addComponent(seleccionTodo)
                            .addComponent(jLabel1))))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    
    
    
    private void QSArregloOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QSArregloOrdenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QSArregloOrdenadoActionPerformed

    private void QSArregloDesordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QSArregloDesordenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QSArregloDesordenadoActionPerformed

    private void MSArregloDesordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSArregloDesordenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSArregloDesordenadoActionPerformed

    private void MSArregloOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSArregloOrdenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSArregloOrdenadoActionPerformed

    private void SortArregloDesordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortArregloDesordenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SortArregloDesordenadoActionPerformed

    private void SortArregloOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortArregloOrdenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SortArregloOrdenadoActionPerformed

    private void PSArregloDesordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSArregloDesordenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PSArregloDesordenadoActionPerformed

    private void PSArregloOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSArregloOrdenadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PSArregloOrdenadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contadorParaSaberSiSeDebeVolverAGraficar = contadorParaSaberSiSeDebeVolverAGraficar+1;
        cambiarLetraDeLosLabelACargando();
        if(contadorParaSaberSiSeDebeVolverAGraficar>1)
        {
            borrarTodoParaVolverAGraficar();
            System.out.println("Borrar");
        }
        try {
            ingresarValoresEnLagrafica();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        graficar();
        cambiarLetraDelLableAListo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void seleccionTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionTodoActionPerformed
        QSArregloDesordenado.setSelected(seleccionTodo.isSelected());
        QSArregloOrdenado.setSelected(seleccionTodo.isSelected());
        QSArregloOrdenadoAlReves.setSelected(seleccionTodo.isSelected());
        PSArregloDesordenado.setSelected(seleccionTodo.isSelected());
        PSArregloOrdenado.setSelected(seleccionTodo.isSelected());
        PSArregloOrdenadoAlreves.setSelected(seleccionTodo.isSelected());
        SortArregloDesordenado.setSelected(seleccionTodo.isSelected());
        SortArregloOrdenado.setSelected(seleccionTodo.isSelected());
        SortArregloOrdenadoAlreves.setSelected(seleccionTodo.isSelected());
        MSArregloDesordenado.setSelected(seleccionTodo.isSelected());
        MSArregloOrdenado.setSelected(seleccionTodo.isSelected());
        MSArregloOrdenadoAlreves.setSelected(seleccionTodo.isSelected());
    }//GEN-LAST:event_seleccionTodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox MSArregloDesordenado;
    private javax.swing.JCheckBox MSArregloOrdenado;
    private javax.swing.JCheckBox MSArregloOrdenadoAlreves;
    private javax.swing.JCheckBox PSArregloDesordenado;
    private javax.swing.JCheckBox PSArregloOrdenado;
    private javax.swing.JCheckBox PSArregloOrdenadoAlreves;
    private javax.swing.JCheckBox QSArregloDesordenado;
    private javax.swing.JCheckBox QSArregloOrdenado;
    private javax.swing.JCheckBox QSArregloOrdenadoAlReves;
    private javax.swing.JCheckBox SortArregloDesordenado;
    private javax.swing.JCheckBox SortArregloOrdenado;
    private javax.swing.JCheckBox SortArregloOrdenadoAlreves;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelParaGraficar;
    private javax.swing.JLabel labelDeStatus;
    private javax.swing.JCheckBox seleccionTodo;
    // End of variables declaration//GEN-END:variables
}
