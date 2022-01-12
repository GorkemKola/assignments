package Args;
// Since I used packages I have lots of import files here.

import File.File;
import Pieces.Calliance.Dwarf;
import Pieces.Calliance.Elf;
import Pieces.Calliance.Human;
import Pieces.Character;
import Pieces.Constants;
import Pieces.Zorde.Goblin;
import Pieces.Zorde.Ork;
import Pieces.Zorde.Troll;

import java.util.ArrayList;

public class Initials extends File {
    /**
     * This function create characters and put them on the game area.
     *
     * @param board mxn game area
     * @param path  initials path
     * @return a Character arraylist
     */
    public static ArrayList<Character> createCharacters(String[][] board, String path) {
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<String> initials = File.input(path);
        int i;
        for (i = 0; i < initials.size(); i++) {
            String[] line = initials.get(i).split(" ");
            if (line[0].equals("ELF") || line[0].equals("ORK") || line[0].equals("HUMAN") ||
                    line[0].equals("GOBLIN") || line[0].equals("DWARF") || line[0].equals("TROLL")) {
                board[Integer.parseInt(line[3])][Integer.parseInt(line[2])] = line[1];
            }
            switch (line[0]) {
                case "ELF":
                    Elf elf = new Elf();
                    elf.setID(line[1]);
                    elf.setAP(Constants.elfAP);
                    elf.setRangedAP(Constants.elfRangedAP);
                    elf.setMaxMove(Constants.elfMaxMove);
                    elf.setMaxHP(Constants.elfHP);
                    elf.setIndividualHP(Constants.elfHP);
                    characters.add(elf);
                    break;

                case "ORK":
                    Ork ork = new Ork();
                    ork.setID(line[1]);
                    ork.setAP(Constants.orkAP);
                    ork.setHealPower(Constants.orkHealPoints);
                    ork.setMaxMove(Constants.orkMaxMove);
                    ork.setMaxHP(Constants.orkHP);
                    ork.setIndividualHP(Constants.orkHP);
                    characters.add(ork);
                    break;

                case "GOBLIN":
                    Goblin goblin = new Goblin();
                    goblin.setID(line[1]);
                    goblin.setAP(Constants.goblinAP);
                    goblin.setMaxMove(Constants.goblinMaxMove);
                    goblin.setMaxHP(Constants.goblinHP);
                    goblin.setIndividualHP(Constants.goblinHP);
                    characters.add(goblin);
                    break;

                case "HUMAN":
                    Human human = new Human();
                    human.setID(line[1]);
                    human.setAP(Constants.humanAP);
                    human.setMaxMove(Constants.humanMaxMove);
                    human.setMaxHP(Constants.humanHP);
                    human.setIndividualHP(Constants.humanHP);
                    characters.add(human);
                    break;

                case "DWARF":
                    Dwarf dwarf = new Dwarf();
                    dwarf.setID(line[1]);
                    dwarf.setAP(Constants.dwarfAP);
                    dwarf.setMaxMove(Constants.dwarfMaxMove);
                    dwarf.setMaxHP(Constants.dwarfHP);
                    dwarf.setIndividualHP(Constants.dwarfHP);
                    characters.add(dwarf);
                    break;

                case "TROLL":
                    Troll troll = new Troll();
                    troll.setID(line[1]);
                    troll.setAP(Constants.trollAP);
                    troll.setMaxMove(Constants.trollMaxMove);
                    troll.setMaxHP(Constants.trollHP);
                    troll.setIndividualHP(Constants.trollHP);
                    characters.add(troll);
                    break;
            }
        }
        return characters;
    }
}
