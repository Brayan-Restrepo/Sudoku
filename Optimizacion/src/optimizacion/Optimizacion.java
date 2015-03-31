/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizacion;

import Interfaz.Panel;
import static Interfaz.Panel.tabla;
import Interfaz.Tabla;
import java.util.ArrayList;

/**
 *
 * @author Brayan
 */
public class Optimizacion {

    private double matriz[][];
    private boolean zMax;
    public ArrayList<Variable> valor;
    public static ArrayList<ListaIteaciones> listMatriz = new ArrayList<ListaIteaciones>();;
    Panel panel;
    /**
     * No repetir esta pociciones:
     */
    private ArrayList<Integer> posicionBetada;
    public static String vRestrig[];

    
    
    /**
     * constructor para hacer las pruevas con una matriz ya definida
     */
    public Optimizacion(){
        this.valor = new ArrayList<Variable>();
        this.posicionBetada = new ArrayList<Integer>();
        this.zMax = true;
        String vr[]={"Z","H1","H2","H3"};
        Optimizacion.vRestrig = vr;
        double a[][] = {
            {1,-8,-6,-7,-6,0,0,0,0},
            {0,3,8,6,4,1,0,0,300},
            {0,2,0,7,4,0,1,0,500},
            {0,3,8,0,1,0,0,1,200}
        };
//        double a[][] = {
//            {1,-10,-6,0,0,0},
//            {0,6,4,1,0,360},
//            {0,4,6,0,1,480}};
       
        this.matriz = a;
        this.valor.add(new Variable("Z",0));
        this.valor.add(new Variable("X1",0));
        this.valor.add(new Variable("X2",0));
        this.valor.add(new Variable("X3",0));
        this.valor.add(new Variable("X4",0));
        
    }
    
    /**
     * Se inicializa la Matriz Pero no se.
     * @param x Numero de Columnas
     * @param y Numero de Filas
     */
    public Optimizacion(double matriz[][],boolean zMax,String vRestrig[]){
        this.vRestrig =vRestrig;
        this.valor = new ArrayList<Variable>();
        this.posicionBetada = new ArrayList<Integer>();
        this.zMax = zMax;
        this.matriz = matriz;
    }
    
    /**
     * Se Operarra la matriz 
     */
    public void iteraciones(){
        int x = 0;
        int y = 0;
        String c[] = {"","Z","X1","X2","X3","X4","H1","H2","H3","B"};
        Optimizacion.listMatriz.add(new ListaIteaciones(this.matriz.clone()));//La inicial
        Panel.tabla.add(new Tabla(this.matriz,c));
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
            
            Optimizacion.listMatriz.add(new ListaIteaciones(this.matriz.clone()));
            Optimizacion.vRestrig[x] = valor.get(x).getNombre();
            Panel.tabla.add(new Tabla(this.matriz,c));
            if (x <= this.valor.size() && x != 0) {
                this.valor.get(0).setValor(this.matriz[0][this.matriz[0].length-1]);
                this.valor.get(x).setValor(this.matriz[y][this.matriz[0].length-1]);
            }
        }
        
        panel = new Panel();
        panel.setVisible(true);
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
            double ref = this.matriz[i][x];
            for (int j = 0; j < this.matriz[0].length; j++) {//Columnas
                if(controlador){
                    this.matriz[i][j] = this.matriz[y][j]/pivote;
                }else if(i != y){
                    this.matriz[i][j] = this.matriz[i][j] - this.matriz[y][j]*ref;
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
        Optimizacion o = new Optimizacion();
        o.iteraciones();
        System.out.println(o.valor.get(0).getVariabloValor());
        System.out.println(o.valor.get(1).getVariabloValor());
        System.out.println(o.valor.get(2).getVariabloValor());
        System.out.println(o.valor.get(3).getVariabloValor());
        System.out.println(o.valor.get(4).getVariabloValor());
        System.out.println(Optimizacion.listMatriz.get(0).getIteracion()[0][8]);
        System.out.println(Optimizacion.listMatriz.get(1).getIteracion()[0][8]);
        System.out.println(Optimizacion.listMatriz.get(2).getIteracion()[0][8]);
    }
    
}
