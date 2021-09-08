import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import config.management.ConfigManager;
import file.management.MovieRecordScanner;
import object.mapping.deserialisers.MovieDeserialiser;
import object.mapping.dtos.MovieDTO;

import object.mapping.Movie;

public class Main {
	private static final Logger logger = LogManager.getLogger( Main.class );

	public static void main( String[] args ) {

		MovieManager manager = new MovieManager();
		List<JSONObject> validMovies = manager.getValidMoviesAsJson( ConfigManager.movieDataTestFileLocation() );
		List<String[]> invalidMovies = manager.getInvalidMovies();

//		logger.info( "Good data, from file reader: " + validMovies.size() );
//		logger.info( "Good data, from file reader, as JSON: " );
//		for ( JSONObject movie : validMovies ) {
//			logger.debug( movie.toString() );
//		}

//		logger.info( "Total good data, from CSVDTO: " + validMovies.size() );
//		logger.info( "Good data, from CSVDTO, as JSON: " );
//		for ( JSONObject movie : validMovies ) {
//			logger.info( movie.toString() );
//		}
		logger.info( "Total bad data: " + invalidMovies.size() );
	}
}
