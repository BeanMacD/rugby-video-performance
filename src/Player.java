import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComponent;


public class Player extends JComponent {
        private int x = 0;
        private int y = 0;
        private ArrayList<Point> points;
        private int Dx;
        private int Dy;     
        private int i = 0;
        private int ID;
        private List temp2;
        public Player(int PlayerID){
        	ID = PlayerID;
        	CSVRead CSVRead = new CSVRead();
        	temp2 = CSVRead.readCSVFile("/Users/noellemacdonagh/Desktop/Players/temp" +ID+".csv");
        	points = (ArrayList<Point>) temp2;
        	x = points.get(0).XValue;
        	y = points.get(0).YValue;
        	}



        	protected void moveBall() {
        	Dx = points.get(i).XValue;
        	Dy = points.get(i).YValue;
        	if(x==Dx&&y==Dy){
        		i+=1;
        	}

        	if(x<Dx){
        		x++;
        	}
        	if(x>Dx){
        		x--;
        	}

        	if(y<Dy){
        		y++;
        		
        	}
        	if(y>Dy){
        		y--;
        		
        	}
        	}

        	protected void drawPlayer(Graphics g) {
        	g.setColor(Color.BLUE);
        	g.fillOval(x, y, 10, 10);
        	}
    
        
        
        
        
        
        
       
}