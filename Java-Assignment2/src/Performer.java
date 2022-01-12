public class Performer extends Artist {

    /**
     * Empty Constructor
     */
    public Performer() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      Person ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param role    Role
     */
    public Performer(int id, String name, String surname, String country, String role) {
        super(id, name, surname, country, role);
    }

    /**
     * Getter of Performer
     *
     * @param person A performer
     * @return Performer
     */
    public static Performer getPerformer(Person person) {
        Performer performer = new Performer();
        performer.id(person.getId());
        performer.name(person.getName());
        performer.surname(person.getSurname());
        performer.country(person.getCountry());
        return performer;
    }
}
