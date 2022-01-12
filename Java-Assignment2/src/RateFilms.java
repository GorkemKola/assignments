public class RateFilms {

    /**
     * A Function a User to vote
     *
     * @param ratingScore User's vote score
     * @param film        Film
     */
    public static void rateFilm(int ratingScore, Film film) {
        double rating = (ratingScore + film.getAverageRatingScore() * film.numberOfRates) / (++film.numberOfRates);
        film.averageRatingScore(rating);
    }

}
