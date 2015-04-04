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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import optimizacion.Coordenada;
import optimizacion.Variable;

@SuppressWarnings("serial")
public class Game extends JPanel {

	static int x = 30;
	int y = 500;
        int x1 = 70;
	int y1 = 500;
        int x2 = 30;
	int y2 = 40;
        int x3 = 30;
        int y3 = 300;
       static ArrayList<Coordenada> valoresY=new ArrayList<Coordenada>();
        static ArrayList<Coordenada> valoresY1=new ArrayList<Coordenada>();
         static ArrayList<Coordenada> valoresY2=new ArrayList<Coordenada>();
        ArrayList<Coordenada> coe=new ArrayList<Coordenada>();
        ArrayList<Coordenada> caso2=new ArrayList<Coordenada>();
        ArrayList<Coordenada> caso3=new ArrayList<Coordenada>();
        ArrayList<Color> color=new ArrayList<Color>();
        public int compara(double num1,double num2,int pos){
        int dif=(int)Math.log10(num1)-(int)Math.log10(num2);
        if(dif==0){
           return pos+1; 
        }else if(dif>0){
         return pos;   
        }
        return 0;
        }
        public int comparaPrimero(double num1,double num2,int pos){
        int dif= (int)Math.log10(num1)-(int)Math.log10(num2);
        return pos+dif+1;
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
    public ArrayList<Coordenada> ordenarArray1(ArrayList<Coordenada> n) {
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
    
    public void cargarColores(){
      color.add(Color.CYAN);
      color.add(Color.GRAY);
      color.add(Color.MAGENTA);
      color.add(Color.DARK_GRAY);
      color.add(Color.PINK);
      color.add(Color.green);
      color.add(Color.ORANGE);
      color.add(Color.blue);
      color.add(Color.RED);
      color.add(Color.yellow);
      
    }
      public void hallaCoeficientes(){
            ArrayList<Restriccion> rest=new ArrayList<Restriccion>();
            ArrayList<Variable> var=new ArrayList<Variable>();
            var.add(new Variable("x2",1000));
            var.add(new Variable("b",0));
            var.add(new Variable("opc",1));
            var.add(new Variable("x1",1));
            ArrayList<Variable> var1=new ArrayList<Variable>();
            var1.add(new Variable("x2",1));
            var1.add(new Variable("b",3000));
            var1.add(new Variable("opc",2));
            var1.add(new Variable("x1",0));
             ArrayList<Variable> var2=new ArrayList<Variable>();
            var2.add(new Variable("x2",100));
            var2.add(new Variable("b",6000));
            var2.add(new Variable("opc",1));
            var2.add(new Variable("x1",1));
             ArrayList<Variable> var3=new ArrayList<Variable>();
            var3.add(new Variable("x2",0));
            var3.add(new Variable("b",6000));
            var3.add(new Variable("opc",1));
            var3.add(new Variable("x1",1));
             ArrayList<Variable> var4=new ArrayList<Variable>();
            var4.add(new Variable("x2",-60000));
            var4.add(new Variable("b",9000));
            var4.add(new Variable("opc",1));
            var4.add(new Variable("x1",1));
            rest.add(new Restriccion(var));
            rest.add(new Restriccion(var1));
            rest.add(new Restriccion(var2));
             rest.add(new Restriccion(var3));
             rest.add(new Restriccion(var4));
            ArrayList<Coordenada> caso1=new ArrayList<Coordenada>();
            
            for (int i = 0; i < rest.size(); i++) {
                if(rest.get(i).variable.get(3).getValor()!=0){
                if(rest.get(i).variable.get(0).getValor()>0){
                caso1.add(new Coordenada(rest.get(i).variable.get(0).getValor(),rest.get(i).variable.get(1).getValor(),1));     
                }else if(rest.get(i).variable.get(0).getValor()<0){
                caso1.add(new Coordenada(rest.get(i).variable.get(0).getValor(),rest.get(i).variable.get(1).getValor(),2));   
                }else if((rest.get(i).variable.get(0).getValor()==0)){
                 caso2.add(new Coordenada(0,rest.get(i).variable.get(1).getValor()));     
                }     
              }else{
              caso3.add(new Coordenada(rest.get(i).variable.get(1).getValor(),0));
             // JOptionPane.showMessageDialog(null, "Su y es cero"+rest.get(i).variable.get(1).getValor());
              }
 
             }
            
           
            if(caso2.size()>0){
             double aux1=caso2.get(0).getY();
             for (int i = 0; i < caso2.size(); i++) {
                if(aux1<caso2.get(i).getY()){
                aux1= caso2.get(i).getY();   
                }
              
            }
              int m1=0;   
          if(Math.log10(aux1)>1){
             m1=(int)(Math.log10(aux1));   
           }
          for (int i = 0; i < caso2.size(); i++) {
          caso2.set(i, new Coordenada(0,500-(20*(caso2.get(i).getY()/Math.pow(10, m1)))));
          }
            }
            
            if(caso3.size()>0){
            double aux2=caso3.get(0).getX();
           
             for (int i = 0; i < caso3.size(); i++) {
                if(aux2<caso3.get(i).getX()){
                aux2= caso3.get(i).getX();   
                }
              
            }
           int m2=0;
          
          if(Math.log10(aux2)>1){
             m2=(int)(Math.log10(aux2));   
           }
          for (int i = 0; i < caso3.size(); i++) {
          caso3.set(i, new Coordenada(30+(20*(caso3.get(i).getX()/Math.pow(10, m2))),0));
          }
             
            }
           if(caso1.size()>0){
            double aux=ordenarArray1(caso1).get(0).getY();
            for (int i = 0; i < ordenarArray1(caso1).size(); i++) {
                if(aux<ordenarArray1(caso1).get(i).getY()){
                aux= ordenarArray1(caso1).get(i).getY();   
                }
              
            }
                
        int m=0;
           if(Math.log10(aux)>1){
             m=(int)(Math.log10(aux));   
           }
          
         
           
            for (int i = 0; i < ordenarArray1(caso1).size(); i++) {
            ordenarArray1(caso1).set(i, new Coordenada(ordenarArray1(caso1).get(i).getX(),(ordenarArray1(caso1).get(i).getY()/Math.pow(10, m)),ordenarArray1(caso1).get(i).getZ()));
            }
            
             for (int i = 0; i < ordenarArray1(caso1).size()-1; i++) {
             if(i==0){
          
           coe.add( new Coordenada(comparaPrimero(ordenarArray1(caso1).get(0).getX(),ordenarArray1(caso1).get(1).getX(),ordenarArray1(caso1).size()),500-(ordenarArray1(caso1).get(0).getY()*20),ordenarArray1(caso1).get(0).getZ()));
           coe.add(new Coordenada(compara(ordenarArray1(caso1).get(0).getX(),ordenarArray1(caso1).get(1).getX(),ordenarArray1(caso1).size()),500-(ordenarArray1(caso1).get(1).getY()*20),ordenarArray1(caso1).get(1).getZ()));
           
            }else{
           coe.add(new Coordenada(compara(ordenarArray1(caso1).get(0).getX(),ordenarArray1(caso1).get(i+1).getX(),ordenarArray1(caso1).size()-i),500-(ordenarArray1(caso1).get(i+1).getY()*20),ordenarArray1(caso1).get(i+1).getZ()));
            }          
            }   
           }
             
            
            mostrar(coe);
          }
        public void mostrar(ArrayList<Coordenada> a){
            for (int i = 0; i < a.size(); i++) {
                System.out.println("valor: ("+a.get(i).getX()+","+a.get(i).getY()+")");    
            }
    
        }
        public void cargarDatos(){
            if(coe.size()>0){
            for (int i = 0; i < coe.size(); i++) {
            valoresY.add(new Coordenada(x,coe.get(i).getY(),coe.get(i).getZ()));    
            }    
            }
            if(caso2.size()>0){
                for (int i = 0; i < caso2.size(); i++) {
            valoresY1.add(new Coordenada(x,caso2.get(i).getY()));
                }
            }
            if(caso3.size()>0){
                for (int i = 0; i < caso3.size(); i++) {
             valoresY2.add(new Coordenada(caso3.get(i).getX(),y));
                }
   
            }
        
        }
        
        private void moverFuncion(){
            if(coe.size()>0){
              for (int i = 0; i < valoresY.size(); i++) {
             if(valoresY.get(i).getZ()==1){
              valoresY.set(i, new Coordenada(valoresY.get(i).getX()+1,valoresY.get(i).getY()-coe.get(i).getX(),coe.get(i).getZ()));   
             }else if(valoresY.get(i).getZ()==2){
             valoresY.set(i, new Coordenada(valoresY.get(i).getX()+1,valoresY.get(i).getY()+coe.get(i).getX(),coe.get(i).getZ()));   
    
             }  
             }   
            }
          
           if(caso2.size()>0){
           for (int i = 0; i <valoresY1.size(); i++) {
            valoresY1.set(i,new Coordenada(valoresY1.get(i).getX()+1,valoresY1.get(i).getY()));    
            }    
           }
           if(caso3.size()>0){
               for (int i = 0; i < valoresY2.size(); i++) {
            valoresY2.set(i,new Coordenada(valoresY2.get(i).getX(),valoresY2.get(i).getY()-1));
           //  JOptionPane.showMessageDialog(null, "("+valoresY2.get(i).getX()+","+valoresY2.get(i).getY()+")");
               }
           
           }
            
              
        }

	@Override
	public void paint(Graphics g) {
		//super.paint(g);
            cargarColores();
		Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5.0f));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
               
               if(valoresY.size()>0){
                 for (int i = 0; i < valoresY.size(); i++) {
                  if(valoresY.get(i).getZ()==1){
                // g2d.setColor(Color.black);
                 g2d.setColor(color.get(i));
                 g2d.drawLine((int)valoresY.get(i).getX(), (int)valoresY.get(i).getY(), (int)(valoresY.get(i).getX()+1), (int)(valoresY.get(i).getY()-coe.get(i).getX()));               
                // g2d.drawLine((int)(valoresY.get(i).getX()+1), (int)(valoresY.get(i).getY()-coe.get(i).getX()), (int)(valoresY.get(i).getX()+1-20), (int)(valoresY.get(i).getY()-coe.get(i).getX()-20));
                 // g2d.draw3DRect((int)valoresY.get(i).getX(), (int)valoresY.get(i).getY(), 10, 10, true);
                  // g2d.setColor(Color.red);
                 // g2d.setColor(color.get(i));
                // g2d.drawLine((int)(valoresY.get(i).getX()+1), (int)(valoresY.get(i).getY()-coe.get(i).getX()), (int)(valoresY.get(i).getX()+1-20), (int)(valoresY.get(i).getY()-coe.get(i).getX()-100));
                  }else if(valoresY.get(i).getZ()==2){
                       g2d.setColor(color.get(i));
                    //  g2d.setColor(Color.black); 
              g2d.drawLine((int)valoresY.get(i).getX(), (int)valoresY.get(i).getY(), (int)(valoresY.get(i).getX()+1), (int)(valoresY.get(i).getY()+coe.get(i).getX()));       
             //  g2d.setColor(color.get(i));
             // g2d.drawLine((int)(valoresY.get(i).getX()+1), (int)(valoresY.get(i).getY()+coe.get(i).getX()), (int)(valoresY.get(i).getX()+1+20), (int)(valoresY.get(i).getY()+coe.get(i).getX()-100));

                  }
              
                }    
               }
            
              if(valoresY1.size()>0){
                 
                  for (int i = 0; i < valoresY1.size(); i++) {
                 g2d.setColor(Color.black);
                 g2d.drawLine((int)valoresY1.get(i).getX(), (int)valoresY1.get(i).getY(), (int)(valoresY1.get(i).getX()+1), (int)valoresY1.get(i).getY());
               //  g2d.setColor(color.get(i+3));
                /// g2d.drawLine((int)(valoresY1.get(i).getX()+1), (int)valoresY1.get(i).getY(), (int)(valoresY1.get(i).getX()+1+20), (int)(valoresY1.get(i).getY()+100));

                  }
              }
              if(valoresY2.size()>0){
                
                  for (int i = 0; i < valoresY2.size(); i++) {
                      g2d.setColor(Color.black);
                  g2d.drawLine((int)valoresY2.get(i).getX(),(int)valoresY2.get(i).getY(), (int)valoresY2.get(i).getX(), (int)(valoresY2.get(i).getY()-1));
                  }
   
              }
          g2d.setColor(Color.black);
                 if (g instanceof Graphics2D)
   {
      Graphics2D g2 = (Graphics2D)g;
      g2.setStroke(new BasicStroke(5.0f)); // grosor de 5 pixels
      g2.drawLine (30, 507, 30, 50);    // linea vertical eje y
      g2.drawLine (30, 507, 470, 507);  // linea horizontal eje x
     
       int k=1;
       for (int i = 50; i < 470; i+=20) {
       g2.drawLine(i, 510, i, 500); 
       g2.drawString(Integer.toString(k), i,525);
       k++;
       }
       k=1;
      for (int i = 487; i > 40; i-=20) {
       g2.drawLine(25, i, 35, i); 
       g2.drawString(Integer.toString(k), 10,i);
       k++;
       }   
   }
                
                
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Grafica");
		Game game = new Game();
		frame.add(game);
		frame.setSize(600, 600);
                frame.setBackground(Color.white);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.hallaCoeficientes();
        game.cargarDatos();
        int x=0;
		while (true) {
		
                    
                        game.moverFuncion();
               
			game.repaint();
			Thread.sleep(40);
                        
		}
	}
}
