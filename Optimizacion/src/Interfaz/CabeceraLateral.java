/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * Ejemplo de cómo hacer una "cabecera" lateral en un JTable. Idea original de
 * Leunamal en
 * http://foro.chuidiang.com/java-j2se/tabla-de-referencias-cruzadas-en-java/
 *
 * Básicamente consiste en hacer que la primera columna: - No sea editable. - No
 * sea seleccionable. - Tenga el mismo render que el JTableHeader superior.
 *
 * @author chuidiang
 */
public class CabeceraLateral {

    /**
     * Crea y visualiza una ventana con un JTable que tiene cabecera en la parte
     * superior y en la columna izquierda
     *
     * @param args
     */
    public static void main(String[] args) {
		// Un modelo de datos que hace la primera columna (la de
        // la cabecera lateral) no editable.
        DefaultTableModel tm = new DefaultTableModel(10, 5) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (0 == column) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

		// Titulos para la cabecera superior. El primero es vacio,
        // puesto que corresponde
        tm.setColumnIdentifiers(new String[]{"", "A", "B", "C", "D"});

        // Valores para la primera columna, que es la cabecera lateral.
        for (int i = 0; i < 10; i++) {
            tm.setValueAt(i + 1, i, 0);
        }

		// JTable al que se le pasa el modelo recien creado y se
        // sobreescribe el metodo changeSelection para que no permita
        // seleccionar la primera columna.
        JTable t = new JTable(tm) {
            @Override
            public void changeSelection(int rowIndex, int columnIndex,
                    boolean toggle, boolean extend) {
                if (columnIndex == 0) {
                    super.changeSelection(rowIndex, columnIndex + 1, toggle,
                            extend);
                } else {
                    super.changeSelection(rowIndex, columnIndex, toggle,
                            extend);
                }
            }
        };

		// Se pone a la primera columna el render del JTableHeader
        // superior.
        t.getColumnModel().getColumn(0).setCellRenderer(
                t.getTableHeader().getDefaultRenderer());

        // Creación y visualización de la ventana completa.
        JFrame v = new JFrame("Cabecera lateral");
        JScrollPane sp = new JScrollPane(t);
        v.getContentPane().add(sp);
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
