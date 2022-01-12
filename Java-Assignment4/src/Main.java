import java.util.ArrayList;

public class Main {
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        String finalText;

        ArrayList<String> parts = File.input(args[0]);
        ArrayList<String> items = File.input(args[1]);
        ArrayList<String> tokens = File.input(args[2]);
        ArrayList<String> tasks = File.input(args[3]);

        Queue<Token> tokensQueue = Functions.createTokens(tokens);
        Stack<Item> itemsStack = Functions.createItems(items);
        Stack<Part> partsStack = Functions.createParts(parts, itemsStack);
        finalText = Functions.doTasks(tasks, partsStack, tokensQueue);
        File.output(args[4], finalText);
    }
}
