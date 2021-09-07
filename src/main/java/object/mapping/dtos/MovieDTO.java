package object.mapping.dtos;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;

public class MovieDTO {

	private int id;

	public void setId( final int id ) {
		this.id = id;
	}


	@CsvBindByName
	private String title;
	@CsvBindByName(column = "score")
	private double imdbRating;
	@CsvBindByName
	private int year;
	@CsvBindByName
	private int duration;
	@CsvBindByName
	private String rating;
	@CsvBindByName
	private double budget;
	@CsvBindByName
	private String[] genres;
	@CsvBindByName
	private String gross;
	@CsvBindByName
	private String director;
	@CsvBindByName
	private String actor1;
	@CsvBindByName
	private String actor2;
	@CsvBindByName
	private String actor3;
	@CsvBindByName
	private String language;
	@CsvBindByName
	private String country;


	public int getYear() {
		return year;
	}

	public double getBudget() {
		return budget;
	}

	public String getGross() {
		return gross;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public int getDuration() {
		return duration;
	}

	public String getRating() {
		return rating;
	}

	public String[] getGenres() {
		return genres;
	}

	public String getDirector() {
		return director;
	}

	public String getActor1() {
		return actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public String getActor3() {
		return actor3;
	}

	public String[] getActors() {
		return new String[]{this.actor1,this.actor2,actor3};
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "MovieDTO{" + "id=" + id + ", title='" + title + '\'' + ", imdbRating=" + imdbRating + ", year=" + year + ", duration=" + duration + ", rating='" + rating + '\'' + ", budget=" + budget + ", genres=" + Arrays.toString(
				genres ) + ", gross='" + gross + '\'' + ", director='" + director + '\'' + ", actor1='" + actor1 + '\'' + ", actor2='" + actor2 + '\'' + ", actor3='" + actor3 + '\'' + ", language='" + language + '\'' + ", country='" + country + '\'' + '}';
	}

	public JSONObject toJson(){
		JSONObject jsonMovie = new JSONObject();
		jsonMovie.put( "id", this.id );
		jsonMovie.put( "Title",this.title );
		jsonMovie.put( "imdb_rating",this.imdbRating );
		jsonMovie.put( "Duration", this.duration );
		jsonMovie.put( "Rating",this.rating );
		jsonMovie.put( "Budget",this.budget );
		jsonMovie.put( "Genres", new JSONArray(Arrays.asList( getGenres() )) );
		jsonMovie.put( "Director",this.director );
		jsonMovie.put( "Actors", new JSONArray(Arrays.asList( getActors() )) );
		jsonMovie.put( "Language",this.language );
		jsonMovie.put( "Country",this.country );
		return jsonMovie;
	}
}
