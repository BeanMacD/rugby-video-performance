import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BallAnimation {

    public static void main(String[] args) {
        new BallAnimation();
    }

    public BallAnimation() {
    	JPanel container = new JPanel();
    	container.setLayout(null);
    	JFXPanel VideoPanel  = new JFXPanel();
    	JPanel TacticalPanel = new JPanel();
    	JPanel VIDEO = new JPanel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setBackground(Color.BLACK);
                frame.setSize(1200, 1000);
                TacticalPanel.add(new DrawPlayer());
                VIDEO.add(VideoPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(
                                0, 0, 0, 0), 0, 0));
                container.add(TacticalPanel);
                container.add(VIDEO);
                Stats temp = new Stats();
                JPanel stats = temp.readCSVFile("/Users/noellemacdonagh/Desktop/Players/temp.csv");
                container.add(stats);
                TacticalPanel.setBounds(0, 0, 1000, 500);
                VIDEO.setBounds(0, 550, 1000, 500);
                stats.setBounds(1100, 0, 200, 400);
                TacticalPanel.repaint();
                VIDEO.repaint();
                stats.repaint();
                frame.add(container);
                initFX(VideoPanel);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(2000, 1200);
                frame.setVisible(true);
            }
        });
    }
    
    private static void initFX(JFXPanel Video){
    	Scene scene = createScene();
    	Video.setScene(scene);
    }
    
    private static Scene createScene(){
    	Group root = new Group();
    	String workingDir = System.getProperty("user.dir");
    	final File f = new File(workingDir, "FinalVideoEditTest.avi");
    	final Media m = new Media(f.toURI().toString());
    	final MediaPlayer mp = new MediaPlayer(m);
    	final MediaView mv = new MediaView(mp);
    	mv.autosize();
    	final DoubleProperty width = mv.fitWidthProperty();
    	final DoubleProperty height = mv.fitHeightProperty();
    	width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
    	height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
    	root.getChildren().add(mv);
    	final Scene scene = new Scene(root, 1000, 500);
    
    	return scene;
    }
    
    



}