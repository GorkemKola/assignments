package Map;

import Pieces.Character;

import java.util.ArrayList;

public class Board {
    /**
     * This function creates the board.
     *
     * @param x horizontal length
     * @param y vertical length
     * @return String Array's Array that includes gamezone
     */
    public static String[][] createBoard(int x, int y) {
        String[][] board = new String[y][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[j][i] = "  ";
            }
        }
        return board;
    }

    /**
     * This function is to put characters to the board.
     *
     * @param board    gamezone
     * @param initials initial positions
     * @return String Array's Array that includes gamezone
     */
    public static String[][] addCharactersToBoard(String[][] board, ArrayList<String> initials) {
        for (int i = 0; i < initials.size(); i++) {
            String[] line = initials.get(i).split(" ");
            if (line[0].equals("BOARD")) {
                String[] createMap = initials.get(i + 1).split("x");
                board = Board.createBoard(Integer.parseInt(createMap[0]), Integer.parseInt(createMap[1]));
            }
        }
        return board;
    }

    /**
     * This function adds characters to finalText.
     *
     * @param board      mxn gamezone
     * @param finalText  a String builder that will be used to print out.
     * @param characters characters ArrayList
     */
    public static void printBoard(String[][] board, StringBuilder finalText, ArrayList<Character> characters) {
        for (int i = 0; i < board.length + 1; i++) {
            finalText.append("**");
        }
        finalText.append("\n");
        for (String[] strings : board) {
            finalText.append("*");
            for (String string : strings) {
                finalText.append(string);
            }
            finalText.append("*\n");
        }
        for (int i = 0; i < board.length + 1; i++) {
            finalText.append("**");
        }
        finalText.append("\n\n");
        for (Character character : characters) {
            finalText.append(character.toString());
        }
    }
}