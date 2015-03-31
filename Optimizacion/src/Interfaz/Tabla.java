/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import optimizacion.*;

/**
 *
 * @author Brayan
 */
public class Tabla extends JTable{
    
    private DefaultTableModel modelo;
    public Tabla(double datos[][],String cabecera[]){
        this.setEnabled(false);
        String datos1[][] = new String [datos.length][(datos[0].length+1)];
        for (int i = 0; i < datos1.length; i++) {//Fila
            for (int j = 0; j < datos1[0].length; j++) {//Columna
                if (j==0) {
                    datos1[i][j] = Optimizacion.vRestrig[i];
                }else{
                    datos1[i][j] = String.valueOf(Math.rint(datos[i][(j-1)]*100)/100);
                }
            }
        }
        this.modelo = (DefaultTableModel) this.getModel();
        this.modelo.setDataVector(datos1, cabecera);
        this.getColumnModel().getColumn(0).setCellRenderer(
                this.getTableHeader().getDefaultRenderer());
    }
    
}
