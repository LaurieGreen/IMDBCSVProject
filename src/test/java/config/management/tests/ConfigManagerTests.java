package config.management.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import config.management.ConfigManager;

public class ConfigManagerTests {

	@Test
	public void movieDataTestFileLocationTest(){
		Assertions.assertEquals( ConfigManager.movieDataTestFileLocation(),"src/main/resources/imdb_data.csv");
	}

	@Test
	public void fileOutputLocationTest(){
		assertEquals(ConfigManager.fileOutputLocation(),"src/main/log/");
	}

	@Test
	public void movieExtractionMethodTest(){
		assertEquals(ConfigManager.movieExtractionMethod(),"opencsv");
	}

}
