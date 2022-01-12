import java.util.ArrayList;
import java.util.Arrays;


public class ReadingCommandsFile extends FileInput {

    /**
     * This Function reads commands file and returns a string
     *
     * @param pathOfPeople   Address of people.txt
     * @param pathOfFilms    Address of films.txt
     * @param pathOfCommands Address of Commands.txt
     * @return String to write on output file
     */
    public static String readCommands(String pathOfPeople, String pathOfFilms, String pathOfCommands) {
        /**
         * I used StringBuilder here because String is useless in for loops.
         */
        StringBuilder finalText = new StringBuilder();

        /**
         * Creating some ArrayLists
         */
        ArrayList<String> commands = input(pathOfCommands);
        ArrayList<ArrayList<Integer>> usersWhoVoted = new ArrayList<>();
        ArrayList<Person> people = ReadingPeopleFile.readPeople(pathOfPeople);
        ArrayList<Film> films = ReadingFilmsFile.readFilms(pathOfFilms, people);

        /**
         * Creating ID Checking Lists
         */
        ArrayList<Integer> writerIdCheckingList = new ArrayList<>();
        ArrayList<Integer> directorIdCheckingList = new ArrayList<>();
        ArrayList<Integer> performerIdCheckingList = new ArrayList<>();

        ArrayList<Integer> userIdCheckingList = new ArrayList<>();
        for (Person value : people) {
            if (value.getPersonType().equals("User"))
                userIdCheckingList.add(value.getId());
        }

        ArrayList<Integer> filmIdCheckingList = new ArrayList<>();
        for (Film value : films) filmIdCheckingList.add(value.getFilmId());

        for (Person person : people) {

            /**
             * Filling ID Checking Lists
             */
            if (person.getPersonType().equals("Artist")) {
                switch (((Artist) person).getRole()) {
                    case "Writer":
                        writerIdCheckingList.add(person.getId());
                        break;
                    case "Director":
                        directorIdCheckingList.add(person.getId());
                        break;
                    case "Actor":
                    case "ChildActor":
                    case "StuntPerformer":
                        performerIdCheckingList.add(person.getId());
                        break;
                    default:
                        break;
                }
            }
        }

        for (String commandLine : commands) {
            finalText.append(commandLine).append("\n\n");
            String[] command = commandLine.split("\t");


            if (command[0].equals("RATE")) {
                /**
                 * Defining some local parameters to use
                 */
                Film film = ReturnFilm.returnFilmById(films, Integer.parseInt(command[2]));
                Person person = ReturnPerson.returnPersonById(people, Integer.parseInt(command[1]));
                ArrayList<Integer> checkingFilms = new ArrayList<>();
                checkingFilms.add(Integer.parseInt(command[1]));
                checkingFilms.add(Integer.parseInt(command[2]));
                checkingFilms.add(Integer.parseInt(command[3]));
                boolean isLoopFinished = false;
                for (ArrayList<Integer> checker : usersWhoVoted) {
                    if (checker.get(0).equals(checkingFilms.get(0)) && checker.get(1).equals(checkingFilms.get(1))) {
                        isLoopFinished = true;
                        break;
                    }
                }

                /**
                 * If Person did not vote any films and Film and Person is a User, he/she can vote
                 */
                if (!isLoopFinished && filmIdCheckingList.contains(checkingFilms.get(1)) && userIdCheckingList.contains(checkingFilms.get(0))) {
                    finalText.append("Film rated successfully\n");
                    finalText.append("Film type: ").append(film.getFilmType()).append("\n");
                    finalText.append("Film title: ").append(film.getFilmTitle()).append("\n\n");
                    usersWhoVoted.add(checkingFilms);

                    RateFilms.rateFilm(Integer.parseInt(command[3]), film);
                }
                /**
                 * There is no such user or the film is not exists,
                 */
                else if (!filmIdCheckingList.contains(Integer.parseInt(command[2])) || !userIdCheckingList.contains(Integer.parseInt(command[1]))) {
                    finalText.append("Command Failed\n");
                    finalText.append("User ID: ").append(command[1]).append("\n");
                    finalText.append("Film ID: ").append(command[2]).append("\n\n");
                }

                /**
                 * otherwise the program understand that the User has voted earlier
                 */
                else {
                    finalText.append("This film was earlier rated\n\n");
                }
            } else if (command[0].equals("ADD") && command[1].equals("FEATUREFILM")) {
                /**
                 * Creating Arrays that will be using from command line
                 */
                Director[] directors = ReadingFilmsFile.getDirectors(people, command, 5);

                Performer[] performers = ReadingFilmsFile.getPerformers(people, command, 8);

                String[] genres = command[9].split(",");

                Writer[] writers = ReadingFilmsFile.getWriters(people, command, 11);

                String[] tempList = new String[films.size()];
                for (int i = 0; i < tempList.length; i++)
                    tempList[i] = "" + films.get(i).getFilmId();

                boolean isLoopFinished = false;
                for (String i : command[5].split(",")) {
                    if (!directorIdCheckingList.contains(Integer.parseInt(i)))
                        isLoopFinished = true;
                }
                for (String i : command[8].split(",")) {
                    if (!performerIdCheckingList.contains(Integer.parseInt(i)))
                        isLoopFinished = true;
                }

                for (String i : command[11].split(",")) {
                    if (!writerIdCheckingList.contains(Integer.parseInt(i)))
                        isLoopFinished = true;
                }

                /**
                 * if there is no film in the list and directors, performers and writers are exists then AddFilms function will work
                 */
                if (!Arrays.asList(tempList).contains(command[2]) && !isLoopFinished) {
                    AddFilms.addFilm(films, Integer.parseInt(command[2]),
                            command[3], command[4], directors,
                            Integer.parseInt(command[6]), command[7],
                            performers, genres, command[10], writers);
                    finalText.append("FeatureFilm added successfully\n");
                    filmIdCheckingList.add(Integer.parseInt(command[2]));
                } else
                    finalText.append("Command Failed\n");
                finalText.append("Film ID: ").append(command[2]).append("\n");
                finalText.append("Film title: ").append(command[3]).append("\n\n");
                filmIdCheckingList.add(Integer.parseInt(command[2]));

            } else if (command[0].equals("VIEWFILM")) {
                try {
                    Film film = ReturnFilm.returnFilmById(films, Integer.parseInt(command[1]));
                    finalText.append(ViewFilms.viewFilm(film));
                } catch (NullPointerException error) {
                    finalText.append("Command Failed").append("\n");
                    finalText.append("Film ID: ").append(command[1]).append("\n\n");
                }
            } else if (command[0].equals("EDIT")) {
                ArrayList<Integer> check = new ArrayList<>();
                check.add(Integer.parseInt(command[2]));
                check.add(Integer.parseInt(command[3]));
                check.add(Integer.parseInt(command[4]));
                boolean isLoopFinished = false;
                ArrayList<Integer> checker = new ArrayList<>();
                for (ArrayList<Integer> checking : usersWhoVoted) {
                    if ((checking.get(0).equals(check.get(0))) && checking.get(1).equals(check.get(1))) {
                        isLoopFinished = true;
                        checker = new ArrayList<>(checking);
                        break;
                    }
                }
                /**
                 * if user did not vote that film then program adds the final text command failed
                 */
                if (!isLoopFinished) {
                    finalText.append("Command Failed\n");
                    finalText.append("User ID: ").append(Integer.parseInt(command[2])).append("\n");
                    finalText.append("Film ID: ").append(Integer.parseInt(command[3])).append("\n\n");
                }
                /**
                 * else rating would be edited
                 */
                else {
                    Film film = ReturnFilm.returnFilmById(films, Integer.parseInt(command[3]));
                    try {
                        if (film.getFilmId() == check.get(1)) {
                            Edit.editFilm(film, checker.get(2), Integer.parseInt(command[4]));
                            finalText.append("New ratings done successfully\n");
                            finalText.append("Film title: ").append(film.getFilmTitle()).append("\n");
                            finalText.append("Your rating: ").append(command[4]).append("\n\n");
                            usersWhoVoted.set(usersWhoVoted.indexOf(checker), check);
                        }
                    } catch (NullPointerException error) {
                        finalText.append("Command Failed\n");
                        finalText.append("User ID: ").append(Integer.parseInt(command[2])).append("\n");
                        finalText.append("Film ID: ").append(Integer.parseInt(command[3])).append("\n\n");
                    }
                }


            } else if (command[0].equals("REMOVE") && command[1].equals("RATE")) {
                ArrayList<Integer> check = new ArrayList<>();
                check.add(Integer.parseInt(command[2]));
                check.add(Integer.parseInt(command[3]));
                boolean isLoopFinished = false;
                ArrayList<Integer> checker = new ArrayList<>();
                for (ArrayList<Integer> checking : usersWhoVoted) {
                    if (checking.get(0).equals(check.get(0)) && checking.get(1).equals(check.get(1))) {
                        isLoopFinished = true;
                        checker = new ArrayList<>(checking);
                        break;
                    }
                }
                /**
                 * If user did not voted that film then program adds final text command failed
                 */
                if (!isLoopFinished) {
                    finalText.append("Command Failed\n");
                    finalText.append("User ID: ").append(Integer.parseInt(command[2])).append("\n");
                    finalText.append("Film ID: ").append(Integer.parseInt(command[3])).append("\n\n");
                }

                /**
                 * else vote would be removed
                 */
                else {
                    Film film = ReturnFilm.returnFilmById(films, Integer.parseInt(command[3]));
                    Remove.removeRate(film, checker.get(2));
                    finalText.append("Your film rating was removed successfully\n");
                    finalText.append("Film title: ").append(film.getFilmTitle()).append("\n\n");
                    usersWhoVoted.remove(checker);
                }
            } else if (command[0].equals("LIST") && command[1].equals("FILM") && command[2].equals("SERIES"))
                finalText.append(ListSeries.series(ReturnFilm.returnFilmsByType(films, "TVSeries")));

            else if (command[0].equals("LIST") && command[1].equals("FEATUREFILMS") && command[2].equals("BEFORE"))
                finalText.append(ListBefore.before(ReturnFilm.returnFilmsByType(films, "FeatureFilm"), Integer.parseInt(command[3])));

            else if (command[0].equals("LIST") && command[1].equals("FEATUREFILMS") && command[2].equals("AFTER"))
                finalText.append(ListAfter.after(ReturnFilm.returnFilmsByType(films, "FeatureFilm"), Integer.parseInt(command[3])));

            else if (command[0].equals("LIST") && command[1].equals("FILMS") && command[2].equals("BY") && command[3].equals("COUNTRY"))
                finalText.append(ListCountry.country(films, command[4]));

            else if (command[0].equals("LIST") && command[1].equals("ARTISTS") && command[2].equals("FROM"))
                finalText.append(ListArtists.artists(ReturnPerson.returnPeopleByType(people, "Artist"), command[3]));

            else if (command[0].equals("LIST") && command[1].equals("FILMS") && command[2].equals("BY") && command[3].equals("RATE") && command[4].equals("DEGREE"))
                finalText.append(ListFilmsBySorting.sort(films));

            else if (command[0].equals("LIST") && command[1].equals("USER") && command[3].equals("RATES")) {
                finalText.append(ListRates.rates(films, Integer.parseInt(command[2]), usersWhoVoted));
            }

            finalText.append("-----------------------------------------------------------------------------------------------------\n");
        }
        return finalText.toString();
    }
}