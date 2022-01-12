import Args.Commands;
import Args.Initials;
import File.File;

import Map.Board;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] board = new String[1][1];
        board = Board.addCharactersToBoard(board, File.input(args[0]));
        Initials.createCharacters(board, args[0]);
        File.output(args[2], Commands.commands(board, args[1], args[0]));
    }
}
