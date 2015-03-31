/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizacion;

/**
 *
 * @author Brayan
 */
public class ListaIteaciones {
    private double iteracion[][];

    public ListaIteaciones(double[][] iteracion) {
        this.iteracion = iteracion;
    }

    public double[][] getIteracion() {
        return iteracion;
    }

    public void setIteracion(double[][] iteracion) {
        this.iteracion = iteracion;
    }
    
}
