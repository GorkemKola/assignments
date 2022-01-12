import java.util.ArrayList;

public class ListArtists {

    /**
     * A Function that returns a string of the the Artists
     *
     * @param people  people List
     * @param country Country
     * @return String that will be added on output
     */
    public static String artists(ArrayList<Person> people, String country) {
        StringBuilder finalText = new StringBuilder();
        StringBuilder directors = new StringBuilder();
        StringBuilder writers = new StringBuilder();
        StringBuilder actors = new StringBuilder();
        StringBuilder childActors = new StringBuilder();
        StringBuilder stuntPerformers = new StringBuilder();

        for (Person person : people) {
            if (person.getPersonType().equals("Artist") && person.getCountry().equals(country)) {
                switch (((Artist) person).getRole()) {
                    case "Director":
                        directors.append(person.getName()).append(" ").append(person.getSurname()).append(" ").append(((Director) person).getAgent()).append("\n");
                        break;
                    case "Writer":
                        writers.append(person.getName()).append(" ").append(person.getSurname()).append(" ").append(((Writer) person).getWritingStyle()).append("\n");
                        break;
                    case "Actor":
                        actors.append(person.getName()).append(" ").append(person.getSurname()).append(" ").append(((Actor) person).getHeight()).append(" cm\n");
                        break;
                    case "ChildActor":
                        childActors.append(person.getName()).append(" ").append(person.getSurname()).append(" ").append(((ChildActor) person).getAge()).append("\n");
                        break;
                    case "StuntPerformer":
                        stuntPerformers.append(person.getName()).append(" ").append(person.getSurname()).append(" ").append(((StuntPerformer) person).getHeight()).append(" cm\n");
                        break;
                }
            }
        }
        if (directors.toString().equals(""))
            directors.append("No result\n");

        if (writers.toString().equals(""))
            writers.append("No result\n");

        if (actors.toString().equals(""))
            actors.append("No result\n");

        if (childActors.toString().equals(""))
            childActors.append("No result\n");

        if (stuntPerformers.toString().equals(""))
            stuntPerformers.append("No result\n");

        finalText.append("Directors:\n");
        finalText.append(directors).append("\n");
        finalText.append("Writers:\n");
        finalText.append(writers).append("\n");
        finalText.append("Actors:\n");
        finalText.append(actors).append("\n");
        finalText.append("ChildActors:\n");
        finalText.append(childActors).append("\n");
        finalText.append("StuntPerformers:\n");
        finalText.append(stuntPerformers).append("\n");
        return finalText.toString();
    }
}
