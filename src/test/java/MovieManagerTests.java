import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.management.TestConfigManager;

public class MovieManagerTests {

	static List<JSONObject> validMoviesAsJsonFromTestData;
	static List<String[]> invalidMoviesFromTestData;

	@BeforeAll
	public static void setup() {
		MovieManager manager = new MovieManager( );
		validMoviesAsJsonFromTestData = manager.getValidMoviesAsJson( TestConfigManager.testMovieDataTestFileLocation()  );
		invalidMoviesFromTestData = manager.getInvalidMovies();
	}

	@Test
	public void totalCorrectRecordsFromData(){
		assertEquals( 1, validMoviesAsJsonFromTestData.size());
		assertEquals( 2, invalidMoviesFromTestData.size());
	}

	@Test
	public void correctFileOutputFromData(){

	}
}
