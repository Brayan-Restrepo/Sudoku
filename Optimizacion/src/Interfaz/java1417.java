/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import java.awt.*;
import java.awt.event.*;
import static com.sun.javafx.fxml.expression.Expression.add;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class java1417 extends JPanel {
  private JTable tabla;
  private JScrollPane panelScroll;
  private String titColumna[];
  private String datoColumna[][];
  
  public java1417() {
    setLayout( new BorderLayout() );
    // Creamos las columnas y las cargamos con los datos que van a
    // aparecer en la pantalla
    CreaColumnas();
    CargaDatos();
    // Creamos una instancia del componente Swing
    tabla = new JTable( datoColumna,titColumna );
    // Aquí se configuran algunos de los parámetros que permite 
    // variar la JTable
    tabla.setShowHorizontalLines( false );
    tabla.setRowSelectionAllowed( true );
    tabla.setColumnSelectionAllowed( true );
    // Cambiamos el color de la zona seleccionada (rojo/blanco)
    tabla.setSelectionForeground( Color.white );
    tabla.setSelectionBackground( Color.red );
    // Incorporamos la tabla a un panel que incorpora ya una barra
    // de desplazamiento, para que la visibilidad de la tabla sea
    // automática
    panelScroll = new JScrollPane( tabla );
    add( panelScroll, BorderLayout.CENTER );
  }
  
  
  // Creamos las etiquetas que sirven de título a cada una de
  // las columnas de la tabla
  public void CreaColumnas() {
    titColumna = new String[8];
    
    for( int i=0; i < 8; i++ ) {
      titColumna[i] = "Col: "+i;
    }
  }
  
  // Creamos los datos para cada uno de los elementos de la tabla
  public void CargaDatos() {
    datoColumna = new String[100][8];
    
    for( int iY=0; iY < 100; iY++ ) {
      for( int iX=0; iX < 8; iX++ ) {
	datoColumna[iY][iX] = "" + iX + "," + iY;
      }
    }
  }
  
  
  public static void main( String args[] ) {
    JFrame ventana = new JFrame( "Tutorial de Java, Swing" );
    
    ventana.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ){
	System.exit( 0 );
      }
    } );
    ventana.getContentPane().add( new java1417(),BorderLayout.CENTER );
    ventana.setSize( 300,180 );
    
    ventana.setVisible( true );
  }
}
