import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class line extends JPanel {
	private int Lx;
	private int Ly;
	public line(int x, int y){
		Lx = x;
		Ly = y;
	}
	
	protected void drawLine(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(Lx, Ly, 3, 500);
	}
	
	protected void drawPitch(Graphics g){
		g.setColor(Color.WHITE);
		g.drawOval(500, 0, 20, 20);
	}
	
	
	
	
}
