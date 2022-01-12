public class ShortFilm extends Film {
    /**
     * Release Date
     */
    private String releaseDate;

    /**
     * Writers
     */
    private Writer[] writers;

    /**
     * Genres
     */
    private String[] genres;

    /**
     * Empty Constructor
     */
    public ShortFilm() {
    }

    /**
     * Constructor Using Fields
     *
     * @param filmId      Film ID
     * @param filmTitle   Film Title
     * @param language    Language
     * @param directors   Directors
     * @param runTime     Run Time
     * @param country     Country where Film was shot
     * @param cast        Performers (Cast)
     * @param genres      Genres
     * @param releaseDate Release Date
     * @param writers     Writers
     */
    public ShortFilm(int filmId, String filmTitle, String language, Director[] directors, int runTime, String country, Performer[] cast, String[] genres, String releaseDate, Writer[] writers) {
        super(filmId, filmTitle, language, runTime, country, directors, cast, "ShortFilm");
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.genres = genres;
    }

    /**
     * Getter of Release Date
     *
     * @return Release Date
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
     * @return ShortFilm (this)
     */
    public ShortFilm writers(Writer[] writers) {
        setWriters(writers);
        return this;
    }

}
