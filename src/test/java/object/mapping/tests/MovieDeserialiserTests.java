package object.mapping.tests;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import config.management.TestConfigManager;
import object.mapping.deserialisers.MovieDeserialiser;
import object.mapping.dtos.MovieDTO;

public class MovieDeserialiserTests {

	static List<MovieDTO> validMoviesFromTestData;
	static List<String[]> invalidMoviesFromTestData;


	@BeforeAll
	public static void setup(){
		MovieDeserialiser testMovieDeserialiser = new MovieDeserialiser(  );
		validMoviesFromTestData = testMovieDeserialiser.generateMovieData( TestConfigManager.testMovieDataTestFileLocation() );
		invalidMoviesFromTestData = testMovieDeserialiser.getInvalidMovies();
	}

	@Test
	public void totalCorrectRecordsFromData(){
		assertEquals( 1, validMoviesFromTestData.size());
		assertEquals( 2, invalidMoviesFromTestData.size());
	}
}
