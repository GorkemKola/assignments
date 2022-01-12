import java.util.ArrayList;

public class ListSeries {

    /**
     * A Function that returns a string of Series
     *
     * @param films An Arraylist holding Series
     * @return String that will be added on output
     */
    public static String series(ArrayList<Film> films) {
        StringBuilder finalText = new StringBuilder();
        for (Film film : films) {
            finalText.append(film.getFilmTitle()).append(" (").append(((TVSeries) film).getStartDate().substring(6)).append("-").append(((TVSeries) film).getEndDate().substring(6)).append(")\n");
            finalText.append(((TVSeries) film).getNumberOfSeasons()).append(" seasons and ").append(((TVSeries) film).getNumberOfEpisodes()).append(" episodes\n\n");
        }
        return finalText.toString();
    }
}
