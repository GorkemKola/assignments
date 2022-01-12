public class Film {
    /**
     * Number of Rates
     */
    public int numberOfRates;
    /**
     * Average Rating Score
     */
    private double averageRatingScore = 0.0;
    /**
     * Film ID
     */
    private int filmId;
    /**
     * Film Title
     */
    private String filmTitle;
    /**
     * Language
     */
    private String language;
    /**
     * Run Time
     */
    private int runTime;
    /**
     * Country
     */
    private String country;
    /**
     * Directors
     */
    private Director[] directors;
    /**
     * Performers
     */
    private Performer[] cast;
    /**
     * Film Type
     */
    private String filmType;

    /**
     * Empty Constructor
     */
    public Film() {
    }

    /**
     * Constructor Using Fields
     *
     * @param filmId    ID of Film
     * @param filmTitle Title of Film
     * @param language  Language of Film
     * @param runTime   Run Time of Film
     * @param country   Country of Film
     * @param directors Directors of Film
     * @param cast      Cast of Film
     * @param filmType  Type of Film
     */
    public Film(int filmId, String filmTitle, String language, int runTime, String country, Director[] directors, Performer[] cast, String filmType) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
        this.language = language;
        this.runTime = runTime;
        this.country = country;
        this.directors = directors;
        this.cast = cast;
        this.filmType = filmType;
        this.averageRatingScore = 0;
    }

    /**
     * Getter of Average Rating Score
     *
     * @return AverageRatingScore
     */
    public double getAverageRatingScore() {
        return this.averageRatingScore;
    }

    /**
     * Setter of Average Rating Score
     *
     * @param averageRatingScore AverageRating Score
     */
    public void setAverageRatingScore(double averageRatingScore) {
        this.averageRatingScore = averageRatingScore;
    }

    /**
     * Getter of Film ID
     *
     * @return FilmID
     */
    public int getFilmId() {
        return this.filmId;
    }


    /**
     * Getter of Film Title
     *
     * @return FilmTitle
     */
    public String getFilmTitle() {
        return this.filmTitle;
    }

    /**
     * Getter of Language
     *
     * @return Language
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Setter of Language
     *
     * @param language Language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Getter of Run Time
     *
     * @return RunTime
     */
    public int getRunTime() {
        return this.runTime;
    }

    /**
     * Getter of Country
     *
     * @return Country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Setter of Country
     *
     * @param country Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter Of Directors
     *
     * @return Directors
     */
    public Director[] getDirectors() {
        return this.directors;
    }

    /**
     * Setter of Directors
     *
     * @param directors Directors
     */
    public void setDirectors(Director[] directors) {
        this.directors = directors;
    }

    /**
     * Getter of Cast
     *
     * @return Cast
     */
    public Performer[] getCast() {
        return this.cast;
    }

    /**
     * Getter of Film Type
     *
     * @return FilmType
     */
    public String getFilmType() {
        return this.filmType;
    }

    /**
     * Fluent Setter of Average Rating Score
     *
     * @param averageRatingScore Average Rating Score
     */
    public void averageRatingScore(double averageRatingScore) {
        setAverageRatingScore(averageRatingScore);
    }

    /**
     * Fluent Setter of Language
     *
     * @param language Language
     * @return Film object (this)
     */
    public Film language(String language) {
        setLanguage(language);
        return this;
    }

    /**
     * Fluent Setter of Country
     *
     * @param country Country
     * @return Film object (this)
     */
    public Film country(String country) {
        setCountry(country);
        return this;
    }

    /**
     * Fluent Setter of Directors
     *
     * @param directors Directors
     * @return Film object (this)
     */
    public Film directors(Director[] directors) {
        setDirectors(directors);
        return this;
    }
}