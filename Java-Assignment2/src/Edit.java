public class Edit {

    /**
     * A function that Edit Ratings
     *
     * @param film      Film
     * @param oldRating User's old Rating
     * @param newRating User's new Rating
     */
    public static void editFilm(Film film, int oldRating, int newRating) {
        double newAverageRating = ((film.getAverageRatingScore() * film.numberOfRates) - oldRating + newRating) / film.numberOfRates;
        film.setAverageRatingScore(newAverageRating);
    }
}
