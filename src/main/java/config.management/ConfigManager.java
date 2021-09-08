package config.management;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static final Properties config;

	static {
		config = new Properties();
		try {
			config.load( new FileReader( "src/main/config.properties" ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String movieExtractionMethod(){
		return config.getProperty( "movie_extraction_method" );
	}

	public static String movieDataTestFileLocation(){
		return config.getProperty( "movie_data_test_file_location" );
	}

	public static String fileOutputLocation(){
		return config.getProperty( "movie_output_file_location" );
	}


	public static void main( String[] args ) {
		System.out.println( ConfigManager.movieExtractionMethod() );
	}
}
