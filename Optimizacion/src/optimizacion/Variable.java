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
public class Variable {
    
    private String nombre;
    private double valor;

    public Variable(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVariabloValor(){
        return this.nombre+" -> "+this.valor;
    }
    
    
}

