package Functions;

import Pieces.Character;
import Pieces.Zorde.Zorde;

import java.util.ArrayList;

public class CharacterFunctions {
    /**
     * This function is to make characters regular attacks.
     *
     * @param board      mxn gamezone
     * @param characters character ArrayList
     * @param vertical   the vertical position of the attacker
     * @param horizontal the horizontal position of the attacker
     */
    public static void normalAttack(String[][] board, ArrayList<Character> characters, int vertical, int horizontal) {
        ArrayList<Object[]> characterArrayList = FindCharacter.findCharacterForFunctions(board, characters, vertical, horizontal, 1);
        Object[] characterInformation = FindCharacter.returnCharacter(board, board[vertical][horizontal], characters);
        Character character = (Character) characterInformation[0];
        for (Object[] character1Information : characterArrayList) {
            Character character1 = (Character) character1Information[0];
            int i = (Integer) character1Information[1];
            int j = (Integer) character1Information[2];
            character1.healthDecrease(character);
            if (character1.getIndividualHP() <= 0) {
                board[i][j] = "  ";
                characters.remove(character1);
            }
        }
    }

    /**
     * This function is to make Archer ranged attack.
     *
     * @param board      mxn gamezone
     * @param characters character ArrayList
     * @param vertical   the vertical position of the attacker
     * @param horizontal the horizontal position of the attacker
     */
    public static void rangedAttack(String[][] board, ArrayList<Character> characters, int vertical, int horizontal) {
        ArrayList<Object[]> characterArrayList = FindCharacter.findCharacterForFunctions(board, characters, vertical, horizontal, 2);
        for (Object[] characterInformation : characterArrayList) {
            Character character = (Character) characterInformation[0];
            int i = (Integer) characterInformation[1];
            int j = (Integer) characterInformation[2];
            if (character instanceof Zorde) {
                character.setIndividualHP(character.getIndividualHP() - 15);
            }
            if (character.getIndividualHP() <= 0) {
                board[i][j] = "  ";
                characters.remove(character);
            }
        }
    }

    /**
     * This function is to fight characters until one of them die
     *
     * @param character   attacker
     * @param character1  defender
     * @param characters  character ArrayList
     * @param board       mxn gamezone
     * @param vertical    the vertical position of the attacker
     * @param horizontal  the horizontal position of the attacker
     * @param vertical1   the vertical position of the defender
     * @param horizontal1 the horizontal position of the defender
     */
    public static void fightToDeath(Character character, Character character1, ArrayList<Character> characters, String[][] board, int vertical, int horizontal, int vertical1, int horizontal1) {
        character1.setIndividualHP(character1.getIndividualHP() - character.getAP());
        board[vertical][horizontal] = "  ";
        if (character1.getIndividualHP() <= 0) {
            characters.remove(character1);
            board[vertical1][horizontal1] = character.getID();
        } else if (character1.getIndividualHP() > character.getIndividualHP()) {
            characters.remove(character);
            character1.setIndividualHP(character1.getIndividualHP() - character.getIndividualHP());
            board[vertical1][horizontal1] = character1.getID();
        } else if (character.getIndividualHP() > character1.getIndividualHP()) {
            characters.remove(character1);
            character.setIndividualHP(character.getIndividualHP() - character1.getIndividualHP());
            board[vertical1][horizontal1] = character.getID();
        } else {
            characters.remove(character);
            characters.remove(character1);
            board[vertical1][horizontal1] = "  ";
        }
    }

    /**
     * This function is to make Ork heals Zordes.
     *
     * @param board
     * @param characters
     * @param vertical
     * @param horizontal
     */
    public static void heal(String[][] board, ArrayList<Character> characters, int vertical, int horizontal) {
        ArrayList<Object[]> characterArrayList = FindCharacter.findCharacterForFunctions(board, characters, vertical, horizontal, 1);
        for (Object[] characterInformation : characterArrayList) {
            Character character = (Character) characterInformation[0];
            character.healthIncrease();
        }
    }
}
