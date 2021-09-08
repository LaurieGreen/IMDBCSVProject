package object.mapping.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.management.TestConfigManager;
import object.mapping.deserialisers.MovieDeserialiser;
import object.mapping.dtos.MovieDTO;

public class MovieDTOTests {

	static List<MovieDTO> validMoviesFromTestData;
	static List<String[]> invalidMoviesFromTestData;


	@BeforeAll
	public static void setup(){
		MovieDeserialiser testMovieDeserialiser = new MovieDeserialiser(  );
		validMoviesFromTestData = testMovieDeserialiser.generateMovieData( TestConfigManager.testMovieDataTestFileLocation() );
		invalidMoviesFromTestData = testMovieDeserialiser.getInvalidMovies();
	}

	@Test
	public void correctContentFromData(){
		assertEquals( "Monsters, Inc.", validMoviesFromTestData.get( 0 ).getTitle());
		assertEquals( 8.1, validMoviesFromTestData.get( 0 ).getImdbRating());
		assertEquals( 2001, validMoviesFromTestData.get( 0 ).getYear());
		assertEquals( 92, validMoviesFromTestData.get( 0 ).getDuration());
		assertEquals( "G", validMoviesFromTestData.get( 0 ).getRating());
		assertEquals( 115000000, validMoviesFromTestData.get( 0 ).getBudget());
		assertArrayEquals( new String[]{ "Adventure","Animation","Comedy","Family","Fantasy"} , validMoviesFromTestData.get( 0 ).getGenres());
		assertEquals( 289907418, validMoviesFromTestData.get( 0 ).getGross());
		assertEquals( "Pete Docter", validMoviesFromTestData.get( 0 ).getDirector());
		assertEquals( "Steve Buscemi", validMoviesFromTestData.get( 0 ).getActor1());
		assertEquals( "John Ratzenberger", validMoviesFromTestData.get( 0 ).getActor2());
		assertEquals( "James Coburn", validMoviesFromTestData.get( 0 ).getActor3());
		assertArrayEquals( new String[]{ validMoviesFromTestData.get( 0 ).getActor1(),validMoviesFromTestData.get( 0 ).getActor2(),validMoviesFromTestData.get( 0 ).getActor3()} , validMoviesFromTestData.get( 0 ).getActors());
	}
}
