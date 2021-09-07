package file.management;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MovieFileReader {
	public FileReader movieFileReader(String movieFileLocation){
		try {
			return new FileReader(movieFileLocation);
		} catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
