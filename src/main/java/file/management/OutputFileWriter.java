package file.management;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class OutputFileWriter {
	BufferedWriter writer;

	public void writeListToFile(String fileName, List<String[]> data) {
		try {
			writer = new BufferedWriter( new FileWriter( fileName ));
			for (String[] line : data)
			{
				writer.append( line+"\n" );
			}
			writer.append( "Total records: "+data.size() );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
