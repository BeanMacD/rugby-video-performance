
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVRead{
	private static final String COMMA_DELIMIER = ",";
	int count = 0;
	private int[][] temp;
	public List readCSVFile(String Filename){
		BufferedReader fileReader = null;
		try{	
			List Points = new ArrayList();
			String line = "";
			fileReader = new BufferedReader(new FileReader(Filename));
			fileReader.readLine();
			while((line=fileReader.readLine()) != null){
				String[] tokens = line.split(COMMA_DELIMIER);
				if(tokens.length>0){
					Point point = new Point(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
					Points.add(point);
				}
			}

			return Points;
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
		return null;
}
}