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
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	static int x = 30;
	int y = 500;
        static int x1 = 70;
	int y1 = 500;
        static int x2 = 30;
	int y2 = 40;
        static int x3 = 30;
	int y3 = 300;
	private void moveBall() {
		x = x + 1;
		y = y - 1;
	}
     private void moveBall1() {
		x1 = x1 + 1;
		y1 = y1 - 2;
	}
     private void moveBall2() {
		x2 = x2 + 1;
		y2 = y2 + 4;
	}
      private void moveBall3() {
		x3 = x3 + 1;
		y3 = y3 - 1;
	}
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5.0f));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//g2d.fillOval(x, y, 8, 8);
                 g2d.drawLine(x, y, x+1, y-1);
                 
                 g2d.drawLine(x1, y1, x1+1, y1-2);
                 g2d.drawLine(x2, y2, x2+1, y2+4);
                 g2d.drawLine(x3, y3, x3+1, y3-1);
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
		
		while (x<470) {
			game.moveBall();
                        game.moveBall1();
                        game.moveBall2();
                        game.moveBall3();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
