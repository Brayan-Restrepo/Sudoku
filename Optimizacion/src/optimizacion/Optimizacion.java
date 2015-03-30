/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizacion;

import java.util.ArrayList;

/**
 *
 * @author Brayan
 */
public class Optimizacion {

    private double matriz[][];
    private boolean zMax;
    /**
     * No repetir esta pociciones:
     */
    private ArrayList<Integer> posicionBetada;
    /**
     * constructor para hacer las pruevas con una matriz ya definida
     */
    public Optimizacion(){
        this.posicionBetada = new ArrayList<Integer>();
        this.zMax = true;
//        double a[][] = {
//            {1,8,-6,17,-6,0,0,0,0},
//            {0,3,8,6,4,1,0,0,300},
//            {0,2,0,7,4,0,1,0,500},
//            {0,3,8,0,1,0,0,1,200}
//        };
        double a[][] = {
            {1,-10,-6,0},
            {0,6,4,360},
            {0,4,6,480}};
        this.matriz = a;
    }
    
    /**
     * Se inicializa la Matriz Pero no se.
     * @param x Numero de Columnas
     * @param y Numero de Filas
     */
    public Optimizacion(int x,int y,boolean zMax){
        this.posicionBetada = new ArrayList<Integer>();
        this.zMax = zMax;
        this.matriz = new double[y][x];
    }
    
    /**
     * Se Operarra la matriz 
     */
    public void iteraciones(){
        int x = 0;
        int y = 0;
        
        while(x>=0){
            System.out.println("X -> "+x);
            System.out.println("Y -> "+y);
            this.imprimirMatriz();
            if (zMax) {
                x = this.masNegativo(this.matriz[0]);
                if(x > 0){
                    y = this.eligirFila(x,this.matriz[0].length-1);
                }else{
                    break;
                }
            }else{
                x = this.masPositivo(this.matriz[0]);
                if(x > 0){
                    y = this.eligirFila(x,this.matriz[0].length-1);
                }else{
                    break;
                }                    
            }
            this.operarMatriz(x, y);
        }
    }
    
    /**
     * Busca en un vector cual es la posicion mas positiva
     * @param mPositivo La primera Fila de la Matriz
     * @return la pocion del mas Positivo o -1
     */
    public int masPositivo(double mPositivo[]){
        int i = 1;//Desde la posicion 1 para que no coja Z
        int p = -1;
        double v = 0;
        
        while(i < mPositivo.length){
            if (v < mPositivo[i]) {
                v = mPositivo[i];
                p = i;
            }
            i++;
        }
        
        return p;
    }
    
    /**
     * Busca en un vectro cual es la posicion mas negativa
     * y devuelve la posicion 
     * @param mNegativo La primera Fila de la Matriz
     * @return  La posicon mas Negativa o -1
     */
    public int masNegativo(double mNegativo[]){
        int i = 0;
        int p = -1;
        double v = 0;
        
        while(i<mNegativo.length){
            if (v > mNegativo[i]) {
                v = mNegativo[i];
                p = i;
            }
            i++;
        }
        
        return p;
    }
    
    /**
     * Se divide c2 en c1 (c2/c1) y se octiene el menor numero.
     * RESTRICCOINES:
     *      si C2 = Negativo no de toma
     *      Si c2 = 0 solo se escoge una vez
     *      Si c1 es Negativo (-) no se divide no se toma esa posicion
     *      si c1 = 0 no coger 
     * @param c1 Columna Seleccionada
     * @param c2 Columna de resultados (La Ultima)
     * @return La posicion del menor
     */
    public int eligirFila(int x,int y){
        int p = -1;
        double menorPositivo = Double.MAX_VALUE;
        
        for (int i = 1; i < this.matriz.length; i++) {
            System.out.println("-> "+this.matriz[i][x]+" -> "+this.matriz[i][y]);
            double aux = this.matriz[i][y]/this.matriz[i][x];
            
            if (this.matriz[i][x] <= 0) {
                continue;                
            }else if(menorPositivo >= aux && aux >= 0){
                //Si c2 es 0 beta esa pocicion y no entra otravez
                if (this.matriz[i][y] == 0 && !this.posicionBetada.contains(i)) {
                    this.posicionBetada.add(i);
                    menorPositivo = aux;
                    p = i;
                }else if(this.matriz[i][y] != 0){
                    menorPositivo = aux;
                    p = i;
                }
            }
        }
        return p;
    }
    
    
    public void operarMatriz(int x,int y){
        
        boolean controlador = true;
        double pivote = this.matriz[y][x];
        for (int i = y; i < this.matriz.length; i++) {//Filas 
            for (int j = 0; j < this.matriz[0].length; j++) {//Columnas
                if(controlador){
                    this.matriz[i][j] = this.matriz[y][j]/pivote;
                }else if(i != y){
                    this.matriz[i][j] = this.matriz[i][j] - this.matriz[y][j]*this.matriz[i][j];
                }
            }
            if (controlador) {
                controlador = false;
                i = -1;
            }
        }
    }
    
    
    public void imprimirMatriz(){
        for (int i = 0; i < this.matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < this.matriz[0].length; j++) {
                System.out.print(" "+this.matriz[i][j]);
            }
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        new Optimizacion().iteraciones();
    }
    
}
