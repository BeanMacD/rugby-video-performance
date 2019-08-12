import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Stats extends JPanel{
	private static final String COMMA_DELIMIER = ",";
	int count = 0;
	double MMMean = 0;
	int MMTotal = 0;
	double VelMean = 0;
	double TMadeMean = 0;
	int TMadeTotal = 0;
	double TMissedMean = 0;
	int TMissedTotal = 0;
	double TCompRate = 0;
	
	public JPanel readCSVFile(String Filename){
		BufferedReader fileReader = null;
		try{	
			
			String line = "";
			fileReader = new BufferedReader(new FileReader(Filename));
			fileReader.readLine();
			while((line=fileReader.readLine()) != null){
				String[] tokens = line.split(COMMA_DELIMIER);
				if(tokens.length>0){
					MMTotal += Integer.parseInt(tokens[1]);
					VelMean += Integer.parseInt(tokens[2]);
					TMadeTotal += Integer.parseInt(tokens[3]);
					TMissedTotal += Integer.parseInt(tokens[4]);
					count = tokens.length;
				}
			}
			return temp();
			
		}
			catch(Exception e){
				System.out.println("Error in CSVFileReader");
				e.printStackTrace();
			}
			finally{
				try{
					fileReader.close();
				}
				catch(IOException e){
					System.out.println("Error while closing filereader !!!!");
					e.printStackTrace();
				}
			}
		return temp();
}
	
	public JPanel temp(){
		JPanel ReturnPanel = new JPanel();
		JLabel MisTac = new JLabel();
		MisTac.setText("Missed Tackles: " +TMissedTotal);
		MisTac.setBounds(0, 0, 100, 50);
		JLabel MisTacMean = new JLabel();
		MisTacMean.setText("Avg Missed Tackles: " +TMissedTotal/count);
		MisTacMean.setBounds(0, 55, 100, 50);
		JLabel MadeTac = new JLabel();
		MadeTac.setText("Made Tackles: " + TMadeTotal);
		MadeTac.setBounds(0, 110, 100, 50);
		JLabel MadeTacMean = new JLabel();
		MadeTacMean.setText("Avg tackles made: " +TMadeTotal/count);
		MadeTacMean.setBounds(0, 165, 100, 50);
		JLabel CompRate = new JLabel();
		int Comp = TMadeTotal+TMissedTotal;
		CompRate.setText("Tackle Percentage Total: " +Comp/TMadeTotal);
		CompRate.setBounds(0, 215, 100, 50);
		JLabel VelMeanS = new JLabel();
		VelMeanS.setText("Average Vel: " +VelMean/count);
		VelMeanS.setBounds(0, 270, 100, 50);
		JLabel MetMade = new JLabel();
		MetMade.setText("Total Meters Made: " +MMTotal);
		MetMade.setBounds(0, 325, 100, 50);
		JLabel MetMadeMean = new JLabel();
		MetMadeMean.setText("Avg Meters Made: " +MMTotal/count);
		MetMadeMean.setBounds(0, 380, 100, 50);
		ReturnPanel.add(MisTac);
		ReturnPanel.add(MisTacMean);
		ReturnPanel.add(MadeTac);
		ReturnPanel.add(MadeTacMean);
		ReturnPanel.add(CompRate);
		ReturnPanel.add(VelMeanS);
		ReturnPanel.add(MetMade);
		ReturnPanel.add(MetMadeMean);
		return ReturnPanel;
	}
	
	
	
}
