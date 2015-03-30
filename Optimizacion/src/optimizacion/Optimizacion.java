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
        this.zMax = false;
        double a[][] = {
            {1,-8,-6,-7,-6,0,0,0,0},
            {0,3,8,6,4,1,0,0,300},
            {0,2,0,7,4,0,1,0,500},
            {0,3,8,0,1,0,0,1,200}
        };
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
        this.matriz = new double[x][y];
    }
    
    /**
     * Se Operarra la matriz 
     */
    public void iteraciones(){
        int x = 0;
        int y = 0;
        if (zMax) {
            x = this.masNegativo(this.matriz[0]);
            
        }else{
            x = this.masPositivo(this.matriz[0]);
            
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
        System.out.println(p);
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
        System.out.println(p);
        return p;
    }
    
    /**
     * Se divide c2 en c1 (c2/c1) y se octiene el menor numero.
     * RESTRICCOINES:
     *      Si c2 = 0 solo se escoge una vez
     *      Si c1 es Negativo (-) no se divide no se toma esa posicion
     *      si c1 = 0 no coger 
     * @param c1 Columna Seleccionada
     * @param c2 Columna de resultados (La Ultima)
     * @return La posicion del menor
     */
    public int eligirFila(double c1[],double c2[]){
        int p = -1;
        double menorPositivo = 0;
        for (int i = 1; i < c1.length; i++) {
            if (c1[i] <= 0) {
                continue;                
            }else  if(menorPositivo > c2[i]/c1[i]){
                menorPositivo = c2[i]/c1[i];
                p = i;
            }
        }
        
        
        
        return p;
    }
    
    
    public static void main(String[] args) {
        new Optimizacion().iteraciones();
    }
    
}
