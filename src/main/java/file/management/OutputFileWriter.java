package file.management;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class OutputFileWriter {
	BufferedWriter writer;

	public void writeListToFile(String fileName, List<String[]> data) {
		try {
			writer = new BufferedWriter( new FileWriter( fileName ));
			for (String[] line : data)
			{
				writer.append( Arrays.toString(line)+"\n" );
			}
			writer.append( "Total records: "+data.size() );
			writer.flush();
			writer.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public void writeJSONListToFile(String fileName, List<JSONObject> data) {
		try {
			writer = new BufferedWriter( new FileWriter( fileName ));
			for (JSONObject line : data)
			{
				writer.append( line+"\n" );
			}
			writer.append( "Total records: "+data.size() );
			writer.flush();
			writer.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
