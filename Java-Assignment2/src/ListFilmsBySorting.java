import java.util.ArrayList;

public class ListFilmsBySorting {

    /**
     * A function that returns a string of Films sorted and categorized
     *
     * @param films An ArrayList holding films
     * @return String that will be added on output
     */
    public static String sort(ArrayList<Film> films) {

        StringBuilder finalText = new StringBuilder();
        StringBuilder featureFilms = new StringBuilder();
        StringBuilder shortFilms = new StringBuilder();
        StringBuilder series = new StringBuilder();
        StringBuilder documentaries = new StringBuilder();
        films.sort(new SortbyRateDegree());

        for (Film film : films) {
            String score = String.format("%.2g%n", film.getAverageRatingScore());
            if (("" + score.charAt(2)).equals("0")) {
                score = "" + score.charAt(0);
            }
            switch (film.getFilmType()) {
                case "FeatureFilm":
                    featureFilms.append(film.getFilmTitle()).append(" (").append(((FeatureFilm) film)
                            .getReleaseDate().substring(6)).append(") Ratings: ").append(score.trim())
                            .append("/10 from ").append(film.numberOfRates).append(" users\n");
                    break;
                case "Documentary":
                    documentaries.append(film.getFilmTitle()).append(" (").append(((Documentary) film)
                            .getReleaseDate().substring(6)).append(") Ratings: ").append(score.trim())
                            .append("/10 from ").append(film.numberOfRates).append(" users\n");

                    break;
                case "ShortFilm":
                    shortFilms.append(film.getFilmTitle()).append(" (").append(((ShortFilm) film)
                            .getReleaseDate().substring(6)).append(") Ratings: ").append(score.trim())
                            .append("/10 from ").append(film.numberOfRates).append(" users\n");

                    break;
                case "TVSeries":
                    series.append(film.getFilmTitle()).append(" (").append(((TVSeries) film)
                            .getStartDate().substring(6)).append("-").append(((TVSeries) film).getEndDate()
                            .substring(6)).append(") Ratings: ").append(score.trim()).append("/10 from ")
                            .append(film.numberOfRates).append(" users\n");
                    break;
                default:
                    break;
            }

        }
        finalText.append("FeatureFilm:\n");
        finalText.append(featureFilms).append("\n");
        finalText.append("ShortFilm:\n");
        finalText.append(shortFilms).append("\n");
        finalText.append("Documentary:\n");
        finalText.append(documentaries).append("\n");
        finalText.append("TVSeries:\n");
        finalText.append(series).append("\n");
        return finalText.toString();
    }

}
