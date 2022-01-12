import java.util.ArrayList;

public class ReturnFilm {
    /**
     * Finds Film by using ID
     *
     * @param films  An ArrayList holding Films
     * @param filmId Film ID
     * @return Film
     */
    public static Film returnFilmById(ArrayList<Film> films, int filmId) {
        for (Film film : films) {
            if (filmId == film.getFilmId())
                return film;
        }
        return null;
    }

    /**
     * Finds Films bu using Type
     *
     * @param films    An ArrayList holding Films
     * @param filmType Film type
     * @return Film ArrayList
     */
    public static ArrayList<Film> returnFilmsByType(ArrayList<Film> films, String filmType) {
        ArrayList<Film> filmArrayList = new ArrayList<>();
        for (Film film : films) {
            if (filmType.equals(film.getFilmType())) {
                filmArrayList.add(film);
            }
        }
        return filmArrayList;
    }
}
