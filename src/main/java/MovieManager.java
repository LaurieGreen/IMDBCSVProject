import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import config.management.ConfigManager;
import file.management.MovieRecordScanner;
import file.management.OutputFileWriter;
import object.mapping.deserialisers.MovieDeserialiser;
import object.mapping.dtos.MovieDTO;
import object.mapping.Movie;

public class MovieManager {

	private MovieDeserialiser deserialiser = new MovieDeserialiser();
	private MovieRecordScanner recordScanner = new MovieRecordScanner();
	private OutputFileWriter outputFileWriter = new OutputFileWriter();

	private boolean usingOpenCsv(){
		return ConfigManager.movieExtractionMethod().equals( "opencsv" );
	}

	public List<JSONObject> getValidMoviesAsJson(String fileName){
		List<JSONObject> validMovies = new ArrayList<>();
		if (usingOpenCsv()){
			for( MovieDTO movie : deserialiser.generateMovieData(fileName)){
				validMovies.add( movie.toJson() );
			}
		}else{
			for (Movie movie : recordScanner.generateMovieData(fileName)){
				validMovies.add( movie.toJson() );
			}
		}
		outputFileWriter.writeJSONListToFile(ConfigManager.fileOutputLocation()+"validMovies.txt", validMovies );
		return validMovies;
	}

	public List<String[]> getInvalidMovies(){
		List<String[]> invalidMovies;
		if(usingOpenCsv()){
			invalidMovies = deserialiser.getInvalidMovies();
			outputFileWriter.writeListToFile(ConfigManager.fileOutputLocation()+"invalidMovies.txt",invalidMovies );
		}
		else {
			invalidMovies = recordScanner.getInvalidMovies();
			outputFileWriter.writeListToFile(ConfigManager.fileOutputLocation()+"invalidMovies.txt",invalidMovies );
		}
		return invalidMovies;
	}

	public static void main( String[] args ) {
		MovieManager manager = new MovieManager();
	}
}
