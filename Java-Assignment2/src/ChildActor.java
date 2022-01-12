public class ChildActor extends Performer {
    /**
     * Defining ChildActor
     */

    /**
     * Age
     */
    private final int age;

    /**
     * Constructor Using Fields
     *
     * @param id      Person ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param age     Age of the Child Actor
     */
    ChildActor(int id, String name, String surname, String country, int age) {
        super(id, name, surname, country, "ChildActor");
        this.age = age;
    }

    /**
     * @return Age
     */
    public int getAge() {
        return this.age;
    }

}
