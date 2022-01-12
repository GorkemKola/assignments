import java.io.FileWriter;
import java.io.IOException;


public class FileOutput {

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