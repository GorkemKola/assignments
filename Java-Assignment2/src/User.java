public class User extends Person {
    /***
     * Empty Constructor
     */
    public User() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      Person ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     */
    public User(int id, String name, String surname, String country) {
        super(id, name, surname, country, "User");
    }
}
