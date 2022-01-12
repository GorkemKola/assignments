public class FeatureFilm extends Film {
    /**
     * I did not use budget because the budget is usable nowhere.
     */

    /**
     * Release Date of FeatureFilm
     */
    private String releaseDate;

    /**
     * An array holding writers
     */
    private Writer[] writers;

    /**
     * An array holding genres
     */
    private String[] genres;

    /**
     * Empty Constructor
     */
    public FeatureFilm() {
    }

    /**
     * Constructor Using Fields
     *
     * @param filmId      Id of film
     * @param filmTitle   Title of film
     * @param language    Language of film
     * @param directors   An array holding directors
     * @param runTime     Run Time of film
     * @param country     Country where the was shot
     * @param cast        An array holding Performers
     * @param genres      Genres of film
     * @param releaseDate The Feature Film's Release Date
     * @param writers     An array holding Writers
     */
    public FeatureFilm(int filmId, String filmTitle, String language, Director[] directors, int runTime, String country, Performer[] cast, String[] genres, String releaseDate, Writer[] writers) {
        super(filmId, filmTitle, language, runTime, country, directors, cast, "FeatureFilm");
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.genres = genres;
    }

    /**
     * Getter of Release Date
     *
     * @return ReleaseDate
     */
    public String getReleaseDate() {
        return this.releaseDate;
    }

    /**
     * Getter of Writers
     *
     * @return Writers
     */
    public Writer[] getWriters() {
        return this.writers;
    }

    /**
     * Setter of Writers
     *
     * @param writers Writers
     */
    public void setWriters(Writer[] writers) {
        this.writers = writers;
    }

    /**
     * Getter of Genres
     *
     * @return Genres
     */
    public String[] getGenres() {
        return this.genres;
    }

    /**
     * Fluent Setter of Writers
     *
     * @param writers Writers
     * @return FeatureFilm object (this)
     */
    public FeatureFilm writers(Writer[] writers) {
        setWriters(writers);
        return this;
    }
}
