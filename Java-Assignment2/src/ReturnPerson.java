import java.util.ArrayList;

public class ReturnPerson {
    /**
     * Finds Person by using ID
     *
     * @param people   An ArrayList holding people
     * @param personID Person ID
     * @return Person
     */
    public static Person returnPersonById(ArrayList<Person> people, int personID) {
        for (Person person : people) {
            if (personID == person.getId())
                return person;
        }
        return null;
    }

    /**
     * Finds people by using Person Type
     *
     * @param people     An ArrayList holding people
     * @param personType Person Type
     * @return Person ArrayList
     */
    public static ArrayList<Person> returnPeopleByType(ArrayList<Person> people, String personType) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (Person person : people) {
            if (personType.equals(person.getPersonType()))
                personArrayList.add(person);
        }
        return personArrayList;
    }
}
