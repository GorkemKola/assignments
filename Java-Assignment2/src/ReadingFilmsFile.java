import java.util.ArrayList;

public class ReadingFilmsFile extends FileInput {
    /**
     * The function readFilms reads films file and categorize Films and returns a Film ArrayList
     *
     * @param path   Address of films.txt
     * @param people An ArrayList holding people
     * @return Film ArrayList
     */
    public static ArrayList<Film> readFilms(String path, ArrayList<Person> people) {
        ArrayList<String> filmString;
        filmString = input(path);
        ArrayList<Film> filmList = new ArrayList<>();
        for (String line : filmString) {
            String[] lineList = line.split("\t");
            switch (lineList[0]) {
                case "FeatureFilm:": {
                    Director[] directors = getDirectors(people, lineList, 4);

                    Performer[] performers = getPerformers(people, lineList, 7);

                    String[] genres = lineList[8].split(",");

                    Writer[] writers = getWriters(people, lineList, 10);

                    FeatureFilm featureFilm = new FeatureFilm(Integer.parseInt(lineList[1]), lineList[2], lineList[3], directors, Integer.parseInt(lineList[5]),
                            lineList[6], performers, genres, lineList[9], writers);

                    filmList.add(featureFilm);

                    break;
                }
                case "ShortFilm:": {
                    Director[] directors = getDirectors(people, lineList, 4);

                    Performer[] performers = getPerformers(people, lineList, 7);

                    String[] genres = lineList[8].split(",");

                    Writer[] writers = getWriters(people, lineList, 10);

                    ShortFilm shortFilms = new ShortFilm(Integer.parseInt(lineList[1]), lineList[2], lineList[3], directors, Integer.parseInt(lineList[5]),
                            lineList[6], performers, genres, lineList[9], writers);
                    filmList.add(shortFilms);

                    break;
                }
                case "Documentary:": {

                    Director[] directors = getDirectors(people, lineList, 4);

                    Performer[] performers = getPerformers(people, lineList, 7);

                    Documentary documentary = new Documentary(Integer.parseInt(lineList[1]), lineList[2], lineList[3], directors, Integer.parseInt(lineList[5]),
                            lineList[6], performers, lineList[8]);
                    filmList.add(documentary);
                    break;
                }
                case "TVSeries:": {
                    Director[] directors = getDirectors(people, lineList, 4);

                    Performer[] performers = getPerformers(people, lineList, 7);

                    String[] genres = lineList[8].split(",");

                    Writer[] writers = getWriters(people, lineList, 9);

                    TVSeries tvSeries = new TVSeries(Integer.parseInt(lineList[1]), lineList[2], lineList[3], directors, Integer.parseInt(lineList[5]),
                            lineList[6], performers, genres, writers, lineList[10], lineList[11],
                            Integer.parseInt(lineList[12]), Integer.parseInt(lineList[13]));
                    filmList.add(tvSeries);
                    break;
                }
            }
        }
        return filmList;
    }

    /**
     * Getter for Writers Array
     *
     * @param people An ArrayList holding People
     * @param s      An Array of command line
     * @param j      Writers index
     * @return Writers
     */
    public static Writer[] getWriters(ArrayList<Person> people, String[] s, int j) {
        String[] writerList = s[j].split(",");
        Writer[] writers = new Writer[writerList.length];
        for (int i = 0; i < writerList.length; i++) {
            try {
                Person person = ReturnPerson.returnPersonById(people, Integer.parseInt(writerList[i]));
                assert person != null;
                writers[i] = Writer.getWriter(person);
            } catch (NullPointerException error) {
                continue;
            }
        }
        return writers;
    }

    /**
     * Getter for Performers Array
     *
     * @param people An ArrayList holding People
     * @param s      An Array of command line
     * @param j      Performers index
     * @return Performers (cast)
     */
    public static Performer[] getPerformers(ArrayList<Person> people, String[] s, int j) {
        String[] performerList = s[j].split(",");
        Performer[] performers = new Performer[performerList.length];
        for (int i = 0; i < performerList.length; i++) {
            try {
                Person person = ReturnPerson.returnPersonById(people, Integer.parseInt(performerList[i]));
                performers[i] = Performer.getPerformer(person);
            } catch (NullPointerException error) {
                continue;
            }
        }
        return performers;
    }

    /**
     * Getter for Directors Array
     *
     * @param people An ArrayList holding People
     * @param s      An Array of command line
     * @param j      Directors index
     * @return Directors
     */
    public static Director[] getDirectors(ArrayList<Person> people, String[] s, int j) {
        String[] directorList = s[j].split(",");
        Director[] directors = new Director[directorList.length];
        for (int i = 0; i < directorList.length; i++) {
            try {
                Person person = ReturnPerson.returnPersonById(people, Integer.parseInt(directorList[i]));
                directors[i] = Director.getDirector(person);
            } catch (NullPointerException error) {
                continue;
            }
        }
        return directors;
    }
}
