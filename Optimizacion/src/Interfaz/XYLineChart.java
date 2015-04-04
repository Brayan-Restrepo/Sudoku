/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Sergio
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import optimizacion.Coordenada;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class XYLineChart extends ImageIcon{

    /** Constructor de clase 
 * @param d Dimension
 */
    public XYLineChart( Dimension d,ArrayList<Restriccion> rest,ArrayList<Coordenada> cor ){

        //se declara el grafico XY Lineal
        XYDataset xydataset = xyDataset(rest,cor);
        JFreeChart jfreechart = ChartFactory.createXYLineChart(
        "Graficas lineales" , "X", "Y",  
        xydataset, PlotOrientation.VERTICAL,  true, true, false);               

        //personalización del grafico
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint( Color.white );
        xyplot.setDomainGridlinePaint( Color.BLACK );
        xyplot.setRangeGridlinePaint( Color.BLACK );  
       
        // -> Pinta Shapes en los puntos dados por el XYDataset
//        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
//        xylineandshaperenderer.setBaseShapesVisible(true);
//        //--> muestra los valores de cada punto XY
//        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
//        xylineandshaperenderer.setBaseItemLabelGenerator( xy );
//        xylineandshaperenderer.setBaseItemLabelsVisible(true);
//        xylineandshaperenderer.setBaseLinesVisible(true);
//        xylineandshaperenderer.setBaseItemLabelsVisible(true);                
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        BufferedImage bufferedImage  = jfreechart.createBufferedImage( d.width, d.height);
        this.setImage(bufferedImage);
    }

    /**
 * Datos
 */
     public ArrayList<Coordenada> ordenarArray(ArrayList<Coordenada> n) {
    double aux;
    double var;
    double opc;
    for (int i = 0; i < n.size() - 1; i++) {
       
        for (int x = i + 1; x < n.size(); x++) {
            if (n.get(x).getX() > n.get(i).getX()) {
                aux = n.get(i).getX();
                var=n.get(i).getY();
                opc=n.get(i).getZ();
                n.set(i, new Coordenada(n.get(x).getX(),n.get(x).getY(),n.get(x).getZ()));
                
                n.set(x, new Coordenada(aux,var,opc));
            }
        }
    }
 
    return n;
}
     
    private XYDataset xyDataset(ArrayList<Restriccion> rest,ArrayList<Coordenada> cor)
    {
        //se declaran las series y se llenan los datos
        
       XYSeriesCollection xyseriescollection =  new XYSeriesCollection();
      
      for (int i = 0; i <rest.size(); i++) {
          
         XYSeries sIngresos1 = new XYSeries("Grafica: "+rest.get(i).variable.get(0).getValor()+"X + "+rest.get(i).variable.get(1).getValor());
              
              for (int j = 0; j < ordenarArray(cor).get(0).getX(); j++) {
               if(rest.get(i).variable.get(3).getValor()!=0){
               sIngresos1.add(j,rest.get(i).variable.get(0).getValor()*j + rest.get(i).variable.get(1).getValor());    
               }else{
              sIngresos1.add(rest.get(i).variable.get(1).getValor(),j*1000);   
               }
              
              
            }    
              
           
         xyseriescollection.addSeries( sIngresos1 );      
          
           
      }
               

              

        return xyseriescollection;
    }
   

}//-->fin clase