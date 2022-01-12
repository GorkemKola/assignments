import java.util.ArrayList;

public class ReadingPeopleFile extends FileInput {
    /**
     * The function readPeople reads People file and Categorize people
     *
     * @param path Address for people.txt
     * @return A Person ArrayList
     */
    public static ArrayList<Person> readPeople(String path) {
        ArrayList<String> peopleString;
        peopleString = input(path);
        ArrayList<Person> peopleList = new ArrayList<>();
        for (String line : peopleString) {
            String[] lineList = line.split("\t");
            switch (lineList[0]) {
                case "Director:":
                    Director director = new Director(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4], lineList[5]);
                    peopleList.add(director);
                    break;
                case "Writer:":
                    Writer writer = new Writer(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4], lineList[5]);
                    peopleList.add(writer);
                    break;
                case "Actor:":
                    Actor actor = new Actor(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4], Integer.parseInt(lineList[5]));
                    peopleList.add(actor);
                    break;
                case "ChildActor:":
                    ChildActor childActor = new ChildActor(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4], Integer.parseInt(lineList[5]));
                    peopleList.add(childActor);
                    break;
                case "User:":
                    User user = new User(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4]);
                    peopleList.add(user);
                    break;
                case "StuntPerformer:":
                    StuntPerformer stuntPerformer = new StuntPerformer(Integer.parseInt(lineList[1]), lineList[2], lineList[3], lineList[4], Integer.parseInt(lineList[5]));
                    peopleList.add(stuntPerformer);
                    break;
            }
        }
        return peopleList;
    }
}
