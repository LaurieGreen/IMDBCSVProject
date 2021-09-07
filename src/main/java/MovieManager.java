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

	private List<JSONObject> validMovies;
	private String[] invalidMovies;
	private MovieDeserialiser deserialiser = new MovieDeserialiser();
	private MovieRecordScanner recordScanner = new MovieRecordScanner();
	private OutputFileWriter outputFileWriter = new OutputFileWriter();

	private boolean usingOpenCsv(){
		return ConfigManager.movieExtractionMethod().equals( "opencsv" );
	}

	public List<JSONObject> getValidMoviesAsJson(){
		List<JSONObject> validMovies = new ArrayList<>();
		if(usingOpenCsv()){
			for( MovieDTO movie : deserialiser.generateMovieData()){
				validMovies.add( movie.toJson() );
			}
		}else{
			for (Movie movie : recordScanner.generateMovieData()){
				validMovies.add( movie.toJson() );
			}
		}
		return validMovies;
	}

	public List<String[]> getInvalidMovies(){
		List<String[]> invalidMovies = new ArrayList<>();
		if(usingOpenCsv()){
			invalidMovies = deserialiser.getInvalidMovies();
			outputFileWriter.writeListToFile("validMovies.txt",invalidMovies );
		}
		else {
			invalidMovies = recordScanner.getInvalidMovies();
			outputFileWriter.writeListToFile("invalidMovies.txt",invalidMovies );
		}
		return invalidMovies;
	}

	public static void main( String[] args ) {
		MovieManager manager = new MovieManager();
	}
}
