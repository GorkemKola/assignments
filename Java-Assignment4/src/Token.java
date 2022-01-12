public class Token {
    String ID;
    String SPECIES;
    int number;

    /**
     * A constructor
     *
     * @param ID      ID
     * @param SPECIES species
     * @param number  number of how many items could be bought
     */
    public Token(String ID, String SPECIES, int number) {
        this.ID = ID;
        this.SPECIES = SPECIES;
        this.number = number;
    }

    @Override
    public String toString() {
        return ID + " " + SPECIES + " " + number + "\n";
    }
}
