public class TVSeries extends Film {
    /**
     * Start Date
     */
    private final String startDate;

    /**
     * End Date
     */
    private final String endDate;

    /**
     * Number of Seasons
     */
    private final int numberOfSeasons;

    /**
     * Number of Episodes
     */
    private final int numberOfEpisodes;

    /**
     * Genres
     */
    private final String[] genres;

    /**
     * Writers
     */
    private Writer[] writers;

    /**
     * Constructor Using Fields
     *
     * @param filmId           Film ID
     * @param filmTitle        Film Title
     * @param language         Language
     * @param directors        Directors
     * @param runTime          Run Time
     * @param country          Country where Series was shot
     * @param cast             Performers (Cast)
     * @param genres           Genres
     * @param writers          Writers
     * @param startDate        Start Date
     * @param endDate          End Date
     * @param numberOfSeasons  Number of Seasons
     * @param numberOfEpisodes Number of Episodes
     */
    public TVSeries(int filmId, String filmTitle,
                    String language, Director[] directors, int runTime, String country,
                    Performer[] cast, String[] genres, Writer[] writers, String startDate, String endDate,
                    int numberOfSeasons, int numberOfEpisodes) {
        super(filmId, filmTitle, language, runTime, country, directors, cast, "TVSeries");
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.genres = genres;
        this.writers = writers;
    }

    /**
     * Getter of Start Date
     *
     * @return Start Date
     */
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * Getter of End Date
     *
     * @return End Date
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * Getter of Number of Seasons
     *
     * @return Number of Seasons
     */
    public int getNumberOfSeasons() {
        return this.numberOfSeasons;
    }

    /**
     * Getter of Number of Episodes
     *
     * @return Number of Episodes
     */
    public int getNumberOfEpisodes() {
        return this.numberOfEpisodes;
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
     * Fluent Setter of Writers
     *
     * @param writers Writers
     * @return Writers
     */
    public TVSeries writers(Writer[] writers) {
        setWriters(writers);
        return this;
    }


}