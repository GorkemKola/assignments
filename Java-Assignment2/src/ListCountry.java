import java.util.ArrayList;

public class ListCountry {

    /**
     * A Function that returns a string that Films shot in a Country
     *
     * @param films   An ArrayList holding Films
     * @param country A Country that films was shot
     * @return String that will be added on output
     */
    public static String country(ArrayList<Film> films, String country) {
        StringBuilder finalText = new StringBuilder();
        for (Film film : films) {
            if (film.getCountry().equals(country)) {
                finalText.append("Film title: ").append(film.getFilmTitle()).append("\n");
                finalText.append(film.getRunTime()).append(" min\n");
                finalText.append("Language: ").append(film.getLanguage()).append("\n\n");
            }
        }

        if (finalText.toString().equals(""))
            finalText.append("No result\n\n");
        return finalText.toString();
    }

}

