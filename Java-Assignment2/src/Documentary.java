public class Documentary extends Film {
    /**
     * Release Date
     */
    private final String releaseDate;

    /**
     * Constructor Using Fields
     *
     * @param filmId      Id of Film
     * @param filmTitle   Title of Film
     * @param language    Language of Film
     * @param directors   An array holding Directors
     * @param runTime     Run Time Of Film
     * @param country     Country where Film was shot
     * @param cast        An array holding Performers
     * @param releaseDate Release date of Documentary
     */
    public Documentary(int filmId, String filmTitle, String language, Director[] directors, int runTime, String country, Performer[] cast, String releaseDate) {
        super(filmId, filmTitle, language, runTime, country, directors, cast, "Documentary");
        this.releaseDate = releaseDate;
    }

    /**
     * Getter of the Release Date
     *
     * @return ReleaseDate
     */
    public String getReleaseDate() {
        return this.releaseDate;
    }
}
