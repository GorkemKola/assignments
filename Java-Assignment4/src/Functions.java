import java.util.ArrayList;
import java.util.Comparator;


public class Functions {
    /**
     * this function is to create a stack of items
     *
     * @param items A string arraylist from items.txt
     * @return A stack of item objects
     */
    public static Stack<Item> createItems(ArrayList<String> items) {
        Stack<Item> items1 = new Stack<>();
        for (String string : items) {
            String[] line = string.split(" ");
            Item item = new Item(line[0], line[1]);
            items1.push(item);
        }
        return items1;
    }

    /**
     * this function is to create a stack of parts
     *
     * @param parts A string arraylist from parts.txt
     * @param items A stack of item objects
     * @return A stack of part objects
     */
    public static Stack<Part> createParts(ArrayList<String> parts, Stack<Item> items) {
        Stack<Part> parts1 = new Stack<>();
        for (String string : parts) {
            Part part = new Part(string.trim());
            for (Item item : items) {
                if (item.getSPECIES().equals(string.trim())) {
                    part.addItems(item);
                }
            }
            parts1.push(part);
        }
        return parts1;
    }

    /**
     * @param tasks  A string arraylist from tasks.txt
     * @param parts  A stack of part objects
     * @param tokens A queue of token objects
     * @return A string to write output
     */
    public static String doTasks(ArrayList<String> tasks, Stack<Part> parts, Queue<Token> tokens) {
        String str = "";
        for (String string : tasks) {
            String[] line = string.split("\t");
            switch (line[0]) {
                case "BUY":
                    for (int i = 1; i < line.length; i++) {
                        String[] task = line[i].split(",");
                        for (Part part : parts) {
                            if (part.SPECIES.equals(task[0])) {
                                for (int j = 0; j < Integer.parseInt(task[1]); j++) {
                                    part.items.pop();
                                }
                                delTokens(Integer.parseInt(task[1]), tokens, task[0]);
                            }
                        }
                    }
                    break;
                case "PUT":
                    for (int i = 1; i < line.length; i++) {
                        String[] task = line[i].split(",");
                        for (Part part : parts) {
                            if (part.SPECIES.equals(task[0])) {
                                for (int j = 1; j < task.length; j++) {
                                    Item item = new Item(task[j], task[0]);
                                    part.items.push(item);
                                }
                            }
                        }
                    }
                    break;
            }
        }
        for (Part part : parts) {
            str += part.toString();
        }
        str += "Token Box:\n";
        tokens.queue().sort(new Comparator<Token>() {
            @Override
            public int compare(Token o1, Token o2) {
                if (o1.number == o2.number) {
                    return -1;
                }
                return Integer.compare(o1.number, o2.number);
            }
        });
        for (Token token : tokens.queue()) {
            str += token.toString();
        }
        return str;
    }

    /**
     * this function is to create a stack of queue
     *
     * @param tokens A string arraylist from tokens.txt
     * @return A queue of token objects
     */
    public static Queue<Token> createTokens(ArrayList<String> tokens) {
        Queue<Token> tokens1 = new Queue<>();
        for (String string : tokens) {
            String[] line = string.split(" ");
            Token token = new Token(line[0], line[1], Integer.parseInt(line[2]));
            tokens1.enqueue(token);
        }
        tokens1.queue().sort(new Comparator<Token>() {
            /**
             * this is compare function from Comparator class
             *
             * @param token1 a token object
             * @param token2 a token object
             * @return a number to sort a list
             */
            @Override
            public int compare(Token token1, Token token2) {
                return token2.number - token1.number;
            }
        });
        return tokens1;
    }

    /**
     * this function is to delete a token from a queue of token objects
     *
     * @param b       shows how many items bought
     * @param tokens  A queue of token objects
     * @param species species of item bought
     */
    public static void delTokens(int b, Queue<Token> tokens, String species) {
        ArrayList<Token> arrayList = new ArrayList<>();
        for (int i = 0; i < tokens.queue().size(); i++) {
            if (tokens.queue().get(i).SPECIES.equals(species)) {
                arrayList.add(tokens.queue().get(i));
            }
        }
        arrayList.sort(new Comparator<Token>() {
            @Override
            public int compare(Token o1, Token o2) {
                return Integer.compare(o2.number, o1.number);
            }
        });
        int x = arrayList.get(0).number - b;
        Token y = arrayList.get(0);
        if (x > 0) {
            arrayList.get(0).number = x;
            tokens.enqueue(arrayList.get(0));
            tokens.queue().remove(y);
        } else if (x == 0) {
            tokens.queue().remove(y);
        } else {
            tokens.queue().remove(y);
            delTokens(-x, tokens, species);
        }
    }
}
