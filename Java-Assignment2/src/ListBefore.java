import java.util.ArrayList;

public class ListBefore {

    /**
     * A Function that returns a String of the List of the Films that before a year
     *
     * @param films An ArrayList holding films
     * @param year  a parameter that allows the function to find the years before that year
     * @return String that will be added on output
     */
    public static String before(ArrayList<Film> films, int year) {
        StringBuilder finalText = new StringBuilder();
        for (Film film : films) {
            if (Integer.parseInt(((FeatureFilm) film).getReleaseDate().substring(6)) < year) {
                finalText.append("Film title: ").append(film.getFilmTitle()).append(" (").append(((FeatureFilm) film).getReleaseDate().substring(6)).append(")\n");
                finalText.append(film.getRunTime()).append(" min\n");
                finalText.append("Language: ").append(film.getLanguage()).append("\n\n");
            }
        }

        if (finalText.toString().equals(""))
            finalText.append("No result\n\n");
        return finalText.toString();
    }
}