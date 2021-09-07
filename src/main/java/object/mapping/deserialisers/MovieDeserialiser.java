package object.mapping.deserialisers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;

import config.management.ConfigManager;
import file.management.MovieFileReader;
import file.management.MovieRecordScanner;
import object.mapping.dtos.MovieDTO;

public class MovieDeserialiser {
	private static final Logger logger = LogManager.getLogger( MovieRecordScanner.class );
	private final MovieFileReader movieFileReader = new MovieFileReader();
	private List<String[]> invalidMovies = new ArrayList<>();

	public List<String[]> getInvalidMovies() {
		return invalidMovies;
	}


	public List<MovieDTO> generateMovieData(){
		CsvToBeanFilter filter = line -> {
			if (line.length != 14){
				logger.info( "Bad data found: "+ Arrays.toString( line ));
				invalidMovies.add( line );
				return false;
			}
			for (String attribute: line)
				if (attribute.equals( "" )){
					logger.info( "Bad data found: "+Arrays.toString( line ));
					invalidMovies.add( line );
					return false;
				}
			return true;
		};

		List<MovieDTO> movies;
		movies = new CsvToBeanBuilder(movieFileReader.movieFileReader( ConfigManager.movieDataTestFileLocation() ))
				.withType( MovieDTO.class)
				.withFilter( filter )
				.build()
				.parse();
		for (int i = 0; i < movies.size(); i++)
		{
			movies.get( i ).setId( i+1 );
		}
		return movies;
	}

}
