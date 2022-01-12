public class Remove {
    /**
     * Remove the rate of a User and calculates Film's Average Rating Score
     *
     * @param film   Film
     * @param rating Rating of a User
     */
    public static void removeRate(Film film, int rating) {
        double newRating = ((film.getAverageRatingScore() * film.numberOfRates) - rating) / film.numberOfRates;
        film.numberOfRates--;
        film.setAverageRatingScore(newRating);
    }
}
