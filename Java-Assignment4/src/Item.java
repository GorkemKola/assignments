public class Item {
    private String ID;
    private String SPECIES;

    Item(String ID, String SPECIES) {
        this.ID = ID;
        this.SPECIES = SPECIES;
    }

    /**
     * a getter of ID
     *
     * @return
     */
    public String getID() {
        return ID;
    }

    /**
     * a getter of SPECIES
     *
     * @return
     */
    public String getSPECIES() {
        return SPECIES;
    }

    /**
     * toString method use
     *
     * @return
     */
    @Override
    public String toString() {
        return ID + "\n";
    }
}