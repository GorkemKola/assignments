public class Artist extends Person {
    /**
     * Defining Artists
     */

    /**
     * Role
     * I defined role here because I couldn't figure out how to use personType for subclasses of Artist.
     */
    String role;

    /**
     * Empty Constructor
     */
    Artist() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      Person ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param role    Role that shows Artist's Orientation
     */
    Artist(int id, String name, String surname, String country, String role) {
        super(id, name, surname, country, "Artist");
        this.role = role;
    }

    /**
     * Getter Of Role
     *
     * @return role
     */
    public String getRole() {
        return this.role;
    }
}

    