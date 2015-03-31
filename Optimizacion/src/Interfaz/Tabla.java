/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class Tabla extends JTable{
    
    private DefaultTableModel modelo;
    public Tabla(double datos[][],String cabecera[]){
        this.setEnabled(false);
        String datos1[][] = new String [datos.length][datos[0].length];
        for (int i = 0; i < datos1.length; i++) {
            for (int j = 0; j < datos1[0].length; j++) {
                datos1[i][j] = String.valueOf(Math.rint(datos[i][j]*100)/100);
            }
        }
        this.modelo = (DefaultTableModel) this.getModel();
        this.modelo.setDataVector(datos1, cabecera);
        
    }
    
}
