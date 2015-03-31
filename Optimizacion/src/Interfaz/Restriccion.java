/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import optimizacion.Variable;

/**
 *
 * @author Sergio
 */
public class Restriccion {
   int variables;
    ArrayList<Variable> variable;
   
     Restriccion(int  variables,ArrayList<Variable> variable){
     this.variables=variables; 
     this.variable=variable;
    }
     Restriccion(ArrayList<Variable> variable){
     this.variable=variable;
    }

    public int getVariables() {
        return variables;
    }

    public void setVariables(int variables) {
        this.variables = variables;
    }

    public ArrayList<Variable> getVariable() {
        return variable;
    }

    public void setVariable(ArrayList<Variable> variable) {
        this.variable = variable;
    }
    
     
    
}
