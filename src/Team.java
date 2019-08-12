import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Team extends JComponent{
Player[] players = {(new Player(1)), (new Player(2))};
	public Team(){
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(Player player: players){
			player.drawPlayer(g);
		}
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1000, 500);
	}
	
	
	
	
}
