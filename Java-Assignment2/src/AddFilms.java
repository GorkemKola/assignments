import java.util.ArrayList;

public class AddFilms {
    /**
     * This function adds a Feature Film to Films ArrayList (But I did not use budget because the budget is usable nowhere.)
     */


    /**
     * Adding Film Function
     *
     * @param films       An ArrayList holding Films
     * @param filmId      Id of film
     * @param title       Title of film
     * @param language    Language of film
     * @param directors   An array holding directors
     * @param runTime     Run Time of film
     * @param country     Country where the was shot
     * @param performers  An array holding Performers
     * @param genres      Genres of film
     * @param releaseDate The Feature Film's Release Date
     * @param writers     An array holding Writers
     */
    public static void addFilm(ArrayList<Film> films,
                               int filmId, String title, String language, Director[] directors,
                               int runTime, String country, Performer[] performers,
                               String[] genres, String releaseDate, Writer[] writers) {
        FeatureFilm featureFilm = new FeatureFilm(filmId, title, language, directors, runTime, country, performers, genres, releaseDate, writers);
        films.add(featureFilm);
    }

}
