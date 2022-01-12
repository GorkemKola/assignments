public class Director extends Artist {
    /**
     * Defining Director
     */
    private String agent;

    Director() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param agent   Agent where Director works
     */
    Director(int id, String name, String surname, String country, String agent) {
        super(id, name, surname, country, "Director");
        this.agent = agent;
    }

    /**
     * Getter of Director to Use in Adding Films and Defining Films
     *
     * @param person A person object to hold the informations
     * @return Director
     */
    public static Director getDirector(Person person) {
        Director director = new Director();
        director.id(person.getId());
        director.name(person.getName());
        director.surname(person.getSurname());
        director.country(person.getCountry());
        director.agent(((Director) person).getAgent());
        return director;
    }

    /**
     * Getter of Agent
     *
     * @return agent
     */
    public String getAgent() {
        return this.agent;
    }

    /**
     * Setter of Agent
     *
     * @param agent agent
     */
    public void setAgent(String agent) {
        this.agent = agent;
    }

    /**
     * Fluent Setter of Agent
     *
     * @param agent agent
     */
    public void agent(String agent) {
        setAgent(agent);
    }
}
