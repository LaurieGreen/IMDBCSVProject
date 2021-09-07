package object.mapping;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;


public class Movie {
	private int id;
	private String title;
	private String imdbRating;
	private String year;
	private String duration;
	private String rating;
	private String budget;
	private String[] genres;
	private String gross;
	private String director;
	private String[] actors;
	private String language;
	private String country;

	public Movie( final int id, final String title, final String imdbRating, final String year,final String duration,
			final String rating, final String budget, final String genres, final String gross, final String director,
			final String actor1, final String actor2, final String actor3, final String language,
			final String country ) {
		this.id = id;
		this.title = title;
		this.imdbRating = imdbRating;
		this.year = year;
		this.duration = duration;
		this.rating = rating;
		this.budget = budget;
		this.genres = genres.split( "\\|" );
		this.gross = gross;
		this.director = director;
		this.actors = new String[]{actor1, actor2, actor3};
		this.language = language;
		this.country = country;
	}

	public String getYear() {
		return year;
	}

	public String getBudget() {
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

	public String getImdbRating() {
		return imdbRating;
	}

	public String getDuration() {
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

	public String[] getActors(){
		return actors;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "object.mapping.Movie{" + "id=" + id + ", title='" + title + '\'' + ", imdbRating='" + imdbRating + '\'' + ", year='" + year + '\'' + ", duration='" + duration + '\'' + ", rating='" + rating + '\'' + ", budget='" + budget + '\'' + ", genres=" + Arrays.toString(
				genres ) + ", gross='" + gross + '\'' + ", director='" + director + '\'' + ", actors=" + Arrays.toString(
				actors ) + ", language='" + language + '\'' + ", country='" + country + '\'' + '}';
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
