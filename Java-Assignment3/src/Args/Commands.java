package Args;
// Since I used packages I have lots of import files here.

import Exceptions.Exceptions;
import File.File;
import Functions.CharacterFunctions;
import Functions.FindCharacter;
import Functions.SortByID;
import Map.Board;
import Pieces.Calliance.Calliance;
import Pieces.Calliance.Elf;
import Pieces.Calliance.Human;
import Pieces.Character;
import Pieces.Zorde.Ork;
import Pieces.Zorde.Zorde;

import java.util.ArrayList;

/**
 * This class is to read commands file
 */
public class Commands extends File {
    /**
     * This function reads commands file.
     *
     * @param board        mxn game area (I know it will always be nxn but it does not matter for me).
     * @param pathcommands commands file's path.
     * @param pathinitials initials file's path.
     * @return String that will be write the output.
     */
    public static String commands(String[][] board, String pathcommands, String pathinitials) {
        StringBuilder finalText = new StringBuilder();
        ArrayList<String> commands = File.input(pathcommands);
        ArrayList<Character> characters = Initials.createCharacters(board, pathinitials);
        characters.sort(new SortByID());
        Board.printBoard(board, finalText, characters);
        for (String commandLine : commands) {
            boolean is_Map_Changed = false;
            String[] command = commandLine.trim().split(" ");
            String[] moves = command[1].split(";");
            try {
                for (int i = 0; i < moves.length; i += 2) {
                    try {
                        Object[] character_informations = FindCharacter.returnCharacter(board, command[0], characters);
                        Character character = (Character) character_informations[0];
                        int j = (Integer) character_informations[1];
                        int k = (Integer) character_informations[2];

                        if (character.getMaxMove() != moves.length / 2)
                            throw new Exceptions.MoveCounterException();
                        if (character instanceof Ork) {
                            CharacterFunctions.heal(board, characters, j, k);
                        }
                        ArrayList<Character> characterArrayList = (ArrayList<Character>) characters.clone(); //I created this not to throw ConcurrentModificationException
                        for (Character character1 : characterArrayList) {
                            if (board[j + Integer.parseInt(moves[i + 1])][k + Integer.parseInt(moves[i])].equals("  ")) {
                                is_Map_Changed = true;
                                board[j][k] = "  ";
                                board[j + Integer.parseInt(moves[i + 1])][k + Integer.parseInt(moves[i])] = command[0];
                                if (character instanceof Elf && i == moves.length - 2) {
                                    CharacterFunctions.rangedAttack(board, characters, j + Integer.parseInt(moves[i + 1]), k + Integer.parseInt(moves[i]));
                                } else if (character instanceof Human) {
                                    if (moves.length - 2 == i) {
                                        CharacterFunctions.normalAttack(board, characters, j + Integer.parseInt(moves[i + 1]), k + Integer.parseInt(moves[i]));
                                    }
                                } else {
                                    CharacterFunctions.normalAttack(board, characters, j + Integer.parseInt(moves[i + 1]), k + Integer.parseInt(moves[i]));
                                }
                            } else if (character1.getID().equals(board[j + Integer.parseInt(moves[i + 1])][k + Integer.parseInt(moves[i])]) && command[0].equals(board[j][k])) {
                                if ((character instanceof Calliance && character1 instanceof Calliance) || (character instanceof Zorde && character1 instanceof Zorde)) {
                                    throw new Exceptions.MoveFinished();
                                } else {
                                    CharacterFunctions.fightToDeath(character, character1, characters, board, j, k, j + Integer.parseInt(moves[i + 1]), k + Integer.parseInt(moves[i]));
                                    is_Map_Changed = true;
                                    throw new Exceptions.MoveFinished();
                                }
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new Exceptions.OutOfBordersException();
                    }

                }

            } catch (Exceptions.MoveCounterException e) {
                finalText.append("\nError : Move sequence contains wrong number of move steps. Input line ignored.\n");
            } catch (Exceptions.MoveFinished e) {
                //
            } catch (Exceptions.OutOfBordersException e) {
                if (is_Map_Changed) {
                    finalText.append("\n");
                    Board.printBoard(board, finalText, characters);
                }
                finalText.append("\nError : Game board boundaries are exceeded. Input line ignored.\n");
                continue;
            }

            if (is_Map_Changed) {
                finalText.append("\n");
                Board.printBoard(board, finalText, characters);
            }
            boolean isZordeThere = false;
            boolean isCallianceThere = false;
            for (Character character : characters) {
                if (character instanceof Zorde)
                    isZordeThere = true;
                else
                    isCallianceThere = true;
            }
            if (!isCallianceThere) {
                finalText.append("\nGame Finished\n");
                finalText.append("Zorde Wins");
                break;
            }
            if (!isZordeThere) {
                finalText.append("\nGame Finished\n");
                finalText.append("Calliance Wins");
                break;
            }
        }
        return finalText.toString();
    }
}