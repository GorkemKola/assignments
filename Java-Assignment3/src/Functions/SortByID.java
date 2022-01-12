package Functions;

import Pieces.Character;

import java.util.Comparator;

public class SortByID implements Comparator<Character> {
    /**
     * This function is to sort the character arraylist.
     *
     * @param o1 first character
     * @param o2 second character
     * @return an integer value.
     */
    @Override
    public int compare(Character o1, Character o2) {
        return o1.getID().compareTo(o2.getID());
    }
}
