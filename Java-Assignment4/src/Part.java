import java.util.Arrays;
import java.util.Collections;


public class Part {
    String SPECIES;
    Stack<Item> items = new Stack<>();

    /**
     * a constructor
     *
     * @param SPECIES species
     */
    Part(String SPECIES) {
        this.SPECIES = SPECIES;
    }

    public void addItems(Item item) {
        items.push(item);
    }


    /**
     * toString method to use
     *
     * @return
     */
    @Override
    public String toString() {
        String x = "";
        for (int i = this.items.stack.size()-1; i >= 0 ; i--) {
            x += items.stack.get(i);
        }
        return this.SPECIES + ":\n" + x.trim() +
                "\n---------------\n";
    }
}