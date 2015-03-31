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

	private void moveBall() {
		x = x + 1;
		y = y - 1;
	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, 8, 8);
                 if (g instanceof Graphics2D)
   {
      Graphics2D g2 = (Graphics2D)g;
      g2.setStroke(new BasicStroke(5.0f)); // grosor de 5 pixels
      g2.drawLine (30, 507, 30, 50);
      g2.drawLine (30, 507, 470, 507);
     
   }
                
                
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(600, 600);
                frame.setBackground(Color.white);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (x<470) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
