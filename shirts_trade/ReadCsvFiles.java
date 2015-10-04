package shirt_trade;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * Class ReadCsvFiles
 * 
 * @author David Sajdl 
 * @version 7
 */
public class ReadCsvFiles {

	
	public BufferedReader readCSVFileFromWebsite(String url) throws IOException{
		URL stockURL = new URL(url);
		return new BufferedReader(new InputStreamReader(stockURL.openStream()));
	}
	
	public BufferedReader readCSVFileFromCompoter(String pathToFile) throws IOException{
		return new BufferedReader(new FileReader(pathToFile));
	}

}