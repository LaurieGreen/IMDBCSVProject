package file.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import config.management.ConfigManager;
import object.mapping.Movie;

public class MovieRecordScanner {
	private static final Logger logger = LogManager.getLogger( MovieRecordScanner.class );
	private final MovieFileReader movieFileReader = new MovieFileReader();
	private List<String[]> invalidMovies = new ArrayList<>();
	private int nextID = 1;

	public List<String[]> getInvalidMovies() {
		return invalidMovies;
	}

	public List<Movie> generateMovieData() {
		List<Movie> validMovies = new ArrayList<>();
		Scanner scanner = new Scanner(
				movieFileReader.movieFileReader( ConfigManager.movieDataTestFileLocation() ) );
		scanner.nextLine(); // to skip the CSV headers

		while ( scanner.hasNext() ) {
			String[] nextMovie = scanner.nextLine().split( "," );
			if ( validateData( nextMovie ) ) {
				validMovies.add(
						new Movie( nextID, nextMovie[0], nextMovie[1], nextMovie[2], nextMovie[3],
								nextMovie[4], nextMovie[5], nextMovie[6], nextMovie[7], nextMovie[8],
								nextMovie[9], nextMovie[10], nextMovie[11],
								nextMovie[12], nextMovie[13] ) );
				nextID++;
			} else {
				logger.info( "Incomplete movie data: " + Arrays.toString( nextMovie ) );
				invalidMovies.add( nextMovie );
			}
		}
		return validMovies;
	}

	private boolean validateData(String[] movie){
		if (movie.length != 14){
			return false;
		}
		for (String attribute: movie)
			if (attribute.equals( "" )){
				return false;
		}
		return true;
	}

}