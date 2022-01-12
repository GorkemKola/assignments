import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileInput {
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
}