public class Actor extends Performer {
    /**
     * Height is defined here
     */
    private int height;

    /**
     * Empty constructor
     */
    public Actor() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      Person Id
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param height  Height
     */
    public Actor(int id, String name, String surname, String country, int height) {
        super(id, name, surname, country, "Actor");
        this.height = height;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return this.height;
    }
}
