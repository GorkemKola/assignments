import java.util.Arrays;

public class ViewFilms {

    /**
     * This function returns a string that includes lots of information of film
     *
     * @param film Film
     * @return String
     */
    public static String viewFilm(Film film) {
        StringBuilder finalText = new StringBuilder();
        finalText.append(film.getFilmTitle()).append(" (");

        switch (film.getFilmType()) {
            case "FeatureFilm": {
                finalText.append(((FeatureFilm) film).getReleaseDate().substring(6)).append(")\n");
                String genre = Arrays.toString(((FeatureFilm) film).getGenres());
                genre = genre.replace("[", "");
                genre = genre.replace("]", "");

                finalText.append(genre).append("\n");

                finalText.append("Writers: ");
                for (int i = 0; i < ((FeatureFilm) film).getWriters().length; i++) {
                    finalText.append(((FeatureFilm) film).getWriters()[i].getName()).append(" ").append(((FeatureFilm) film).getWriters()[i].getSurname());
                    if (i < ((FeatureFilm) film).getWriters().length - 1) {
                        finalText.append(", ");
                    }
                }

                writeCharacters(finalText, film);
                break;
            }
            case "Documentary":
                finalText.append(((Documentary) film).getReleaseDate().substring(6)).append(")\n");

                writeCharacters(finalText, film);

                break;
            case "TVSeries": {
                finalText.append(((TVSeries) film).getStartDate().substring(6)).append("-").append(((TVSeries) film).getEndDate().substring(6)).append(")\n");
                finalText.append(((TVSeries) film).getNumberOfSeasons()).append(" seasons, ").append(((TVSeries) film).getNumberOfEpisodes()).append(" episodes\n");

                String genre = Arrays.toString(((TVSeries) film).getGenres());
                genre = genre.replace("[", "");
                genre = genre.replace("]", "");

                finalText.append(genre).append("\n");
                finalText.append("Writers: ");
                for (int i = 0; i < ((TVSeries) film).getWriters().length; i++) {
                    finalText.append(((TVSeries) film).getWriters()[i].getName()).append(" ").append(((TVSeries) film).getWriters()[i].getSurname());
                    if (i < ((TVSeries) film).getWriters().length - 1) {
                        finalText.append(", ");
                    }
                }

                writeCharacters(finalText, film);
                break;
            }
            case "ShortFilm": {
                finalText.append(((ShortFilm) film).getReleaseDate().substring(6)).append(")\n");
                String genre = Arrays.toString(((ShortFilm) film).getGenres());
                genre = genre.replace("[", "");
                genre = genre.replace("]", "");

                finalText.append(genre).append("\n");
                finalText.append("Writers: ");
                for (int i = 0; i < ((ShortFilm) film).getWriters().length; i++) {
                    finalText.append(((ShortFilm) film).getWriters()[i].getName()).append(" ").append(((ShortFilm) film).getWriters()[i].getSurname());
                    if (i < ((ShortFilm) film).getWriters().length - 1) {
                        finalText.append(", ");
                    }
                }

                writeCharacters(finalText, film);
                break;
            }
            default:
                break;
        }

        return finalText.toString();
    }

    /**
     * Since I write too many characters I made a function that append characters to the final Text
     *
     * @param finalText Final Text
     * @param film      Film
     */
    private static void writeCharacters(StringBuilder finalText, Film film) {
        finalText.append("\n");
        writeDirectors(finalText, film);

        finalText.append("\n");
        writeStars(finalText, film);

        finalText.append("\n");
        ratingLine(finalText, film);
    }

    /**
     * This function writes the Stars to Final Text
     *
     * @param finalText Final Text
     * @param film      Film
     */
    private static void writeStars(StringBuilder finalText, Film film) {
        finalText.append("Stars: ");
        for (int i = 0; i < film.getCast().length; i++) {
            finalText.append(film.getCast()[i].getName()).append(" ").append(film.getCast()[i].getSurname());
            if (i < film.getCast().length - 1) {
                finalText.append(", ");
            }
        }
    }

    /**
     * This function writes the Directors to Final Text
     *
     * @param finalText Final Text
     * @param film      Film
     */
    private static void writeDirectors(StringBuilder finalText, Film film) {
        finalText.append("Directors: ");
        for (int i = 0; i < film.getDirectors().length; i++) {
            finalText.append(film.getDirectors()[i].getName()).append(" ").append(film.getDirectors()[i].getSurname());
            if (i < film.getDirectors().length - 1) {
                finalText.append(", ");
            }
        }
    }

    /**
     * This function writes rating line to Final Text
     *
     * @param finalText Final Text
     * @param film      Film
     */
    private static void ratingLine(StringBuilder finalText, Film film) {
        if (film.numberOfRates != 0)
            ratingCalculator(finalText, film);
        else
            finalText.append("Awaiting for votes\n\n");
    }

    /**
     * This function prepares the rating for ratingLine function
     *
     * @param finalText Final Text
     * @param film      Film
     */
    private static void ratingCalculator(StringBuilder finalText, Film film) {
        String score = String.format("%.2g%n", film.getAverageRatingScore());
        if (("" + score.charAt(2)).equals("0")) {
            score = "" + score.charAt(0);
        }
        finalText.append("Ratings: ").append(score.trim()).append("/10 from ").append(film.numberOfRates).append(" users\n\n");
    }
}