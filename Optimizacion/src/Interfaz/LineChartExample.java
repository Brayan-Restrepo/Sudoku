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
import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import static com.googlecode.charts4j.Color.*;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataUtil;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Line;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Shape;
import static com.googlecode.charts4j.UrlUtil.normalize;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import optimizacion.Coordenada;
import optimizacion.Variable;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class LineChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }
          public ArrayList<Double> ordenarArray(ArrayList<Double> n) {
    double aux;
 
    for (int i = 0; i < n.size() - 1; i++) {
       
        for (int x = i + 1; x < n.size(); x++) {
            if (n.get(x) > n.get(i)) {
                aux = n.get(i);
                n.set(i, n.get(x));
                n.set(x, aux);
            }
        }
    }
 
    return n;
}
   @Test
    public void example2(ArrayList<Restriccion> rest,ArrayList<Coordenada> cor) throws IOException {
        // EXAMPLE CODE START
        // Defining Line
       
        ArrayList<Line> a=new ArrayList<Line>();
        ArrayList<Color> color=new ArrayList<Color>();
        ArrayList<Double> mayor=new ArrayList<Double>();
        color.add(RED);
        color.add(LIMEGREEN);
        color.add(BLUE);
        color.add(WHITE);
        color.add(BLACK);
        color.add(YELLOW);
        color.add(BROWN);
        color.add(AQUAMARINE);
        color.add(Color.DARKGRAY);
        color.add(Color.LIGHTSALMON);
        color.add(Color.BEIGE);
        color.add(Color.INDIGO);
        color.add(Color.KHAKI);
        color.add(Color.DEEPPINK);
        final double[] h=new double[15];
        LineChart chart=null;
        JOptionPane.showMessageDialog(null, rest.size());
        for (int i = 0; i < rest.size(); i++) {
       
            for (int j = 0; j < h.length; j++) {
         
         h[j]=rest.get(i).variable.get(0).getValor()*j + rest.get(i).variable.get(1).getValor();
         if(j==h.length-1){
         mayor.add(h[j]);
         }
            }
            
       Line line1 = Plots.newLine(DataUtil.scaleWithinRange(0,21,h), color.get(i), "Funcion "+rest.get(i).variable.get(0).getValor()+"X + "+rest.get(i).variable.get(1).getValor());
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.CIRCLE, YELLOW, 10);
        line1.addShapeMarkers(Shape.CIRCLE, BLACK, 7);
        for (int j = 0; j < cor.size(); j++) {
                for (int k = 0; k < h.length; k++) {
             if(cor.get(i).getY()==h[j]){
             line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,(int)h[j]);   
               }
                 
                }
            }
        
        
          line1.setFillAreaColor(LIGHTYELLOW);
          line1.setFillAreaColor(AQUA);
        a.add(line1);
         
      
        }
        
         chart = GCharts.newLineChart(a);
        // line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,3);
       

        // Defining chart.
      //  LineChart chart = GCharts.newLineChart(line1);
        chart.setSize(600, 450);
        chart.setTitle("Modo grafico", WHITE, 14);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(WHITE, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(0, 2000);
        
        yAxis.setAxisStyle(axisStyle);
       // AxisLabels xAxis1 = AxisLabelsFactory.newAxisLabels(Arrays.asList("Fed Chiefs:","Burns","Volcker","Greenspan","Bernanke"), Arrays.asList(5,18,39,55,92));
       // xAxis1.setAxisStyle(axisStyle);
        AxisLabels xAxis2 = AxisLabelsFactory.newNumericRangeAxisLabels(0, 15);
        xAxis2.setAxisStyle(axisStyle);
        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels("X", 50.0);
        xAxis3.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 14, AxisTextAlignment.CENTER));

        // Adding axis info to chart.
        chart.addYAxisLabels(yAxis);
       // chart.addXAxisLabels(xAxis1);
        chart.addXAxisLabels(xAxis2);
        chart.addXAxisLabels(xAxis3);
        
        chart.setGrid(100, 6.78, 5, 0);

        // Defining background and chart fills.
        chart.setBackgroundFill(Fills.newSolidFill(BLACK));
        chart.setAreaFill(Fills.newSolidFill(Color.newColor("708090")));
        displayUrlString(chart.toURLString());
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        Logger.global.info(url.length() + "");
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,000000|c,s,708090&chs=600x450&chd=e:CsDMDmD8EGEbD6D8EIE.EKC3D1EkEDEHEmFxFOF.HCHGI.KYKlL0O9OBRtSuT.TqaNgKpa0j-e46xilhvVzx1r8x-7,CsCyC4C.DFDMDTDbDiDqDyD7EEENEWEgEqE0E.FKFWFiFuF7GIGWGkGzHCHSHiHzIFIXIqI9JRJmJ7KSKpLALZLzMN&chtt=S+%26+P+500%7C1962+-+2008&chts=FFFFFF,14&chg=100.0,6.78,5,0&chxt=y,x,x,x&chxr=0,0.0,1475.25|1,0.0,100.0|2,1962.0,2008.0|3,0.0,100.0&chxs=0,FFFFFF,12,0|1,FFFFFF,12,0|2,FFFFFF,12,0|3,FFFFFF,14,0&chxl=1:|Fed+Chiefs%3A|Burns|Volcker|Greenspan|Bernanke|3:|Year&chxp=1,5,18,39,55,92|3,50.0&chdl=S+%26+P+500|Inflation&chco=FFFF00,32CD32&chm=o,FFFF00,0,-1,10,0|o,000000,0,-1,7,0|v,0000FF,0,8,3,0|v,0000FF,0,17,3,0|v,0000FF,0,24,3,0|v,0000FF,0,40,3,0|B,FFFFE0,0,0,0|o,00FF00,1,-1,10,0|o,000000,1,-1,7,0|B,90EE90,1,0,0&chls=3,1,0|3,1,0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
     private static void displayUrlString(final String urlString) throws IOException{
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new URL(urlString))));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
    ArrayList<Restriccion> a=new ArrayList<Restriccion>();
    ArrayList<Variable> var=new ArrayList<Variable>();
    var.add(new Variable("2",20));
     var.add(new Variable("2",0));
      var.add(new Variable("2",1));
       var.add(new Variable("2",1));
       ArrayList<Variable> var1=new ArrayList<Variable>();
    var1.add(new Variable("2",40));
     var1.add(new Variable("2",0));
      var1.add(new Variable("2",1));
       var1.add(new Variable("2",1));
     a.add(new Restriccion(var));
     a.add(new Restriccion(var1));
     
     ArrayList<Coordenada> coo=new ArrayList<Coordenada>();
     coo.add(new Coordenada(2,3));
     coo.add(new Coordenada(8,0));
    new LineChartExample().example2(a,coo);
    }

}
