import java.io.IOException;

public class Main {
    /**
     * Main Function
     *
     * @param args Terminal Arguments
     * @throws IOException to handle the exceptions
     */
    public static void main(String[] args) throws IOException {
        FileOutput.output(args[3], ReadingCommandsFile.readCommands(args[0], args[1], args[2]));
    }
}
