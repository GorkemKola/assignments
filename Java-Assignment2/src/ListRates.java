import java.util.ArrayList;

public class ListRates extends Writer {

    /**
     * A function that returns a string of a User's votes
     *
     * @param films         An ArrayList holding Films
     * @param userId        A User's Id that will votes list
     * @param usersWhoVoted An ArrayList holding Information about User ID and User's voted Film ID and User's votes as an ArrayList holding Integers
     * @return String that will be added on output
     */
    public static String rates(ArrayList<Film> films, int userId, ArrayList<ArrayList<Integer>> usersWhoVoted) {
        StringBuilder finalText = new StringBuilder();
        for (ArrayList<Integer> arrayList : usersWhoVoted) {
            if (arrayList.get(0) == userId) {
                for (Film film : films) {
                    if (film.getFilmId() == arrayList.get(1))
                        finalText.append(film.getFilmTitle()).append(": ").append(usersWhoVoted.get(usersWhoVoted.indexOf(arrayList)).get(2)).append("\n");
                }
            }
        }
        if (finalText.toString().equals("")) {
            finalText.append("Command Failed\n");
            finalText.append("User ID: ").append(userId).append("\n");
        }
        return finalText + "\n";
    }

}
