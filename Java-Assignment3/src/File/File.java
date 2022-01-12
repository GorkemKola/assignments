package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    /**
     * A function that returns File as an ArrayList
     *
     * @param path File's Path
     * @return An ArrayList holding the lines of File
     */
    public static ArrayList<String> input(String path) {
        String line;
        ArrayList<String> List = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                List.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }

    /**
     * Writes a file at the address which stated with path
     *
     * @param path   the Output File's path
     * @param output the name of Output File
     * @throws IOException to handle the exceptions
     */
    public static void output(String path, String output) throws IOException {
        FileWriter outputFile = new FileWriter(path);
        outputFile.write(output);
        outputFile.close();
    }
}