import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class DrawPlayer extends JPanel {
	private  int D_W = 1000;
	private  int D_H = 500;
	List<Player> players;
	BufferedImage img = null;
	public DrawPlayer(){
		players = new ArrayList<>();
		for(int i=1; i<16; i++){
			players.add(new Player(i));
		}
	    

		 try {
		     img = ImageIO.read(new File("/Users/noellemacdonagh/Desktop/Players/Pitch.png"));
		 } catch (IOException e) {
		 }
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for (Player player: players){
					player.moveBall();
					repaint();
				}
			}
		});
		timer.start();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        ImageObserver observer = null;
		g.drawImage(img, 0, 0, 1000, 500, observer);
        for (Player player : players) {
            player.drawPlayer(g);
        }
    }
	

	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(D_W, D_H);
	}
	
}
