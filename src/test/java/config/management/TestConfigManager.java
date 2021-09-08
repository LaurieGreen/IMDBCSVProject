package config.management;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestConfigManager {
	private static final Properties config;

	static {
		config = new Properties();
		try {
			config.load( new FileReader( "src/test/config.properties" ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}


	public static String testMovieDataTestFileLocation(){
		return config.getProperty( "movie_test_data_test_file_location" );
	}

}
