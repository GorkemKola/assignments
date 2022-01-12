public class StuntPerformer extends Performer {
    /**
     * I did not use real Actor's ID because it is usable nowhere
     */

    /**
     * Height
     */
    private int height;

    /**
     * Empty Constructor
     */
    public StuntPerformer() {
    }

    /**
     * Constructor Using Fields
     *
     * @param id      Person ID
     * @param name    Name
     * @param surname Surname
     * @param country Country
     * @param height  Height
     */
    public StuntPerformer(int id, String name, String surname, String country, int height) {
        super(id, name, surname, country, "StuntPerformer");
        this.height = height;
    }

    /**
     * Getter of Height
     *
     * @return Height
     */
    public int getHeight() {
        return this.height;
    }

}