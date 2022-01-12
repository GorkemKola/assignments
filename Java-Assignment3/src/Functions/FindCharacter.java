package Functions;

import Pieces.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class FindCharacter {
    /**
     * this function returns a character that we want to use.
     *
     * @param board      mxn gamezone
     * @param id         character's id
     * @param characters characters ArrayList
     * @return an Object class that has information of the character.
     */
    public static Object[] returnCharacter(String[][] board, String id, ArrayList<Character> characters) {
        for (Character character : characters) {
            for (int j = 0; j < board.length; j++) {
                if (Arrays.asList(board[j]).contains(id)) {
                    for (int k = 0; k < board[j].length; k++) {
                        if (character.getID().equals(id) && character.getID().equals(board[j][k])) {
                            Object[] character_information = {character, j, k};
                            return character_information;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * This function is returns an ArrayList that includes information about characters that arround our main character.
     *
     * @param board      board mxn gamezone
     * @param characters characters ArrayList
     * @param vertical   vertical position of our character
     * @param horizontal horizontal position of our character
     * @param r          it is distance we are looking for the other characters like a radius of a circle.
     * @return an Object array's ArrayList
     */
    public static ArrayList<Object[]> findCharacterForFunctions(String[][] board, ArrayList<Character> characters, int vertical, int horizontal, int r) {
        ArrayList<Object[]> returnCharacters = new ArrayList<>();
        for (int i = -r; i < r + 1; i++) {
            for (int j = -r; j < r + 1; j++) {
                try {
                    Object[] characterInformation = returnCharacter(board, board[vertical + i][horizontal + j], characters);
                    if (characterInformation != null && ((Character) characterInformation[0]).getID().equals(board[vertical + i][horizontal + j])) {
                        returnCharacters.add(characterInformation);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }
        return returnCharacters;
    }
}
